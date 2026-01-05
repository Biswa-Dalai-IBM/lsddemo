package com.webmethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.Namespace;

/**
 * Base class for flow expressions that can contain child expressions. Inherits
 * property handling from FlowElementExpression.
 */
public class FlowContainerExpression extends FlowElementExpression {

	private List<FlowElementExpression> expressions;

	public FlowContainerExpression() {
		super(); // Initialize parent's properties list
		expressions = new ArrayList<FlowElementExpression>();
	}

	/**
	 * Add a child expression. Special handling for ELSEIF, ELSE, CATCH, and FINALLY
	 * which are attached to their parent IF or TRY expressions rather than added as
	 * siblings.
	 */
	public void addChild(FlowElementExpression expression) {
		boolean addedToParent = false;

		// Handle UNTIL 
		
		if (expression instanceof FlowUntilExpression) {
			FlowUntilExpression untilExpression = (FlowUntilExpression)expression;
			FlowDoUntilExpression doUntilExpression = (FlowDoUntilExpression)this;
			doUntilExpression.setUntilCondition(untilExpression.getCondition());
		}
		// Handle ELSEIF - attach to preceding IF
		if (expression instanceof FlowElseIfExpression) {
			if (!expressions.isEmpty()) {
				FlowElementExpression last = expressions.get(expressions.size() - 1);
				if (last instanceof FlowIfThenElseExpression) {
					FlowIfThenElseExpression flowIfThenElseExpression = (FlowIfThenElseExpression) last;
					flowIfThenElseExpression.addElseIfExpressions((FlowElseIfExpression) expression);
					addedToParent = true;
				}
			}
		}

		// Handle ELSE - attach to preceding IF
		if (expression instanceof FlowElseExpression) {
			if (!expressions.isEmpty()) {
				FlowElementExpression last = expressions.get(expressions.size() - 1);
				if (last instanceof FlowIfThenElseExpression) {
					FlowIfThenElseExpression flowIfThenElseExpression = (FlowIfThenElseExpression) last;
					flowIfThenElseExpression.setElseExpression((FlowElseExpression) expression);
					addedToParent = true;
				}
			}
		}

		// Handle CATCH - attach to preceding TRY
		if (expression instanceof FlowCatchExpression) {
			if (!expressions.isEmpty()) {
				FlowElementExpression last = expressions.get(expressions.size() - 1);
				if (last instanceof FlowTryExpression) {
					FlowTryExpression tryExpression = (FlowTryExpression) last;
					tryExpression.addCatchExpressions((FlowCatchExpression) expression);
					addedToParent = true;
				}
			}
		}

		// Handle FINALLY - attach to preceding TRY
		if (expression instanceof FlowFinallyExpression) {
			if (!expressions.isEmpty()) {
				FlowElementExpression last = expressions.get(expressions.size() - 1);
				if (last instanceof FlowTryExpression) {
					FlowTryExpression tryExpression = (FlowTryExpression) last;
					tryExpression.setFinallyExpression((FlowFinallyExpression) expression);
					addedToParent = true;
				}
			}
		}

		// Only add to expressions list if not attached to parent
		if (!addedToParent) {
			expressions.add(expression);
		}
	}

	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}

	public boolean hasExpressions() {
		return expressions != null && !expressions.isEmpty();
	}


	@Override
	public FlowElement getFlowElement(Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFlowElement(Namespace namespace,FlowElement parent) {

	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowElement[] nodes = element.getNodes();
		for (FlowElement flowElement : nodes) {
			FlowElementExpression expression = convertFlowElement(flowElement);
			if (expression != null) {
				addChild(expression);
			}
		}
	}

	@Override
	public void generateText(FlowTextContext context) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getOutlineNodeName() {
		// TODO Auto-generated method stub
		return null;
	}
}
