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

	/**
	 * Enabled/disable this widget for input.
	 * 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled);

	/**
	 * Show an error. Use null to hide error message.
	 * 
	 * @param error
	 */
	public void showError(String error);
}
