package com.boosed.gwt.ui.widget;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.boosed.gwt.ui.Criterion;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel.PositionCallback;
import com.google.gwt.user.client.ui.Widget;

public class CriterionMap extends Composite implements Criterion,
		CriterionMapAdd.AddListener {

	private static CriterionMapUiBinder uiBinder = GWT
			.create(CriterionMapUiBinder.class);

	interface CriterionMapUiBinder extends UiBinder<Widget, CriterionMap> {
	}

	public CriterionMap() {
		initWidget(uiBinder.createAndBindUi(this));
		addPanel.setAddListener(this);
		value.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				value.setTitle(value.getValue(value.getSelectedIndex()));
			}
		});
	}

	@UiField
	Label label;

	@UiField
	ListBox value;

	private String key;

	private CriterionMapAdd addPanel = new CriterionMapAdd();

	// public CriterionMap(String firstName) {
	// initWidget(uiBinder.createAndBindUi(this));
	// button.setText(firstName);
	// }
	//
	// @UiHandler("button")
	// void onClick(ClickEvent e) {
	// Window.alert("Hello!");
	// }
	//
	// public void setText(String text) {
	// button.setText(text);
	// }
	//
	// public String getText() {
	// return button.getText();
	// }

	@Override
	public void onAdd(String key, String value) {
		// add an item to the list
		this.value.addItem(key, value);
	}

	@Override
	public String getKey() {
		return key;
	}

	/* whether to show value field in popup panel */
	public void setPaired(boolean enabled) {
		addPanel.setPaired(enabled);
	}
	
	public void setKeyField(String name) {
		addPanel.setKeyName(name);
	}
	
	public void setValueField(String name) {
		addPanel.setValueName(name);
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

	public void setValues(Map<String, String> values) {
		this.value.clear();
		for (Entry<String, String> entry : values.entrySet())
			this.value.addItem(entry.getKey(), entry.getValue());
	}

	@Override
	public String getValue() {
		return value.getValue(value.getSelectedIndex());
	}

	public Map<String, String> getValues() {
		// get the values IN ORDER!
		Map<String, String> values = new LinkedHashMap<String, String>();
		//for (int i = value.getItemCount(); --i > -1;)
		int len = value.getItemCount();
		for (int i = 0; i < len; i++)
			values.put(value.getItemText(i), value.getValue(i));
		return values;
	}

	@Override
	public void showError(String error) {

	}

	@Override
	public void setWidth(String width) {
		value.setWidth(width);
	}

	@UiHandler("add")
	public void add(ClickEvent event) {
		// show add panel
		addPanel.setPopupPositionAndShow(new PositionCallback() {
			@Override
			public void setPosition(int offsetWidth, int offsetHeight) {
				addPanel.setPopupPosition(
						getAbsoluteLeft()
								+ Math.abs(getOffsetWidth() - offsetWidth) / 2,
						getAbsoluteTop()
								+ Math.abs(getOffsetHeight() - offsetHeight)
								/ 2);
			}
		});
	}

	/**
	 * Remove selected items from list.
	 * 
	 * @param event
	 */
	@UiHandler("delete")
	void delete(ClickEvent event) {
		for (int i = value.getItemCount(); --i > -1;)
			if (value.isItemSelected(i)) {
				value.removeItem(i);
				
				// remove tooltip
				value.setTitle("");
			}
	}
}