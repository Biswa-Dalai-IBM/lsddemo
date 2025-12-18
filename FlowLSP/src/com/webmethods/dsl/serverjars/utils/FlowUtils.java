package com.webmethods.dsl.serverjars.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.wm.app.b2b.client.ns.NSNodeFactory;
import com.wm.app.b2b.server.ACLManager;
import com.wm.app.b2b.server.BaseService;
import com.wm.app.b2b.server.FlowServiceFactory;
import com.wm.app.b2b.server.FlowSvcImpl;
import com.wm.app.b2b.server.Package;
import com.wm.app.b2b.server.PackageManager;
import com.wm.app.b2b.server.PackageStore;
import com.wm.app.b2b.server.Server;
import com.wm.app.b2b.services.NodeInfo;
import com.wm.app.b2b.util.ServerIf;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowRoot;
import com.wm.lang.flow.FlowService;
import com.wm.lang.ns.NSJMSTrigger;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.NSNode;
import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSService;
import com.wm.lang.ns.NSServiceType;
import com.wm.lang.ns.NSTriggerType;
import com.wm.lang.ns.NSType;
import com.wm.lang.ns.Namespace;
import com.wm.util.QName;
import com.wm.util.Values;
import com.wm.util.codec.Base64;
import com.wm.util.coder.IDataBinCoder;
import com.wm.util.coder.XMLCoder;

public class FlowUtils{
	
	public static FlowService loadFlowService(InputStream flow_xml, InputStream node_ndf,String packageName, String nsname, Namespace namespace,IData serviceInfo) throws IOException {
		InputStream loadFlowService = loadFlowService(packageName,nsname,flow_xml,node_ndf,serviceInfo);
		if(loadFlowService!=null){
			XMLCoder coder = new XMLCoder();
			try {
				Values decode = coder.decode(loadFlowService);
				NSServiceType nsServiceType = new NSServiceType();
				nsServiceType.setType(NSServiceType.SVC_FLOW);
				nsServiceType.setSubtype("default"); //$NON-NLS-1$
				NSNode nsNode = NSNodeFactory.getInstance().create(nsServiceType, namespace, decode, null);
				loadFlowService.close();
				return (FlowService) nsNode;
			} catch (Exception e) {
				//LogHelper.logError(e.getLocalizedMessage(), e, ServerJarsPlugin.PLUGIN_ID);
			} 
		}
		return null;

	}

	

	
	public static InputStream loadFlowService(String  packageName , 
			String nsname,InputStream flow_xml, InputStream node_ndf,IData serviceInfo) throws IOException {
		InputStream loadFlowService = null;
		File tempDir = getTempDir();
		File flowTemp = new File(tempDir,PackageStore.FLW_FILE);
		if(flowTemp.exists()){
			flowTemp.delete();
		}
		File ndfTemp = new File(tempDir,PackageStore.NDF_FILE);
		if(ndfTemp.exists()){
			ndfTemp.delete();
		}
		try {
			Files.copy(flow_xml, flowTemp.toPath());
			Files.copy(node_ndf, ndfTemp.toPath());
			loadFlowService = loadFlowService(tempDir, packageName,nsname,serviceInfo);
			Files.delete(flowTemp.toPath());
			Files.delete(ndfTemp.toPath());
		} catch (IOException e) {
			//LogHelper.logError(e.getLocalizedMessage(), e, ServerJarsPlugin.PLUGIN_ID);
		}
		return loadFlowService;
	}
	
