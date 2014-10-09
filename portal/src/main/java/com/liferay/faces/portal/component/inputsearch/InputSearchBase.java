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
//J-

import javax.annotation.Generated;
import javax.el.MethodExpression;
import javax.faces.component.ActionSource2;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.el.MethodBinding;
import javax.faces.event.ActionListener;

import com.liferay.faces.util.component.Styleable;

/**
 * @author	Neil Griffin
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputSearchBase  extends UIInput{

	// Protected Enumerations
	protected enum InputSearchPropertyKeys {
		autoFocus,
		buttonLabel,		
		placeholder,
		showButton,
		style,
		styleClass,
		title
	}

	public String getAutoFocus() {
		return (String) getStateHelper().eval(InputSearchPropertyKeys.autoFocus, null);
	}

	public void setAutoFocus(String autoFocus) {
		getStateHelper().put(InputSearchPropertyKeys.autoFocus, autoFocus);
	}

	public String getButtonLabel() {
		return (String) getStateHelper().eval(InputSearchPropertyKeys.buttonLabel, null);
	}

	public void setButtonLabel(String buttonLabel) {
		getStateHelper().put(InputSearchPropertyKeys.buttonLabel, buttonLabel);
	}

	public String getPlaceholder() {
		return (String) getStateHelper().eval(InputSearchPropertyKeys.placeholder, null);
	}

	public void setPlaceholder(String placeholder) {
		getStateHelper().put(InputSearchPropertyKeys.placeholder, placeholder);
	}

	public String getShowButton() {
		return (String) getStateHelper().eval(InputSearchPropertyKeys.showButton, null);
	}

	public void setShowButton(String showButton) {
		getStateHelper().put(InputSearchPropertyKeys.showButton, showButton);
	}

	public String getStyle() {
		return (String) getStateHelper().eval(InputSearchPropertyKeys.style, null);
	}

	public void setStyle(String style) {
		getStateHelper().put(InputSearchPropertyKeys.style, style);
	}

	public String getStyleClass() {
		return (String) getStateHelper().eval(InputSearchPropertyKeys.styleClass, null);
	}

	public void setStyleClass(String styleClass) {
		getStateHelper().put(InputSearchPropertyKeys.styleClass, styleClass);
	}

	public String getTitle() {
		return (String) getStateHelper().eval(InputSearchPropertyKeys.title, null);
	}

	public void setTitle(String title) {
		getStateHelper().put(InputSearchPropertyKeys.title, title);
	}	
	
}
//J+
