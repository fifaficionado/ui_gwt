package com.boosed.gwt.ui.widget;

import com.boosed.gwt.ui.Criterion;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class CriterionList extends Composite implements Criterion {

	private static CriterionListUiBinder uiBinder = GWT.create(CriterionListUiBinder.class);

	interface CriterionListUiBinder extends UiBinder<Widget, CriterionList> {
	}

	@UiField
	Label label;

	@UiField
	public ListBox value;

	private String key;

	public CriterionList() {
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
		this.value.setSelectedIndex(Integer.parseInt(value));
	}

	public void setValues(String[] ... values) {
		this.value.clear();
		for (String[] tuple : values)
			this.value.addItem(tuple[0], tuple[1]);
	}

	@Override
	public String getValue() {
		return value.getValue(value.getSelectedIndex());
	}
	
	@Override
	public void showError(String error) {
			
	}
	
	@Override
	public void setWidth(String width) {
		value.setWidth(width);
	}
}