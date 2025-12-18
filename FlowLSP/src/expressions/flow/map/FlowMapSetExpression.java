package expressions.flow.map;

import com.wm.app.b2b.server.ns.Namespace;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapSet;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSRecord;

import expressions.NSFieldTypeMapper;
import expressions.ParameterDeclaration;
import expressions.VariableResolver;

public class FlowMapSetExpression extends FlowMapExpression{

	String fieldPath;
	String value;
	VariableResolver variableResolver;
	
	public FlowMapSetExpression(String fieldPath, String value) {
		super();
		this.fieldPath = fieldPath;
		this.value = value;
	}
	
	public FlowMapSetExpression(String fieldPath, String value, VariableResolver variableResolver) {
		super();
		this.fieldPath = fieldPath;
		this.value = value;
		this.variableResolver = variableResolver;
	}
	
	public void setVariableResolver(VariableResolver variableResolver) {
		this.variableResolver = variableResolver;
	}
	
	public String getFieldPath() {
		return fieldPath;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public FlowElement getFlowElement() {
		FlowMapSet setData = new FlowMapSet(null);
		setData.setField(getNSFieldPath(fieldPath));
		setData.setVariables(false);
		setData.setOverwrite(true);
		setData.setGlobalVariables(false);
		setData.setName("Setter");
		setData.setInputType(getNSField(fieldPath));

		
		IData data = IDataFactory.create();
		IDataUtil.put(data.getCursor(), "xml", value);
		setData.setInput(value);
		return setData;
	}
	
	private NSField getNSField(String path) {
		if(path==null || path.isBlank()) {
			return null;
		}
		String[] split = path.split("/");
		if(split.length>=1) {
			// Get type information for the field
			int fieldType = NSField.FIELD_STRING; // Default
			int dimension = NSField.DIM_SCALAR; // Default
			
			if (variableResolver != null) {
				ParameterDeclaration param = variableResolver.resolveVariable(path);
				if (param != null) {
					fieldType = NSFieldTypeMapper.getNSFieldType(param);
					dimension = NSFieldTypeMapper.getNSFieldDimension(param);
				}
			}
			
			NSField field =  new NSField(Namespace.current(), NSRecord.TYPE, split[split.length-1], fieldType, dimension);
			return field;
		}
		
		return null;
	}
	
	private String getNSFieldPath(String path) {
		if(path==null || path.isBlank()) {
			return null;
		}
		String[] split = path.split("/");
		if(split.length>=1) {
			int count =0;
			NSField previous = null;
			String nspath= "";
			for (int i = split.length-1; i >=0; i--) {
				if(count==0) {
					// Get type information for the leaf field
					int fieldType = NSField.FIELD_STRING; // Default
					int dimension = NSField.DIM_SCALAR; // Default
					
					if (variableResolver != null) {
						ParameterDeclaration param = variableResolver.resolveVariable(path);
						if (param != null) {
							fieldType = NSFieldTypeMapper.getNSFieldType(param);
							dimension = NSFieldTypeMapper.getNSFieldDimension(param);
						}
					}
					
					NSField field =  new NSField(Namespace.current(), NSRecord.TYPE, split[i], fieldType, dimension);
					previous=field;
				}else {
					// Get dimension for parent record
					int recordDimension = NSField.DIM_SCALAR; // Default
					
					if (variableResolver != null) {
						// Build path up to this level
						StringBuilder partialPath = new StringBuilder();
						for (int j = 0; j <= i; j++) {
							if (j > 0) partialPath.append("/");
							partialPath.append(split[j]);
						}
						
						ParameterDeclaration param = variableResolver.resolveVariable(partialPath.toString());
						if (param != null) {
							recordDimension = NSFieldTypeMapper.getNSFieldDimension(param);
						}
					}
					
					NSRecord nsRecord =  new NSRecord(Namespace.current(), split[i], recordDimension);
					nsRecord.addField(previous);
					previous.setParent(nsRecord);
					nspath=previous.getPath()+nspath;
					previous=nsRecord;
				}
				count++;
			}
			if(previous!=null) {
				previous.setParent(new NSRecord(Namespace.current()));
				nspath=previous.getPath()+nspath;
				return nspath;
			}
		}
		
		return null;
	}
}
