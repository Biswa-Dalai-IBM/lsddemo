package com.webmethods.dsl.serverjars.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

import com.wm.app.b2b.server.InvokeState;
import com.wm.app.b2b.server.PackageManager;
import com.wm.app.b2b.server.Resources;
import com.wm.app.b2b.server.Server;

public class ServerUtils {
	
	private static ServerUtils instance;
	
	private ServerUtils(File homeDir) {
		new Server(new String[]{});
		Server.setResources(new Resources(homeDir, true));
		InvokeState.create();
		PackageManager.init();
	}
	
	public static synchronized ServerUtils getInstance() throws IOException {
		if (instance == null) {
			File homeDir = getTempDir();
			instance = new ServerUtils(homeDir);
		}
		return instance;
	}

	public void configureTempPacakge(String packageName) {
		PackageManager.loadPackage(packageName);
	}
	
	private static File getTempDir() throws IOException{
		// 1. Create the temporary directory with a prefix
        Path tempDir = Files.createTempDirectory("myAppTemp-");
        System.out.println("Temporary directory created at: " + tempDir);

        // 2. Register a shutdown hook to delete the directory and its contents
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (Stream<Path> walk = Files.walk(tempDir)) {
                walk.sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println("Deleted: " + path);
                        } catch (IOException e) {
                            System.err.println("Failed to delete: " + path + " - " + e.getMessage());
                        }
                    });
            } catch (IOException e) {
                System.err.println("Error walking directory for deletion: " + e.getMessage());
            }
            System.out.println("Shutdown hook finished.");
        }));
        
        
		return tempDir.toFile();
	}
	/**
	 * Recursively copies a directory from source to target location.
	 * 
	 * @param sourcePath the source directory path to copy from
	 * @param targetPath the target directory path to copy to
	 * @throws IOException if an I/O error occurs during copying
	 */
	public static void copyDirectory(String sourcePath, String targetPath) throws IOException {
		Path source = new File(sourcePath).toPath();
		Path target = new File(targetPath).toPath();
		
		// Validate source directory exists
		if (!Files.exists(source)) {
			throw new IOException("Source directory does not exist: " + sourcePath);
		}
		
		if (!Files.isDirectory(source)) {
			throw new IOException("Source path is not a directory: " + sourcePath);
		}
		
		// Create target directory if it doesn't exist
		if (!Files.exists(target)) {
			Files.createDirectories(target);
		}
		
		// Walk through the source directory tree and copy each file/directory
		try (Stream<Path> walk = Files.walk(source)) {
			walk.forEach(sourcePath1 -> {
				try {
					Path targetPath1 = target.resolve(source.relativize(sourcePath1));
					if (Files.isDirectory(sourcePath1)) {
						// Create directory if it doesn't exist
						if (!Files.exists(targetPath1)) {
							Files.createDirectories(targetPath1);
						}
					} else {
						// Copy file, replacing if it already exists
						Files.copy(sourcePath1, targetPath1, 
							java.nio.file.StandardCopyOption.REPLACE_EXISTING);
					}
				} catch (IOException e) {
					throw new RuntimeException("Failed to copy: " + sourcePath1, e);
				}
			});
		}
	}
	
	
}
