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
import com.liferay.faces.portal.render.internal.DelayedPortalTagRenderer;
import com.liferay.faces.portal.render.internal.PortalTagRenderer;
import com.liferay.faces.util.lang.StringPool;
import com.liferay.faces.util.xml.SAXParserFactory;
import com.liferay.portal.kernel.xml.Attribute;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.taglib.ui.InputSearchTag;

/**
 * @author	Neil Griffin
 */
//J-
@FacesRenderer(componentFamily = InputSearch.COMPONENT_FAMILY, rendererType = InputSearch.RENDERER_TYPE)
//J+
public class InputSearchRenderer extends DelayedPortalTagRenderer<InputSearch, InputSearchTag> {

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
	}

	@Override
	protected void copyNonFrameworkAttributes(FacesContext facesContext,
			InputSearch u, InputSearchTag t) {
		// TODO Auto-generated method stub
		
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
	public String getChildInsertionMarker() {
		return "</div>";
	}	
	
	@Override
	protected StringBuilder getMarkup(UIComponent uiComponent, StringBuilder markup) {
		InputSearch inputSearch = cast(uiComponent);		
		StringBuilder createdString = markup;		
		System.out.println("clientid:"+uiComponent.getClientId());
		Element rootElement;
		try {
			Document document = SAXReaderUtil.read(createdString.toString());
			rootElement = document.getRootElement();
			System.out.println("created string before:"+rootElement.asXML());
			
			String xpathInput = "//input[contains(@id, '" + uiComponent.getClientId()+"')]";
			Element inputElement = (Element)rootElement.selectSingleNode(xpathInput); 
			
			if (inputElement !=null) {
				inputElement.attribute("value").setValue((String) inputSearch.getValue());
				
				String xpathInputs = "//input[@type='text']";
				List<Node> inputElements = rootElement.selectNodes(xpathInputs);
				if (inputElements !=null && inputElements.size()==2) {
					Element secondInputText = (Element) inputElements.get(1);
					Iterator<Attribute> attributeIterator = secondInputText.attributeIterator();
					while (attributeIterator.hasNext()) {
						Attribute attribute = attributeIterator.next();
						String attributeName = attribute.getName();
						if (attributeName.startsWith("on")) {
							inputElement.addAttribute(attributeName, attribute.getValue());
						}
					}
					
					secondInputText.getParent().remove(secondInputText);
				}				
			}
			
			HtmlCommandButton commandButton = (HtmlCommandButton) uiComponent.getChildren().get(1);
			String buttonClientId = commandButton.getClientId();	
			System.out.println("Button client id:"+buttonClientId);
			String xpathInputButton = "//input[contains(@name,'" + buttonClientId+"') and @type='submit']";
			
			Element inputButton = (Element)rootElement.selectSingleNode(xpathInputButton);
			
			if (inputButton == null) {
				xpathInputButton = "//input[contains(@id,'" + buttonClientId+"') and @type='submit']";
				inputButton = (Element)rootElement.selectSingleNode(xpathInputButton);
			}
			
			String xpathButton = "//button[@type='submit']";
			Element button = (Element)rootElement.selectSingleNode(xpathButton);
						
			if (inputButton !=null && button != null) {
				Attribute onClickAttr = inputButton.attribute("onclick"); 
				if (onClickAttr !=null) {
					button.addAttribute("onclick", onClickAttr.getValue());					
				}
				Attribute nameAttr = inputButton.attribute("name"); 
				if (nameAttr !=null) {
					button.addAttribute("name", nameAttr.getValue());					
				}
				Attribute idAttr = inputButton.attribute("id"); 
				if (idAttr !=null) {
					button.addAttribute("id", idAttr.getValue());					
				}
				//button.addAttribute("id", buttonClientId);
				inputButton.getParent().remove(inputButton);				
			}
			
			createdString = new StringBuilder(1);
			
			createdString.append(rootElement.asXML());
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*int indexOfId = createdString.indexOf(uiComponent.getClientId());
		if (indexOfId != -1) {
			String inputId = createdString.substring(0,indexOfId);			
			int indexOfStartInputFromId = inputId.lastIndexOf(StringPool.LESS_THAN);
			//int indexOfStartInput =indexOfId + indexOfStartInputFromId; 
			String inputAfterId = createdString.substring(indexOfStartInputFromId);
			int indexOfEndInput = indexOfStartInputFromId + inputAfterId.indexOf(StringPool.GREATER_THAN);
			String valueString = createdString.substring(indexOfStartInputFromId, indexOfEndInput);
			int indexOfValueStart = indexOfStartInputFromId + valueString.indexOf("value=\"");
			indexOfValueStart = indexOfValueStart + "value=\"".length();
			int indexOfValueEnd = indexOfValueStart + createdString.substring(indexOfValueStart).indexOf("\"");
			System.out.println("Replacing in this string:"+  createdString.substring(0,indexOfValueStart) + " _ " +  createdString.substring(indexOfValueStart, indexOfValueEnd) + " this value:" + inputSearch.getValue());
			createdString = createdString.replace(indexOfValueStart, indexOfValueEnd, (String) inputSearch.getValue());
			System.out.println("created string:"+createdString);				
		}
		
		HtmlCommandButton htmlCommandButton = (HtmlCommandButton) uiComponent.getChildren().get(0);
		int indexOfIdButton = createdString.indexOf(htmlCommandButton.getClientId());
		if (indexOfId != -1) {
			
		}*/
		
		System.out.println("created string:"+createdString);	
		
		return createdString;
	}
}
