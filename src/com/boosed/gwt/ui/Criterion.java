package com.boosed.gwt.ui;

/**
 * Interface for a criterion widget.
 * 
 * @author dsumera
 */
public interface Criterion {

	/**
	 * Returns key of value.
	 * 
	 * @return
	 */
	public String getKey();

	/**
	 * Sets the value.
	 * 
	 * @param value
	 */
	public void setValue(String value);

	/**
	 * Returns the value.
	 * 
	 * @return
	 */
	public String getValue();
}
