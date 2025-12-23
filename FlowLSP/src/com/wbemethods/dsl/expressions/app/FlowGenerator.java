package com.wbemethods.dsl.expressions.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowProgram;
import com.wbemethods.dsl.expressions.FlowServiceSignature;
import com.wbemethods.dsl.expressions.ParameterDeclaration;
import com.wbemethods.dsl.expressions.flow.FlowContainerExpression;
import com.webmethods.dsl.serverjars.utils.FlowUtils;
import com.webmethods.dsl.serverjars.utils.NSRecordUtils;
import com.webmethods.dsl.serverjars.utils.ServerUtils;
import com.wm.app.b2b.server.FlowManager;
import com.wm.app.b2b.server.FlowSvcImpl;
import com.wm.app.b2b.server.Package;
import com.wm.app.b2b.server.Server;
import com.wm.app.b2b.server.ns.Namespace;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowRoot;
import com.wm.lang.ns.CircuitBreakerConfig;
import com.wm.lang.ns.ConcurrentRequestLimitConfig;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSService;
import com.wm.lang.ns.NSServiceType;
import com.wm.lang.ns.NSSignature;

public class FlowGenerator {

	/**
	 * Generate flow with specified parameters
	 * 
	 * @param program      The flow program to generate
	 * @param targetFolder The target folder for output
	 * @param packageName  The package name (e.g., "test")
	 * @param nsname       The namespace name (e.g., "test:fs1")
	 * @param installRoot  Optional install root path
	 * @throws IOException
	 */
	public void generateFlow(FlowProgram program, File targetFolder, String packageName, String nsname,
			String installRoot) throws IOException {

		ServerUtils.getInstance();
		IData iData = IDataFactory.create();
		FlowRoot flowRoot = new FlowRoot(iData);

		List<FlowElementExpression> expressions = program.getExpressions();
		if (expressions.size() > 0) {
			generateFlow(expressions, flowRoot);
		}

		try {
			// Use provided package name and nsname
			Package package1 = FlowUtils.getPackage(packageName);
			NSName nsName = NSName.create(nsname);
			FlowManager.saveFlow(package1, flowRoot, nsName);

			// Build signature from program
			NSSignature sig = buildSignature(program);
			FlowSvcImpl flowSvcImpl = new FlowSvcImpl(package1, nsName, null);
			flowSvcImpl.setFlowRoot(flowRoot);
			flowSvcImpl.setSignature(sig);
			flowSvcImpl.setServiceType(NSServiceType.create(NSServiceType.SVC_FLOW, NSServiceType.SVCSUB_DEFAULT));
			flowSvcImpl.setServiceSigtype(NSService.SIG_JAVA_3_5);
			flowSvcImpl.setPipelineOption(NSService.NO_PIPELINE);
			CircuitBreakerConfig settings = new CircuitBreakerConfig();
			settings.setServiceToInvoke("");
			flowSvcImpl.setCircuitBreakerSettings(settings);
			flowSvcImpl.setConcurrentRequestLimitSettings(new ConcurrentRequestLimitConfig());
			package1.setServiceInfo(nsName, flowSvcImpl);

			// Extract folder name from nsname (e.g., "test:fs1" -> "fs1")
			String serviceName = nsname.contains(":") ? nsname.substring(nsname.indexOf(":") + 1) : nsname;
			String packagePath = nsname.contains(":") ? nsname.substring(0, nsname.indexOf(":")) : packageName;

			File packageNSDir = Server.getResources().getPackageNSDir(packageName);
			File file1 = new File(packageNSDir, packagePath + "/" + serviceName);
			ServerUtils.copyDirectory(file1.getAbsolutePath(), new File(targetFolder, serviceName).getAbsolutePath());
			ServerUtils.copyDirectory(Server.getResources().getPackageDir(packageName).getAbsolutePath(),
					new File(installRoot, "IntegrationServer/packages/" + packageName).getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generateFlow(List<FlowElementExpression> expressions, FlowElement element) {
		if (expressions == null || expressions.isEmpty()) {
			return;
		}
		for (FlowElementExpression expression : expressions) {
			if (expression instanceof FlowContainerExpression) {
				FlowContainerExpression containerExpression = (FlowContainerExpression) expression;
				containerExpression.addFlowElement(element);
			} else {
				FlowElement childElement = expression.getFlowElement();
				if (childElement != null) {
					element.addNode(childElement);
				}
			}

		}
	}

	/**
	 * Build NSSignature from FlowProgram signature
	 */
	private NSSignature buildSignature(FlowProgram program) {
		NSRecord inputRecord = new NSRecord(Namespace.current());
		NSRecord outputRecord = new NSRecord(Namespace.current());

		if (program.hasSignature()) {
			FlowServiceSignature signature = program.getSignature();

			// Build input record
			if (signature.hasInputParameters()) {
				for (ParameterDeclaration param : signature.getInputParameters()) {
					buildParameter(inputRecord, param);
				}
			}

			// Build output record
			if (signature.hasOutputParameters()) {
				for (ParameterDeclaration param : signature.getOutputParameters()) {
					buildParameter(outputRecord, param);
				}
			}
		}

		return new NSSignature(inputRecord, outputRecord);
	}

	/**
	 * Build a parameter (field, record, or recordList) and add it to the parent
	 * record
	 */
	private void buildParameter(NSRecord parent, ParameterDeclaration param) {
		if (param.isField()) {
			// Simple field
			NSRecordUtils.addFieldWithDimension(parent, param.getName(), param.getDataType(), param.getDimension());
		} else if (param.isRecord()) {
			// Record (not array)
			NSRecord nestedRecord = null;
			if(param.hasDocumentReference()) {
				nestedRecord = NSRecordUtils.addRecordRefField(parent, param.getName(), false,param.getDocumentReference());
			}else {
				nestedRecord = NSRecordUtils.addRecordField(parent, param.getName(), false);
			}
			// Add children to nested record
			if (param.hasChildren()) {
				for (ParameterDeclaration child : param.getChildren()) {
					buildParameter(nestedRecord, child);
				}
			}
		} else if (param.isRecordList()) {
			// RecordList (array of records)
			NSRecord nestedRecord = null;
			if(param.hasDocumentReference()) {
				nestedRecord = NSRecordUtils.addRecordRefField(parent, param.getName(), true,param.getDocumentReference());
			}else {
				nestedRecord = NSRecordUtils.addRecordField(parent, param.getName(), true);
			}
			// Add children to nested record
			if (param.hasChildren()) {
				for (ParameterDeclaration child : param.getChildren()) {
					buildParameter(nestedRecord, child);
				}
			}
		}
	}
}
