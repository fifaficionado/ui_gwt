package com.boosed.gwt.mvp.view;

import com.boosed.gwt.mvp.view.AbstractView.Presenter;
import com.boosed.gwt.mvp.view.BlankView.BlankPresenter;

public interface BlankView extends AbstractView<Void, BlankPresenter> {

	public interface BlankPresenter extends Presenter<Void> {
		/* empty */
	}
}