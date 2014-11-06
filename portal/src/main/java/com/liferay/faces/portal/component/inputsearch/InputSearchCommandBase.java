package com.liferay.faces.portal.component.inputsearch;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.el.MethodExpression;
import javax.faces.component.ActionSource2;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.el.MethodBinding;
import javax.faces.event.ActionListener;

import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;

/**
 * @author Juan Gonzalez
 */
public class InputSearchCommandBase extends InputSearchBase /*implements ClientBehaviorHolder, ActionSource2*/ {

	//protected HtmlCommandButton wrappedCommandButton;
	
	/*private String actionListener;
	
	private String action;*/
	
	/*public MethodBinding getActionListener() {
		return (MethodBinding) getStateHelper().get(InputSearchCommandPropertyKeys.actionListener);
	}*/

	/*public String getActionListener() {
		return (String) getStateHelper().eval(InputSearchCommandPropertyKeys.actionListener, null);
	}*/

	/*public void setActionListener(MethodBinding actionListener) {
		getStateHelper().put(InputSearchCommandPropertyKeys.actionListener, actionListener);
	}*/

	/*public void setActionListener(String actionListener) {
		getStateHelper().put(InputSearchCommandPropertyKeys.actionListener, actionListener);
	}*/

	/*public MethodBinding getAction() {
		return (MethodBinding) getStateHelper().get(InputSearchCommandPropertyKeys.action);
	}*/
	
	/*public String getAction() {
		return (String) getStateHelper().eval(InputSearchCommandPropertyKeys.action, null);
	}*/

	/*public void setAction(MethodBinding action) {
		getStateHelper().put(InputSearchCommandPropertyKeys.action, action);
	}*/
	
	/*public void setAction(String action) {
		getStateHelper().put(InputSearchCommandPropertyKeys.action, action);
	}*/
//	public MethodBinding getAction() {
//        MethodBinding result = null;
//        MethodExpression me;
//
//        if (null != (me = getActionExpression())) {
//            // if the MethodExpression is an instance of our private
//            // wrapper class.
//            if (me.getClass().equals(MethodExpressionMethodBindingAdapter.class)) {
//                result = ((MethodExpressionMethodBindingAdapter) me).getWrapped();
//            } else {
//                // otherwise, this is a real MethodExpression.  Wrap it
//                // in a MethodBinding.
//                result = new MethodBindingMethodExpressionAdapter(me);
//            }
//        }
//        return result;
//
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * @deprecated This has been replaced by {@link #setActionExpression(javax.el.MethodExpression)}.
//     */
//    public void setAction(MethodBinding action) {
//        MethodExpressionMethodBindingAdapter adapter;
//        if (null != action) {
//            adapter = new MethodExpressionMethodBindingAdapter(action);
//            setActionExpression(adapter);
//        } else {
//            setActionExpression(null);
//        }
//    }
//    
//    /**
//     * {@inheritDoc}
//     * @deprecated Use {@link #getActionListeners} instead.
//     */
//    public MethodBinding getActionListener() {
//        return (MethodBinding) getStateHelper().get(PropertyKeys.methodBindingActionListener);
//    }
//
//    /**
//     * {@inheritDoc}
//     * @deprecated This has been replaced by {@link #addActionListener(javax.faces.event.ActionListener)}.
//     */
//    public void setActionListener(MethodBinding actionListener) {
//        getStateHelper().put(PropertyKeys.methodBindingActionListener, actionListener);
//    } 


	
	
	protected enum InputSearchCommandPropertyKeys {
		action,
		actionListener
	}
	
	
	//public InputSearchCommandBase() {
	//	super();
		//wrappedCommandButton = new HtmlCommandButton();
	//}
   
//    public MethodExpression getActionExpression() {
//        //return (MethodExpression) getStateHelper().get(InputSearchCommandPropertyKeys.action);
//    	return wrappedCommandButton.getActionExpression();
//    }
//    
//    public void setActionExpression(MethodExpression actionExpression) {
//        //getStateHelper().put(InputSearchCommandPropertyKeys.action, actionExpression);
//    	wrappedCommandButton.setActionExpression(actionExpression);
//    }
//
//	public MethodBinding getAction() {
//		return wrappedCommandButton.getAction();
//	}
//
//	public void setAction(MethodBinding action) {
//		wrappedCommandButton.setAction(action);
//		
//	}
//
//	public MethodBinding getActionListener() {
//		//return (MethodBinding) getStateHelper().get(InputSearchCommandPropertyKeys.actionListener);
//		return wrappedCommandButton.getActionListener();
//	}
//
//	public void setActionListener(MethodBinding actionListener) {
//		//getStateHelper().put(InputSearchCommandPropertyKeys.actionListener, actionListener);
//		wrappedCommandButton.setActionListener(actionListener);
//	}
//	
//	//public static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("action"));
//																									//"blur","change","valueChange","click","dblclick","focus","keydown","keypress","keyup","mousedown","mousemove","mouseout","mouseover","mouseup","select")
//    
//	/*public Collection<String> getEventNames() {
//        return EVENT_NAMES;
//     }
//
//    public String getDefaultEventName() {
//        return "action";   
//    }*/	
//    
//	public void addActionListener(ActionListener listener) {
//		 wrappedCommandButton.addActionListener(listener);	
//	}
//	public ActionListener[] getActionListeners() {
//		return wrappedCommandButton.getActionListeners();
//	}
//	public void removeActionListener(ActionListener listener) {
//		 wrappedCommandButton.removeActionListener(listener);;	
//	}   
   
}
