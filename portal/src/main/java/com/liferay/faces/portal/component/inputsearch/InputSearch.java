/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.portal.component.inputsearch;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.MethodExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ListenerFor;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.event.PreRenderComponentEvent;

import com.liferay.faces.portal.component.inputsearch.InputSearchCommandBase.InputSearchCommandPropertyKeys;
import com.liferay.faces.util.component.ComponentUtil;
import com.liferay.faces.util.render.RendererUtil;

/**
 * @author	Juan Gonzalez
 */
@FacesComponent(value = InputSearch.COMPONENT_TYPE)
@ListenerFor(systemEventClass = PreRenderComponentEvent.class)
public class InputSearch extends InputSearchBase {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.portal.component.inputsearch.InputSearch";
	public static final String RENDERER_TYPE = "com.liferay.faces.portal.component.inputsearch.InputSearchRenderer";
	
	public InputSearch() {
		super();
		setRendererType(RENDERER_TYPE);
	}
	
	
	public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
        super.processEvent(event);
 
        if (!(event instanceof PreRenderComponentEvent)) {
            return;
        }
 
        HtmlInputText inputText = createHtmlInputText(getFacesContext());       
        
        Map<String, List<ClientBehavior>> clientBehaviours= this.getClientBehaviors();
	       
		Set<String> client = clientBehaviours.keySet();
		for (String key : client) {
			
			List<ClientBehavior> clients = clientBehaviours.get(key);
			
			System.out.println("Key:"+ key);
			
			//if (!InputSearchCommandBase.EVENT_NAMES.contains(key)) {
				for (ClientBehavior clientBehavior: clients){
					addClientBehaviour(inputText, key, clientBehavior);
				}
			/*}
			else {
				for (ClientBehavior clientBehavior: clients){
					addClientBehaviour(button, key, clientBehavior);
				}
			}*/
		}		
		
		this.getChildren().add(inputText);        	
		
		HtmlCommandButton button = createHtmlCommandButton(getFacesContext(), getAction(), getActionListener(), null);
		//HtmlCommandButton button = createHtmlCommandButton(getFacesContext(), getAction(), getActionListener());
		
		this.getChildren().add(button);
    }
	
	protected HtmlCommandButton createHtmlCommandButton(final FacesContext facesContext, final /*MethodBinding*/ MethodExpression action, final /*MethodBinding*/MethodExpression listener, final ActionListener[] actionListeners) {
		HtmlCommandButton button = (HtmlCommandButton) facesContext.getApplication().createComponent(HtmlCommandButton.COMPONENT_TYPE);		
		if (action !=null) {
			System.out.println ("--------------------ACTION NOT NULL--------------------");
			//button.setAction(action);
			button.setActionExpression(action);
		}		
		if (listener!=null) {
			System.out.println ("--------------------ACTIONLISTENER NOT NULL--------------------");
			button.addActionListener(new MethodExpressionActionListener(listener));			
		}
		
		if (actionListeners!=null) {
			for (ActionListener actionListener : actionListeners) {
				button.addActionListener(actionListener);
			}
		}
		
	    return button;
	}
	
	/*protected HtmlCommandButton createHtmlCommandButton(final FacesContext facesContext, final String action, final String actionListener) {
		HtmlCommandButton button = (HtmlCommandButton) facesContext.getApplication().createComponent(HtmlCommandButton.COMPONENT_TYPE);		
				
		if (action !=null) {
			System.out.println ("--------------------ACTION NOT NULL--------------------");
			button.setActionExpression(createMethodExpression(facesContext, "#{" + action + "}", String.class, new Class[]{}));
		}
		
		if (actionListener!=null) {
			System.out.println ("--------------------ACTIONLISTENER NOT NULL--------------------");
			button.addActionListener(new MethodExpressionActionListener(createMethodExpression(facesContext, "#{" + actionListener+"}", Void.class, new Class[]{ActionEvent.class})));//.setActionListener(listener);
		}
		
		
		System.out.println("Button created!");
	    return button;
	}*/
	
	protected HtmlInputText createHtmlInputText(final FacesContext facesContext) {
		HtmlInputText inputText = (HtmlInputText) facesContext.getApplication().createComponent(HtmlInputText.COMPONENT_TYPE);		
	    return inputText;
	}
	
	private void addClientBehaviour (UIComponentBase uiComponent, String eventName, ClientBehavior clientBehavior) {
		uiComponent.addClientBehavior(eventName, clientBehavior);
	}
	
	private MethodExpression createMethodExpression(FacesContext facesContext, String expression, Class<?> returnType, Class<?>... parameterTypes) {        
        return facesContext.getApplication().getExpressionFactory().createMethodExpression(
            facesContext.getELContext(), expression, returnType, parameterTypes);
    }
}