	public static NSRecord loadDocType(String  packageName , 
			String nsname, InputStream node_ndf,Namespace namespace) throws IOException {
		NSRecord nsRecord = null;
		File tempDir = getTempDir();
		File ndfTemp = new File(tempDir,PackageStore.NDF_FILE);
		if(ndfTemp.exists()){
			ndfTemp.delete();
		}
		try {
			Files.copy(node_ndf, ndfTemp.toPath());
			XMLCoder coder = new XMLCoder();
			Values readFromFile = coder.readFromFile(ndfTemp);
			IData object = IDataUtil.getIData(readFromFile.getCursor(), "record");
			nsRecord = NSRecord.createRecord(namespace, Values.use(object));
			Files.delete(ndfTemp.toPath());
		} catch (IOException e) {
			//LogHelper.logError(e.getLocalizedMessage(), e, ServerJarsPlugin.PLUGIN_ID);
		}
		return nsRecord;
	}
	
	public static NSService loadAdapterService(String  packageName , 
			String nsname, InputStream node_ndf,Namespace namespace,IData serviceInfo) throws IOException {
		NSService nsService = null;
		File tempDir = getTempDir();
		File ndfTemp = new File(tempDir,PackageStore.NDF_FILE);
		if(ndfTemp.exists()){
			ndfTemp.delete();
		}
		try {
			Files.copy(node_ndf, ndfTemp.toPath());
			XMLCoder coder = new XMLCoder();
			Values readFromFile = coder.readFromFile(ndfTemp);
			IDataCursor cursor = readFromFile.getCursor();
			String nodePropertiesString = IDataUtil.getString(cursor, "IRTNODE_PROPERTY");
			IData nodeProperties = stringToIDataNodeProperties(nodePropertiesString);
			cursor.insertAfter("IRTNODE_PROPERTIES", nodeProperties);
			IDataUtil.remove(cursor, "caching");
			IDataUtil.remove(cursor, "prefetch");
			IDataUtil.remove(cursor, "cache_ttl");
			IDataUtil.remove(cursor, "retry_max");
			IDataUtil.remove(cursor, "retry_interval");
			IDataUtil.remove(cursor, "prefetch_level");
			IDataUtil.remove(cursor, "system_service");
			IDataUtil.remove(cursor, "audit_level");
			
			cursor.destroy();
			
			BaseService baseService = new NodeInfo(NSServiceType.create(ServerIf.NSTYPE_ADAPTER_SERVICE,NSTriggerType.UNKNOWN));
			baseService.setNodeValues(readFromFile);
			baseService.setNSName(NSName.create(nsname));
			serviceInfo(baseService,serviceInfo);

			nsService = (NSService) NSNodeFactory.getInstance().create(NSServiceType.create(ServerIf.NSTYPE_ADAPTER_SERVICE,NSTriggerType.UNKNOWN), namespace, readFromFile, null);
			Files.delete(ndfTemp.toPath());
		} catch (IOException e) {
			//LogHelper.logError(e.getLocalizedMessage(), e, ServerJarsPlugin.PLUGIN_ID);
		}
		return nsService;
	}
	
	public static NSNode loadAdapterNotification(String  packageName , 
			String nsname, InputStream node_ndf,Namespace namespace,String type) throws IOException {
		NSNode nsService = null;
		File tempDir = getTempDir();
		File ndfTemp = new File(tempDir,PackageStore.NDF_FILE);
		if(ndfTemp.exists()){
			ndfTemp.delete();
		}
		try {
			Files.copy(node_ndf, ndfTemp.toPath());
			XMLCoder coder = new XMLCoder();
			Values readFromFile = coder.readFromFile(ndfTemp);
			IDataCursor cursor = readFromFile.getCursor();
			String nodePropertiesString = IDataUtil.getString(cursor, "IRTNODE_PROPERTY");
			IData nodeProperties = stringToIDataNodeProperties(nodePropertiesString);
			cursor.insertAfter("IRTNODE_PROPERTIES", nodeProperties);
			cursor.destroy();
			
			nsService = (NSNode) NSNodeFactory.getInstance().create(NSType.create(type), namespace, readFromFile, null);
			Files.delete(ndfTemp.toPath());
		} catch (IOException e) {
			//LogHelper.logError(e.getLocalizedMessage(), e, ServerJarsPlugin.PLUGIN_ID);
		}
		return nsService;
	}
	
