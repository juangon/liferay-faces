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
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ListenerFor;
import javax.faces.event.PreRenderComponentEvent;

import com.liferay.faces.util.component.ComponentUtil;

/**
 * @author	Neil Griffin
 */
@FacesComponent(value = InputSearch.COMPONENT_TYPE)
@ListenerFor(systemEventClass = PreRenderComponentEvent.class)
public class InputSearch extends InputSearchCommandBase {

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
 
        HtmlCommandButton button = createHtmlCommandButton(getFacesContext(), getActionExpression());
        
        Map<String, List<ClientBehavior>> clientBehaviours= this.getClientBehaviors();
		
		Set<String> client = clientBehaviours.keySet();
		for (String key : client) {
			
			List<ClientBehavior> clients = clientBehaviours.get(key);
			
			System.out.println("Key:"+ key);
			
			for (ClientBehavior clientBehavior: clients){
				addClientBehaviour(button, key, clientBehavior);
			}			
		}		
		this.getChildren().add(button);
    }
	
	public HtmlCommandButton createHtmlCommandButton(final FacesContext facesContext, final MethodExpression methodExpression) {
		HtmlCommandButton button = (HtmlCommandButton) facesContext.getApplication().createComponent(HtmlCommandButton.COMPONENT_TYPE);
		/*MethodExpression actionExpression = facesContext.getApplication().getExpressionFactory()
				.createMethodExpression(facesContext.getELContext(), actionStringExpression, String.class, new Class<?>[]{});*/
		button.setActionExpression(methodExpression);
	    return button;
	}
	
	public void addClientBehaviour (HtmlCommandButton htmlCommandButton, String eventName, ClientBehavior clientBehavior) {
		htmlCommandButton.addClientBehavior(eventName, clientBehavior);
	}
}
