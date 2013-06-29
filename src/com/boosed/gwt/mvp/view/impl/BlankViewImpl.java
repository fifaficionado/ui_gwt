package com.boosed.gwt.mvp.view.impl;

import com.boosed.gwt.mvp.view.BlankView;
import com.boosed.gwt.mvp.view.BlankView.BlankPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class BlankViewImpl extends AbstractViewImpl<Void, BlankPresenter>
		implements BlankView {

	private static BlankViewImplUiBinder uiBinder = GWT
			.create(BlankViewImplUiBinder.class);

	interface BlankViewImplUiBinder extends UiBinder<Widget, BlankViewImpl> {
	}

	public BlankViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void clear() {
		// empty
	}

	@Override
	public void setData(Void t) {
		// empty
	}

	@Override
	public void showProgress() {
		// empty
	}

	@Override
	public void hideProgress() {
		// empty
	}

	@Override
	public void alert(String title, String text) {
		// empty
	}

	@Override
	public void setTitle(String title) {
		// empty
	}

	@Override
	public void setInstruction(String instruction) {
		// empty
	}
}