	private static IData stringToIDataNodeProperties(String encodedData) {
		ByteArrayInputStream bis = null;
		try {
			IDataBinCoder coder = new IDataBinCoder();
			bis   = new ByteArrayInputStream(Base64.decode(encodedData.getBytes("UTF8")));
			return coder.decode(bis);
		} catch (Throwable t) {
		} finally {
			if (bis != null) {
				try {bis.close();} 
				catch (Throwable tt) {}
				bis=null;
			}
		}
		return null;

	}
	 
	public static NSJMSTrigger loadJMSTrigger(String  packageName , 
			String nsname, InputStream node_ndf,Namespace namespace) throws IOException {
		NSJMSTrigger nsRecord = null;
		File tempDir = getTempDir();
		File ndfTemp = new File(tempDir,PackageStore.NDF_FILE);
		if(ndfTemp.exists()){
			ndfTemp.delete();
		}
		try {
			Files.copy(node_ndf, ndfTemp.toPath());
			XMLCoder coder = new XMLCoder();
			Values readFromFile = coder.readFromFile(ndfTemp);
			//IData object = IDataUtil.getIData(readFromFile.getCursor(), "record");
			nsRecord = (NSJMSTrigger) NSNodeFactory.getInstance().create(NSTriggerType.create(NSTriggerType.JMS_TRIGGER,NSTriggerType.UNKNOWN), namespace, readFromFile, null);
			Files.delete(ndfTemp.toPath());
		} catch (IOException e) {
			//LogHelper.logError(e.getLocalizedMessage(), e, ServerJarsPlugin.PLUGIN_ID);
		}
		return nsRecord;
	}

