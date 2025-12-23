package com.wbemethods.dsl.expressions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.wbemethods.dsl.expressions.flow.FlowBranchExpression;
import com.wbemethods.dsl.expressions.flow.FlowCaseExpression;
import com.wbemethods.dsl.expressions.flow.FlowCatchExpression;
import com.wbemethods.dsl.expressions.flow.FlowDoUntilExpression;
import com.wbemethods.dsl.expressions.flow.FlowElseExpression;
import com.wbemethods.dsl.expressions.flow.FlowElseIfExpression;
import com.wbemethods.dsl.expressions.flow.FlowExitExpression;
import com.wbemethods.dsl.expressions.flow.FlowFinallyExpression;
import com.wbemethods.dsl.expressions.flow.FlowIfThenElseExpression;
import com.wbemethods.dsl.expressions.flow.FlowInvokeExpression;
import com.wbemethods.dsl.expressions.flow.FlowLoopExpression;
import com.wbemethods.dsl.expressions.flow.FlowRepeatExpression;
import com.wbemethods.dsl.expressions.flow.FlowSequenceExpression;
import com.wbemethods.dsl.expressions.flow.FlowStepProperty;
import com.wbemethods.dsl.expressions.flow.FlowSwitchExpression;
import com.wbemethods.dsl.expressions.flow.FlowTryExpression;
import com.wbemethods.dsl.expressions.flow.FlowUntilExpression;
import com.wbemethods.dsl.expressions.flow.FlowWhileExpression;
import com.wbemethods.dsl.expressions.flow.map.FlowMapElementExpression;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.lang.flow.FlowBranch;
import com.wm.lang.flow.FlowDo;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowExit;
import com.wm.lang.flow.FlowInvoke;
import com.wm.lang.flow.FlowLoop;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.flow.FlowRetry;
import com.wm.lang.flow.FlowSequence;
import com.wm.lang.flow.FlowSwitch;
import com.wm.lang.flow.FlowUntil;
import com.wm.lang.flow.FlowWhile;

/**
 * Factory for creating FlowElementExpression instances from FlowElement
 * objects. Uses the Factory Pattern to eliminate large switch statements and
 * improve maintainability.
 */
public class FlowExpressionFactory {

	private static final Map<Class<? extends FlowElement>, Supplier<FlowElementExpression>> EXPRESSION_CREATORS = new HashMap<>();

	static {
		// Register creators for each FlowElement type
		EXPRESSION_CREATORS.put(FlowInvoke.class, FlowInvokeExpression::new);
		EXPRESSION_CREATORS.put(FlowMap.class, FlowMapElementExpression::new);
		EXPRESSION_CREATORS.put(FlowLoop.class, FlowLoopExpression::new);
		EXPRESSION_CREATORS.put(FlowBranch.class, FlowBranchExpression::new);
		EXPRESSION_CREATORS.put(FlowRetry.class, FlowRepeatExpression::new);
		EXPRESSION_CREATORS.put(FlowExit.class, FlowExitExpression::new);
		EXPRESSION_CREATORS.put(FlowDo.class, FlowDoUntilExpression::new);
		EXPRESSION_CREATORS.put(FlowSwitch.class, FlowSwitchExpression::new);
		EXPRESSION_CREATORS.put(FlowUntil.class, FlowUntilExpression::new);
		EXPRESSION_CREATORS.put(FlowWhile.class, FlowWhileExpression::new);
		// FlowSequence is handled separately due to form-based logic
	}

	/**
	 * Create a FlowElementExpression from a FlowElement
	 * 
	 * @param element The FlowElement to convert
	 * @return The corresponding FlowElementExpression, or null if not supported
	 */
	public static FlowElementExpression createExpression(FlowElement element) {
		if (element == null) {
			return null;
		}

		// Handle FlowSequence specially due to form-based types
		if (element instanceof FlowSequence) {
			return createSequenceExpression((FlowSequence) element);
		}

		// Use factory map for other types
		Supplier<FlowElementExpression> creator = EXPRESSION_CREATORS.get(element.getClass());
		if (creator != null) {
			FlowElementExpression expression = creator.get();
			expression.updateExpression(element);
			expression.updateStepProperties(element);
			//extractStepProperties(element.getAsData(), expression);
			return expression;
		}

		// Unknown type
		return null;
	}

	/**
	 * Create appropriate expression based on FlowSequence form
	 */
	private static FlowElementExpression createSequenceExpression(FlowSequence sequence) {
		FlowElementExpression expression;

		switch (sequence.getForm()) {
		case FlowSequence.CASE:
			expression = new FlowCaseExpression();
			break;
		case FlowSequence.TRY:
			expression = new FlowTryExpression();
			break;
		case FlowSequence.CATCH:
			expression = new FlowCatchExpression();
			break;
		case FlowSequence.FINALLY:
			expression = new FlowFinallyExpression();
			break;
		case FlowSequence.IF:
			expression = new FlowIfThenElseExpression();
			break;
		case FlowSequence.ELSEIF:
			expression = new FlowElseIfExpression();
			break;
		case FlowSequence.ELSE:
			expression = new FlowElseExpression();
			break;
		default:
			expression = new FlowSequenceExpression();
			break;
		}

		expression.updateExpression(sequence);
		extractStepProperties(sequence.getAsData(), expression);
		return expression;
	}

	/**
	 * Extract step properties from IData
	 */
	private static void extractStepProperties(IData data, FlowElementExpression expr) {
		if (data == null) {
			return;
		}

		IDataCursor cursor = data.getCursor();
		try {
			while (cursor.next()) {
				String key = cursor.getKey();
				Object value = cursor.getValue();
				if (value != null) {
					expr.addProperty(new FlowStepProperty(key, value.toString()));
				}
			}
		} finally {
			cursor.destroy();
		}
	}

	/**
	 * Register a custom expression creator for a FlowElement type Allows extension
	 * without modifying the factory
	 */
	public static void registerExpressionCreator(Class<? extends FlowElement> elementClass,
			Supplier<FlowElementExpression> creator) {
		EXPRESSION_CREATORS.put(elementClass, creator);
	}
}

// Made with Bob
