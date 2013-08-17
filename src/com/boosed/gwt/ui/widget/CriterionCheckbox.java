package com.boosed.gwt.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CriterionCheckbox extends CriterionBase<CheckBox> {

	private static CriterionCheckboxUiBinder uiBinder = GWT.create(CriterionCheckboxUiBinder.class);

	interface CriterionCheckboxUiBinder extends UiBinder<Widget, CriterionCheckbox> {
	}

	@UiField
	Label label;
	
	public CriterionCheckbox() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public CriterionCheckbox(String name, String key, String value) {
		this();
		setKey(key);
		setName(name);
		setValue(value);
		//initWidget(uiBinder.createAndBindUi(this));
	}

	public void setName(String name) {
		label.setText(name);
	}
	
	@Override
	public void setValue(String value) {
		this.value.setValue(Boolean.parseBoolean(value));
	}

	@Override
	public String getValue() {
		return value.getValue().toString();
	}
}