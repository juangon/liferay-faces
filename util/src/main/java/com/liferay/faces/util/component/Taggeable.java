package com.liferay.faces.util.component;

import javax.servlet.jsp.tagext.Tag;

public interface Taggeable<T extends Tag> {

	public Tag getParentTag();

	public void setParentTag(Tag tag);
	
	public T getTag();

	public void setTag(T tag);
}
