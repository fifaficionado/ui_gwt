package com.boosed.gwt.mvp.activity;

import com.boosed.gwt.mvp.view.AbstractView;
import com.boosed.gwt.mvp.view.AbstractView.Presenter;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * The <code>Activity</code> class is generally responsible for implementing the
 * <code>Presenter</code> interface.
 * 
 * @author dsumera
 * 
 * @param <V>
 *            view type
 * @param <P>
 *            place type
 * @param <RPC>
 *            type of rpc endpoint
 * @param <T>
 *            entity type managed by view
 * @param <X>
 *            presenter type
 */
public abstract class BaseActivity<V extends AbstractView<T, VP>, P extends Place, RPC, T, VP extends Presenter<T>>
		extends AbstractActivity implements Presenter<T> {

	/* view associated with activity */
	protected V view;

	/* place associated with activity */
	protected P place;

	/* typically an rpc endpoint to communicate */
	protected RPC rpc;

	/* controller to affect navigation */
	private PlaceController controller;

	public BaseActivity(P place, V view, RPC rpc, PlaceController controller) {
		this.place = place;
		this.view = view;
		this.rpc = rpc;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// set presenter
		view.setPresenter((VP) this);

		// clear the view
		view.clear();
	}

	@Override
	public void onNavigate(Place place) {
		// clean up before continuing to next view
		view.clear();
		controller.goTo(place);
	}

	/**
	 * Display a warning message.
	 * 
	 * @param message
	 */
	public void warn(String message) {
		Window.alert(message);
	}

	/**
	 * Display a warning message with exception.
	 * 
	 * @param message
	 * @param caught
	 */
	public void warn(String message, Throwable caught) {
		String error = caught.toString();
		error = error.substring(error.lastIndexOf('.') + 1);
		Window.alert(message.concat(": ").concat(error));
	}
}