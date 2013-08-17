package com.boosed.gwt.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;

public class CriterionPassword extends CriterionBase<PasswordTextBox> {

	private static CriterionPasswordUiBinder uiBinder = GWT.create(CriterionPasswordUiBinder.class);

	interface CriterionPasswordUiBinder extends UiBinder<Widget, CriterionPassword> {
	}

	@UiField
	Label label;
	
	public CriterionPassword() {
		initWidget(uiBinder.createAndBindUi(this));
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
}