package com.webmethods.dsl.serverjars.utils;

import java.io.File;

import com.wm.app.b2b.server.PackageManager;
import com.wm.app.b2b.server.Resources;

public class LocalResources extends Resources {

	private File packagesDir;
	private File IS_RootDir;

	public LocalResources(File packagesDir, File IS_RoorDir) {
		super(packagesDir.getParent(), false);
		this.packagesDir = packagesDir;
		this.IS_RootDir = IS_RoorDir;
	}

	@Override
	public File getPackagesDir() {
		if (PackageManager.isOffline() && Boolean.getBoolean("IS.useRootDir")) {
			return super.getRootDir();
		} else {
			return packagesDir != null ? packagesDir : super.getPackagesDir();
		}
	}

	@Override
	public File getLibDir() {
		return super.getDir(IS_RootDir, "lib");
	}
}