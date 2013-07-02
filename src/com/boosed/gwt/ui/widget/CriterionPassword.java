package com.boosed.gwt.ui.widget;

import com.boosed.gwt.ui.Criterion;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;

public class CriterionPassword extends Composite implements Criterion {

	private static CriterionPasswordUiBinder uiBinder = GWT.create(CriterionPasswordUiBinder.class);

	interface CriterionPasswordUiBinder extends UiBinder<Widget, CriterionPassword> {
	}

	@UiField
	Label label;
	
	@UiField
	PasswordTextBox value;
	
	private String key;
	
	public CriterionPassword() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void setName(String name) {
		label.setText(name);
	}
	
	@Override
	public void setValue(String value) {
		this.value.setText(value);
	}

	@Override
	public String getValue() {
		return value.getValue();
	}
	
	@Override
	public void showError(String error) {
			
	}
	
	@Override
	public void setWidth(String width) {
		value.setWidth(width);
	}
}