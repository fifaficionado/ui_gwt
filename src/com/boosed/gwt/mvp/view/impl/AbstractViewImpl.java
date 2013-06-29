package com.boosed.gwt.mvp.view.impl;

import com.boosed.gwt.mvp.view.AbstractView;
import com.boosed.gwt.mvp.view.AbstractView.Presenter;
import com.google.gwt.user.client.ui.Composite;

public abstract class AbstractViewImpl<T, P extends Presenter<T>> extends
		Composite implements AbstractView<T, P> {

	/* presenter is accessible within the view */
	protected P presenter;

	/**
	 * Set the presenter on this view.
	 */
	public void setPresenter(P presenter) {
		this.presenter = presenter;
	}
}