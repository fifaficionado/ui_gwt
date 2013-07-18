package com.boosed.gwt.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class CriterionMapAdd extends PopupPanel {

	private static CriterionMapAddUiBinder uiBinder = GWT
			.create(CriterionMapAddUiBinder.class);

	interface CriterionMapAddUiBinder extends UiBinder<Widget, CriterionMapAdd> {
	}

	/**
	 * Listen to addition of key-value pair.
	 * 
	 * @author dsumera
	 */
	public interface AddListener {
		public void onAdd(String key, String value);
	}

	@UiField
	CriterionText key;

	@UiField
	CriterionText value;

	@UiField
	Button cancel;

	@UiField
	Button add;

	private AddListener listener;
	
	private boolean paired;

	@UiField
	Label warning;

	public CriterionMapAdd() {
		setWidget(uiBinder.createAndBindUi(this));
		setGlassEnabled(true);
		setModal(true);
	}

	public void setAddListener(AddListener listener) {
		this.listener = listener;
	}

	@UiHandler("add")
	void add(ClickEvent event) {
		if (listener != null) {
			// check if flag is blank
			String k = key.getValue().trim();
			if (k.isEmpty()) {
				warning.setText(key.getName() + " must be specified");
				warning.setVisible(true);
			} else {
				listener.onAdd(k, paired ? value.getValue().trim() : k);
				// reset();
				// hide();
				cancel(event);
			}
		} else
			// there is no listener?
			cancel(event);
		// controller.doLogin(user.getValue(), password.getValue(),
		// new AsyncCallback<Void>() {
		// @Override
		// public void onFailure(Throwable caught) {
		// warning.setText("invalid credentials");
		// warning.setVisible(true);
		// }
		//
		// @Override
		// public void onSuccess(Void result) {
		// reset();
		// hide();
		// }
		// });
	}

	@UiHandler("cancel")
	void cancel(ClickEvent event) {
		reset();
		hide();
	}

	/* set the label of the key field */
	public void setKeyName(String name) {
		key.setName(name);
	}
	
	/* set the label of the value field */
	public void setValueName(String name) {
		value.setName(name);
	}
	
	/* whether to show value field in popup panel */
	public void setPaired(boolean enabled) {
		paired = enabled;
		value.setVisible(enabled);
	}
	
	/**
	 * Reset state of panel.
	 */
	private void reset() {
		warning.setVisible(false);
		warning.setText("");

		key.setValue("");
		value.setValue("");
	}
}