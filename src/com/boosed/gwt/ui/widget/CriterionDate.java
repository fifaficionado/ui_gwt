package com.boosed.gwt.ui.widget;

import java.util.Date;

import com.boosed.gwt.ui.Criterion;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class CriterionDate extends Composite implements Criterion {

	private static CriterionDateUiBinder uiBinder = GWT.create(CriterionDateUiBinder.class);

	interface CriterionDateUiBinder extends UiBinder<Widget, CriterionDate> {
	}

	private static final String FMT_DATE = "d MMMM yyyy";
	
	@UiField
	Label name;
	
	@UiField
	DateBox date;
	
	private String key;
	
	public CriterionDate() {
		initWidget(uiBinder.createAndBindUi(this));
		date.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat(FMT_DATE)));
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void setName(String name) {
		this.name.setText(name);
	}
	
	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void setValue(String value) {
		date.setValue(new Date(Long.parseLong(value)));
	}

	@Override
	public String getValue() {
		return Long.toString(date.getValue().getTime());
	}
	
	@Override
	public void showError(String error) {
			
	}
}