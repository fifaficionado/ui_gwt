package com.boosed.gwt.mvp.activity;

import com.boosed.gwt.mvp.place.BlankPlace;
import com.boosed.gwt.mvp.view.BlankView;
import com.boosed.gwt.mvp.view.BlankView.BlankPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class BlankActivity extends
		BaseActivity<BlankView, BlankPlace, Void, Void, BlankPresenter> implements BlankPresenter {

	public BlankActivity(BlankView view, PlaceController controller) {
		super(null, view, null, controller);
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		// set the presenter on view
		view.setPresenter(this);
		
		// set the view in panel
		panel.setWidget(view);
	}
}