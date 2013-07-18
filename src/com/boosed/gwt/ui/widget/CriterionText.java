package com.boosed.gwt.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CriterionText extends CriterionBase<TextBox> {

	private static CriterionTextUiBinder uiBinder = GWT.create(CriterionTextUiBinder.class);

	interface CriterionTextUiBinder extends UiBinder<Widget, CriterionText> {
	}
	
	@UiField
	Label label;
	
	//@UiField
	//TextBox value;
	
	private String key;
	
	public CriterionText() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getName() {
		return label.getText();
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