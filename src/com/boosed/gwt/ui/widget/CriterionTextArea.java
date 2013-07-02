package com.boosed.gwt.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class CriterionTextArea extends CriterionBase<TextArea> {

	private static CriterionTextAreaUiBinder uiBinder = GWT.create(CriterionTextAreaUiBinder.class);

	interface CriterionTextAreaUiBinder extends UiBinder<Widget, CriterionTextArea> {
	}

	@UiField
	Label label;
	
	private String key;
	
	public CriterionTextArea() {
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
}