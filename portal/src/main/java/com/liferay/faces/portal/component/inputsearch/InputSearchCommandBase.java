package com.liferay.faces.portal.component.inputsearch;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.el.MethodExpression;
import javax.faces.component.ActionSource;
import javax.faces.component.ActionSource2;
/*import javax.faces.component.MethodBindingMethodExpressionAdapter;
import javax.faces.component.MethodExpressionMethodBindingAdapter;*/
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.FacesEvent;
import javax.faces.event.PhaseId;


public class InputSearchCommandBase extends InputSearchBase implements ClientBehaviorHolder, ActionSource2 {

	protected enum InputSearchCommandPropertyKeys {
		action,
		actionListener
	}
	
    // ------------------------------------------------- ActionSource/ActionSource2 Properties

	/**
     * {@inheritDoc}
     *
     * @deprecated This has been replaced by {@link #getActionExpression}.
     */
    /*public MethodBinding getAction() {
        MethodBinding result = null;
        MethodExpression me;

        if (null != (me = getActionExpression())) {
            // if the MethodExpression is an instance of our private
            // wrapper class.
            if (me.getClass().equals(MethodExpressionMethodBindingAdapter.class)) {
                result = ((MethodExpressionMethodBindingAdapter) me).getWrapped();
            } else {
                // otherwise, this is a real MethodExpression.  Wrap it
                // in a MethodBinding.
                result = new MethodBindingMethodExpressionAdapter(me);
            }
        }
        return result;

    }*/

    /**
     * {@inheritDoc}
     *
     * @deprecated This has been replaced by {@link #setActionExpression(javax.el.MethodExpression)}.
     */
    /*public void setAction(MethodBinding action) {
        MethodExpressionMethodBindingAdapter adapter;
        if (null != action) {
            adapter = new MethodExpressionMethodBindingAdapter(action);
            setActionExpression(adapter);
        } else {
            setActionExpression(null);
        }
    }*/
    
    /**
     * {@inheritDoc}
     * @deprecated Use {@link #getActionListeners} instead.
     */
    /*public MethodBinding getActionListener() {
        return (MethodBinding) getStateHelper().get(PropertyKeys.methodBindingActionListener);
    }*/

    /**
     * {@inheritDoc}
     * @deprecated This has been replaced by {@link #addActionListener(javax.faces.event.ActionListener)}.
     */
    /*public void setActionListener(MethodBinding actionListener) {
        getStateHelper().put(PropertyKeys.methodBindingActionListener, actionListener);
    } */

    /**
     * <p>The immediate flag.</p>
     */
    //private Boolean immediate;


    /*public boolean isImmediate() {

        return (Boolean) getStateHelper().eval(PropertyKeys.immediate, false);

    }


    public void setImmediate(boolean immediate) {

        getStateHelper().put(PropertyKeys.immediate, immediate);

    }*/



    /**
     * <p>Returns the <code>value</code> property of the
     * <code>UICommand</code>. This is most often rendered as a label.</p>
     */
    /*public Object getValue() {

        return getStateHelper().eval(PropertyKeys.value);

    }*/


    /**
     * <p>Sets the <code>value</code> property of the <code>UICommand</code>.
     * This is most often rendered as a label.</p>
     *
     * @param value the new value
     */
    /*public void setValue(Object value) {

        getStateHelper().put(PropertyKeys.value, value);

    }*/


    // ---------------------------------------------------- ActionSource / ActionSource2 Methods

    
    public MethodExpression getActionExpression() {
        return (MethodExpression) getStateHelper().get(InputSearchCommandPropertyKeys.action);
    }
    
    public void setActionExpression(MethodExpression actionExpression) {
        getStateHelper().put(InputSearchCommandPropertyKeys.action, actionExpression);
    }

	public MethodBinding getAction() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAction(MethodBinding action) {
		// TODO Auto-generated method stub
		
	}

	public MethodBinding getActionListener() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setActionListener(MethodBinding actionListener) {
		// TODO Auto-generated method stub
		
	}

	public void addActionListener(ActionListener listener) {
		// TODO Auto-generated method stub
		
	}