	public static InputStream loadFlowService(File flowDir, String packageName ,
			String nsname,IData serviceInfo) {
		XMLCoder coder = new XMLCoder();
		FlowSvcImpl flowSvcImpl = new FlowSvcImpl(Values.use(IDataFactory.create()));
		File flow = new File(flowDir, PackageStore.FLW_FILE);
		try {
			Values loadFlow = flowSvcImpl.loadFlow(flow);
			FlowRoot flowRoot = new FlowRoot(loadFlow);
			
			FlowServiceFactory flowServiceFactory = new FlowServiceFactory();
			Values readFromFile = coder.readFromFile(new File(flowDir,PackageStore.NDF_FILE));
			Package package1 = getPackage(packageName);
			NSNode createFromNodeDef = flowServiceFactory.createFromNodeDef(package1, NSName.create(nsname), readFromFile);
			flowSvcImpl =	(FlowSvcImpl)createFromNodeDef;
			flowSvcImpl.setFlowRoot(flowRoot);
			Values values = flowSvcImpl.getValues();
			serviceInfo(flowSvcImpl,serviceInfo);
			
			
			byte[] encodeToBytes = coder.encodeToBytes(values);
			return new ByteArrayInputStream(encodeToBytes);
		} catch (Exception e) {
			//LogHelper.logError(e.getLocalizedMessage(), e, ServerJarsPlugin.PLUGIN_ID);
		}
		return null;
	}
	
	
	private static void serviceInfo (BaseService service, IData serviceInfo)
	{
		Values out = Values.use(serviceInfo);


		String fullname = service.getNSName().getFullName();

		// output QName information
		QName universalName = service.getUniversalName();
		if(universalName != null)
		{
			String universalNamespace = universalName.getNamespace();
			String universalNCName = universalName.getNCName();

			if(universalNamespace != null)
			{
				if( !universalNamespace.equals("") )
				{
					out.put("universalNamespace",universalNamespace);
				}
			}

			if(universalNCName != null)
			{
				out.put("universalNCName", universalNCName);
			}
		}

		// output basic descriptive properties that all services
		// share (name, package, etc.)
		out.put(ServerIf.GET_SVCINFO_STATELESS, new Boolean(service.isStateless()).toString());
		out.put( ServerIf.GET_SVCINFO_UNIVERSAL_NAME, service.getUniversalName() );
		out.put( ServerIf.GET_SVCINFO_ICONTEXT_POLICY, service.getIContextPolicy().toString());
		out.put( ServerIf.SVC_INVK_URL_ALIAS, service.getUrlInvokeAlias());

		out.put( ServerIf.GET_SVCINFO_RETRY_MAX, service.getRetryMax()); 
		out.put( ServerIf.GET_SVCINFO_RETRY_INTERVAL, service.getRetryInterval());
		out.put( ServerIf.GET_SVCINFO_RETRY_PERIOD, service.getMaxRetryPeriod());

		// xml format
		out.put(ServerIf.GET_SVCINFO_XML_FORMAT, service.getXmlFormat());

		// caching status (time to live and on/off)
		out.put (ServerIf.GET_SVCINFO_CACHEEXP, service.getCacheTTL());
		out.put (ServerIf.GET_SVCINFO_CACHE, new Boolean(service.isCacheEnabled()).toString());

		// enforce acl checking on internal invokes?
		out.put (ServerIf.GET_SVCINFO_INTERNAL_ACL_CHECK,
				new Boolean(service.checkAclsInternally()).toString());

		// prefetching status (level and on/off)
		out.put (ServerIf.GET_SVCINFO_PREFETCHLVL, service.getPrefetchLevel());
		out.put (ServerIf.GET_SVCINFO_PREFETCH, new Boolean(service.isPrefetchEnabled()).toString());

		// audit level
		out.put (ServerIf.GET_SVCINFO_AUDITLVL, service.getAuditLevelStr());

		// ACL protection -- could be at the service or interface
		// level, or none at all
		String parentaclgroup = null;
		Values result = new Values();
		String aclgroup = ACLManager.getAclGroup (fullname, result);
		if (aclgroup == null) {
			out.put (ServerIf.GET_SVCINFO_SVCACLGROUP, "");
			aclgroup = parentaclgroup;
			out.put (ServerIf.GET_SVCINFO_IFCACLGROUP, (aclgroup == null ? "" : aclgroup));
		}
		if (aclgroup != null) {
			out.put(ServerIf.GET_SVCINFO_ACLGROUP, aclgroup);
		}
		else {
			out.put(ServerIf.GET_SVCINFO_ACLGROUP, ACLManager.defaultSystemACL);
		}


		out.put(ServerIf.GET_SVCINFO_PARENT_EXECUTEACLGROUP, ACLManager.defaultSystemACL);


		out.put(ServerIf.GET_SVCINFO_INHACLGROUP, result.getString(ServerIf.GET_SVCINFO_INHACLGROUP));

		// Browse ACL protection -- could be at the service or interface
		// level, or none at all
		result = new Values();
		String browseaclgroup = null;
		if (browseaclgroup == null) {
			out.put (ServerIf.GET_SVCINFO_SVCBROWSEACLGROUP, "");
			browseaclgroup = null;
			out.put (ServerIf.GET_SVCINFO_IFCBROWSEACLGROUP, (browseaclgroup == null ? "" : browseaclgroup));			}

		out.put(ServerIf.GET_SVCINFO_BROWSEACLGROUP, ACLManager.defaultSystemACL);

		out.put(ServerIf.GET_SVCINFO_PARENT_BROWSEACLGROUP, ACLManager.defaultSystemACL);

		out.put(ServerIf.GET_SVCINFO_INHBROWSEACLGROUP, result.getString(ServerIf.GET_SVCINFO_INHBROWSEACLGROUP));

		// Read ACL protection -- could be at the service or interface
		// level, or none at all
		result = new Values();
		String readaclgroup = ACLManager.getReadAclGroup (fullname, result);
		if (readaclgroup == null) {
			out.put (ServerIf.GET_SVCINFO_SVCREADACLGROUP, "");
			readaclgroup = null;
			out.put (ServerIf.GET_SVCINFO_IFCREADACLGROUP, (readaclgroup == null ? "" : readaclgroup));			}
		if (readaclgroup != null) {
			out.put(ServerIf.GET_SVCINFO_READACLGROUP, readaclgroup);
		}
		else {
			out.put(ServerIf.GET_SVCINFO_READACLGROUP, ACLManager.defaultSystemACL);
		}


		out.put(ServerIf.GET_SVCINFO_PARENT_READACLGROUP, ACLManager.defaultSystemACL);

		out.put(ServerIf.GET_SVCINFO_INHREADACLGROUP, result.getString(ServerIf.GET_SVCINFO_INHREADACLGROUP));

		// Write ACL protection -- could be at the service or interface
		// level, or none at all
		result = new Values();
		String writeaclgroup = ACLManager.getWriteAclGroup (fullname, result);
		if (writeaclgroup == null) {
			out.put (ServerIf.GET_SVCINFO_SVCWRITEACLGROUP, "");
			writeaclgroup = null;
			out.put (ServerIf.GET_SVCINFO_IFCWRITEACLGROUP, (writeaclgroup == null ? "" : writeaclgroup));
		}
		if (writeaclgroup != null) {
			out.put(ServerIf.GET_SVCINFO_WRITEACLGROUP, writeaclgroup);
		}
		else {
			out.put(ServerIf.GET_SVCINFO_WRITEACLGROUP, ACLManager.defaultSystemACL);
		}


		out.put(ServerIf.GET_SVCINFO_PARENT_WRITEACLGROUP, ACLManager.defaultSystemACL);

		out.put(ServerIf.GET_SVCINFO_INHWRITEACLGROUP, result.getString(ServerIf.GET_SVCINFO_INHWRITEACLGROUP));

		// template and binding information
		String template = service.getTemplate();
		String templtype = service.getTemplateType();
		String bindname = service.getBinding();
		if (template != null) out.put(ServerIf.GET_SVCINFO_TEMPLATE, template);
		if (bindname != null) out.put(ServerIf.GET_SVCINFO_BINDING, bindname);
		if (templtype == null) {
			out.put (ServerIf.GET_SVCINFO_TMPLTYPE, "html");
		} else
		{
			out.put( ServerIf.GET_SVCINFO_TMPLTYPE, templtype );
		}

		if(service.getTemplateFile()!=null && service.getTemplateFile().exists()){
			out.put (ServerIf.GET_SVCINFO_TMPL_EXISTS, new Boolean(true).toString());
		}else{
			out.put (ServerIf.GET_SVCINFO_TMPL_EXISTS, new Boolean(false).toString());
		}

		String defaultTemplate = fullname.replace('.', '_').replace(':','_');
		if (templtype != null) defaultTemplate += templtype;
		out.put (ServerIf.GET_SVCINFO_DEFAULTTMPL, defaultTemplate);

		// availability information
		out.put (ServerIf.GET_SVCINFO_AVAILABLE, new Boolean(service.isAvailable()).toString());
		out.put (ServerIf.GET_SVCINFO_COMMENT, service.getLoadErr());

	}
	
	public static File getTempDir() throws IOException{
		return Server.getHomeDir();
	}
	
	public static Package getPackage(String packageName) throws IOException{
		ServerUtils serverUtils = ServerUtils.getInstance();
		File sagtemp = Server.getHomeDir();
		File libFolder = new File(sagtemp,"lib");
		if(!libFolder.exists()) {
			libFolder.mkdir();
		}
		File tmplFile = new File(libFolder,"flow.tmpl");
		Files.copy(FlowUtils.class.getResourceAsStream("flow.tmpl"), tmplFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		serverUtils.configureTempPacakge(packageName);
		Package package1 = PackageManager.getPackage(packageName);
		return package1;
	}
}
