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
	CriterionText flag;

	@UiField
	CriterionText argument;

	@UiField
	Button cancel;

	@UiField
	Button add;

	private AddListener listener;

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
			String key = flag.getValue().trim();
			if (key.isEmpty()) {
				warning.setText("flag must be specified");
				warning.setVisible(true);
			} else {
				listener.onAdd(key, argument.getValue().trim());
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

	/**
	 * Reset state of panel.
	 */
	private void reset() {
		warning.setVisible(false);
		warning.setText("");

		flag.setValue("");
		argument.setValue("");
	}
}