	public ActionListener[] getActionListeners() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeActionListener(ActionListener listener) {
		// TODO Auto-generated method stub
		
	}
    
    /** 
     * @throws NullPointerException {@inheritDoc}
     */ 
    /*public void addActionListener(ActionListener listener) {

        addFacesListener(listener);

    }
    
   public ActionListener[] getActionListeners() {

        ActionListener al[] = (ActionListener [])
        getFacesListeners(ActionListener.class);
        return (al);

    }*/



    /**
     * @throws NullPointerException {@inheritDoc}
     */ 
    /*public void removeActionListener(ActionListener listener) {

        removeFacesListener(listener);

    }*/


    // ----------------------------------------------------- UIComponent Methods


    /**
     * <p>In addition to to the default {@link UIComponent#broadcast}
     * processing, pass the {@link ActionEvent} being broadcast to the
     * method referenced by <code>actionListener</code> (if any),
     * and to the default {@link ActionListener} registered on the
     * {@link javax.faces.application.Application}.</p>
     *
     * @param event {@link FacesEvent} to be broadcast
     *
     * @throws AbortProcessingException Signal the JavaServer Faces
     *  implementation that no further processing on the current event
     *  should be performed
     * @throws IllegalArgumentException if the implementation class
     *  of this {@link FacesEvent} is not supported by this component
     * @throws NullPointerException if <code>event</code> is
     * <code>null</code>
     */
    /*public void broadcast(FacesEvent event) throws AbortProcessingException {

        // Perform standard superclass processing (including calling our
        // ActionListeners)
        super.broadcast(event);

        if (event instanceof ActionEvent) {
            FacesContext context = getFacesContext();
            
            // Notify the specified action listener method (if any)
            MethodBinding mb = getActionListener();
            if (mb != null) {
                mb.invoke(context, new Object[] { event });
            }

            // Invoke the default ActionListener
            ActionListener listener =
              context.getApplication().getActionListener();
            if (listener != null) {
                listener.processAction((ActionEvent) event);
            }
        }
    }*/

    /**

     * <p>Intercept <code>queueEvent</code> and take the following
     * action.  If the event is an <code>{@link ActionEvent}</code>,
     * obtain the <code>UIComponent</code> instance from the event.  If
     * the component is an <code>{@link ActionSource}</code> obtain the
     * value of its "immediate" property.  If it is true, mark the
     * phaseId for the event to be
     * <code>PhaseId.APPLY_REQUEST_VALUES</code> otherwise, mark the
     * phaseId to be <code>PhaseId.INVOKE_APPLICATION</code>.  The event
     * must be passed on to <code>super.queueEvent()</code> before
     * returning from this method.</p>

     */

   /* public void queueEvent(FacesEvent e) {
        UIComponent c = e.getComponent();
        if (e instanceof ActionEvent && c instanceof ActionSource) {
            if (((ActionSource) c).isImmediate()) {
                e.setPhaseId(PhaseId.APPLY_REQUEST_VALUES);
            } else {
                e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            }
        }
        super.queueEvent(e);
    }*/
	
	private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("blur","change","click","action","dblclick","focus","keydown","keypress","keyup","mousedown","mousemove","mouseout","mouseover","mouseup","select"));

    public Collection<String> getEventNames() {
        return EVENT_NAMES;    }


    public String getDefaultEventName() {
        return "action";    }
    
    /*@Override
	public void addClientBehavior(String eventName, ClientBehavior clientBehavior) {

		// If the specified client behavior is an Ajax behavior, then the alloy:inputDate component tag has an f:ajax
		// child tag. Register a behavior listener that can respond to the Ajax behavior by invoking the
		// dateSelectListener that may have been specified.
		if (clientBehavior instanceof AjaxBehavior) {
			AjaxBehavior ajaxBehavior = (AjaxBehavior) clientBehavior;
			ajaxBehavior.addAjaxBehaviorListener(new InputDateBehaviorListener());
		}

		super.addClientBehavior(eventName, clientBehavior);
	}*/
}
