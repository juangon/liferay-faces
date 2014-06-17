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
package com.liferay.faces.alloy.component.selectstarrating;
//J-

import java.io.IOException;

import javax.annotation.Generated;
import javax.faces.component.UIComponent;
import javax.faces.context.ResponseWriter;

import com.liferay.faces.alloy.renderkit.DelegatingAlloyRendererBase;

/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class SelectStarRatingRendererBase extends DelegatingAlloyRendererBase {

	// Protected Constants
	protected static final String CLIENT_KEY = "clientKey";
	protected static final String LABEL = "label";
	protected static final String VALUE = "value";

	// Private Constants
	private static final String ALLOY_CLASS_NAME = "Rating";
	private static final String ALLOY_MODULE_NAME = "aui-rating";

	// Modules
	protected static final String[] MODULES = {ALLOY_MODULE_NAME};

	@Override
	public void encodeAlloyAttributes(ResponseWriter responseWriter, UIComponent uiComponent) throws IOException {

		SelectStarRating selectStarRating = (SelectStarRating) uiComponent;
		boolean first = true;

		Object value = selectStarRating.getValue();

		if (value != null) {

			encodeValue(responseWriter, selectStarRating, value, first);
			first = false;
		}

		encodeHiddenAttributes(responseWriter, selectStarRating, first);
	}

	@Override
	public String getAlloyClassName() {
		return ALLOY_CLASS_NAME;
	}

	@Override
	protected String[] getModules() {
		return MODULES;
	}

	protected void encodeValue(ResponseWriter responseWriter, SelectStarRating selectStarRating, Object value, boolean first) throws IOException {
		encodeString(responseWriter, VALUE, value, first);
	}

	protected void encodeHiddenAttributes(ResponseWriter responseWriter, SelectStarRating selectStarRating, boolean first) throws IOException {
		// no-op
	}
}
//J+
