package com.webmethods.dsl.serverjars.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.wm.app.b2b.server.FlowServiceFactory;
import com.wm.app.b2b.server.FlowSvcImpl;
import com.wm.app.b2b.server.Package;
import com.wm.app.b2b.server.PackageManager;
import com.wm.app.b2b.server.PackageStore;
import com.wm.app.b2b.server.Server;
import com.wm.data.IDataFactory;
import com.wm.lang.flow.FlowRoot;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.NSNode;
import com.wm.util.Values;
import com.wm.util.coder.XMLCoder;

public class FlowUtils {


	public static FlowSvcImpl loadFlowService(File flowDir, String packageName, String nsname) {
		XMLCoder coder = new XMLCoder();
		FlowSvcImpl flowSvcImpl = new FlowSvcImpl(Values.use(IDataFactory.create()));
		File flow = new File(flowDir, PackageStore.FLW_FILE);
		try {
			Values loadFlow = flowSvcImpl.loadFlow(flow);
			FlowRoot flowRoot = new FlowRoot(loadFlow);

			FlowServiceFactory flowServiceFactory = new FlowServiceFactory();
			Values readFromFile = coder.readFromFile(new File(flowDir, PackageStore.NDF_FILE));
			Package package1 = getPackage(packageName);
			NSNode createFromNodeDef = flowServiceFactory.createFromNodeDef(package1, NSName.create(nsname),
					readFromFile);
			flowSvcImpl = (FlowSvcImpl) createFromNodeDef;
			flowSvcImpl.setFlowRoot(flowRoot);

		} catch (Exception e) {
		}
		return flowSvcImpl;
	}


	public static File getTempDir() throws IOException {
		return Server.getHomeDir();
	}

	public static Package getPackage(String packageName) throws IOException {
		ServerUtils serverUtils = ServerUtils.getInstance();
		File sagtemp = Server.getHomeDir();
		File libFolder = new File(sagtemp, "lib");
		if (!libFolder.exists()) {
			libFolder.mkdir();
			File tmplFile = new File(libFolder, "flow.tmpl");
			Files.copy(FlowUtils.class.getResourceAsStream("flow.tmpl"), tmplFile.toPath(),
					StandardCopyOption.REPLACE_EXISTING);
		}
		serverUtils.configureTempPacakge(packageName);
		Package package1 = PackageManager.getPackage(packageName);
		return package1;
	}
}
