package expressions.flow.map;

import com.wm.app.b2b.server.ns.Namespace;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapCopy;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSRecord;

import expressions.NSFieldTypeMapper;
import expressions.ParameterDeclaration;
import expressions.VariableResolver;

public class FlowMapCopyExpression extends FlowMapExpression{
	
	String from;
	String to;
	VariableResolver variableResolver;
	
	public FlowMapCopyExpression(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public FlowMapCopyExpression(String from, String to, VariableResolver variableResolver) {
		super();
		this.from = from;
		this.to = to;
		this.variableResolver = variableResolver;
	}
	
	public void setVariableResolver(VariableResolver variableResolver) {
		this.variableResolver = variableResolver;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}
	
	@Override
	public FlowElement getFlowElement() {
		FlowMapCopy mapCopy = new FlowMapCopy(null);
		mapCopy.setMapFrom(getNSField(from));
		mapCopy.setMapTo(getNSField(to));
		return mapCopy;
	}
	
	private String getNSField(String path) {
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
