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

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.RenderKit;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.faces.portal.component.inputrichtext.InputRichText;
import com.liferay.faces.portal.component.navbarsearch.NavBarSearch;
import com.liferay.faces.portal.render.internal.PortalTagRenderer;
import com.liferay.faces.util.lang.StringPool;
import com.liferay.taglib.ui.InputSearchTag;

/**
 * @author	Neil Griffin
 */
//J-
@FacesRenderer(componentFamily = InputSearch.COMPONENT_FAMILY, rendererType = InputSearch.RENDERER_TYPE)
//J+
public class InputSearchRenderer extends PortalTagRenderer<InputSearch, InputSearchTag> {

	@Override
	public InputSearchTag newTag() {
		return new InputSearchTag();
	}

	@Override
	protected InputSearch cast(UIComponent uiComponent) {
		return (InputSearch) uiComponent;
	}

	@Override
	protected void copyFrameworkAttributes(FacesContext facesContext,
			InputSearch inputSearch, InputSearchTag inputSearchTag) {
		
		inputSearchTag.setCssClass(inputSearch.getStyleClass());
		inputSearchTag.setId(inputSearch.getClientId());
		inputSearchTag.setName(inputSearch.getClientId());

		/*String escapedEditorName = inputRichText.getClientId();
		
		char separatorChar = UINamingContainer.getSeparatorChar(facesContext);
		escapedEditorName = escapedEditorName.replace(separatorChar, '_').concat("_jsptag");*/
		
		/*ExternalContext externalContext = facesContext.getExternalContext();
		PortletRequest portletRequest = (PortletRequest) externalContext.getRequest();
		HttpServletRequest httpServletRequest = getHttpServletRequest(portletRequest);*/
		//httpServletRequest.s
		//inputSearchTag.set
		
	}

	@Override
	protected void copyNonFrameworkAttributes(FacesContext facesContext,
			InputSearch u, InputSearchTag t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent)
			throws IOException {
		
		super.encodeEnd(facesContext, uiComponent);
		
		System.out.println("Client behaviours:");
		
		
	}

	@Override
	public void decode(FacesContext facesContext, UIComponent uiComponent) {
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> requestParameterMap = externalContext.getRequestParameterMap();
		String clientId = uiComponent.getClientId();		
	
		String submittedValue = requestParameterMap.get(clientId);		
	
		InputSearch inputSearch  = cast(uiComponent);
		inputSearch.setSubmittedValue(submittedValue);
	}
	@Override
	public void encodeBegin(FacesContext facesContext, UIComponent uiComponent)
			throws IOException {
		InputSearch inputSearch = cast(uiComponent);
		ResponseWriter originalResponseWriter = facesContext.getResponseWriter();
		RenderKit renderKit = facesContext.getRenderKit();
		StringWriter bufferedMarkupWriter = new StringWriter();
		ResponseWriter stringResponseWriter = renderKit.createResponseWriter(bufferedMarkupWriter, null,
				StringPool.UTF8);
		facesContext.setResponseWriter(stringResponseWriter);
		super.encodeBegin(facesContext, uiComponent);
		facesContext.setResponseWriter(originalResponseWriter);
		String createdString = bufferedMarkupWriter.toString();
		System.out.println("created string:"+createdString);
		System.out.println("clientid:"+uiComponent.getClientId());
		int indexOfId = createdString.indexOf(uiComponent.getClientId());
		if (indexOfId != -1) {
			String inputId = createdString.substring(0,indexOfId);
			int indexOfStartInput = inputId.lastIndexOf(StringPool.LESS_THAN);			
			String inputToReplaceStart = createdString.substring(indexOfStartInput, indexOfId);
			String inputToReplaceEnd = createdString.substring(indexOfId);
			int indexOfEndInput = inputToReplaceEnd.indexOf(StringPool.GREATER_THAN);
			inputToReplaceEnd = inputToReplaceEnd.substring(0, indexOfEndInput);
			String inputToReplace = inputToReplaceStart + inputToReplaceEnd;
			System.out.println("Input to replace:"+inputToReplace);
			String inputReplaced = inputToReplace.replace("value=\"\"", "value=\""+inputSearch.getValue()+"\"");
			System.out.println("Input replaced:"+inputReplaced);
			createdString = createdString.replace(inputToReplace, inputReplaced);
			System.out.println("created string:"+createdString);
		}
		ResponseWriter responseWriter = facesContext.getResponseWriter();		
		responseWriter.write(createdString);
	}
	
	@Override
	public String getChildInsertionMarker() {
		return "</div>";
	}	
}
