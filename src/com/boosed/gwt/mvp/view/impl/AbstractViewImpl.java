package com.boosed.gwt.mvp.view.impl;

import com.boosed.gwt.mvp.view.AbstractView;
import com.boosed.gwt.mvp.view.AbstractView.Presenter;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public abstract class AbstractViewImpl<T, P extends Presenter<T>> extends
		Composite implements AbstractView<T, P> {

	/* presenter is accessible within the view */
	protected P presenter;

	@UiField
	public Label header;

	@UiField
	public Label instruction;
	
	/**
	 * Set the presenter on this view.
	 */
	public void setPresenter(P presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setHeader(String header) {
		this.header.setText(header);
	}
	
	@Override
	public void setInstruction(String instruction) {
		this.instruction.setText(instruction);	
	}
	
//	/**
//	 * Universal cancel action.
//	 * 
//	 * @param event
//	 */
//	@UiHandler("cancel")
//	void cancel(ClickEvent event) {
//		clear();
//		presenter.onNavigate(Place.NOWHERE);
//	}
}