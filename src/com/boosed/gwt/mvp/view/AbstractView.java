package com.boosed.gwt.mvp.view;

import com.boosed.gwt.mvp.view.AbstractView.Presenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface AbstractView<T, P extends Presenter<T>> extends IsWidget {

	/**
	 * Generic presenter interface. Defined in view interface to allow for
	 * referencing.
	 * 
	 * @author assessor
	 * 
	 * @param <T>
	 */
	public interface Presenter<T> {
		public void onNavigate(Place place);
	}

	/**
	 * Initialize view to no data.
	 */
	public void clear();

	/**
	 * Set data on this <code>AbstractView</code>.
	 * 
	 * @param t
	 */
	public void setData(T t);

	/**
	 * Set the presenter (i.e., activity) against the view implementation.
	 * 
	 * @param presenter
	 */
	public void setPresenter(P presenter);

	/**
	 * Show a progress dialog.
	 */
	public void showProgress();

	/**
	 * Hide the progress dialog.
	 */
	public void hideProgress();

	/**
	 * Display an alert.
	 * 
	 * @param title
	 * @param text
	 */
	public void alert(String title, String text);

	public void setHeader(String header);

	public void setInstruction(String instruction);
	// public void setForward(String forward);
	// public void setBack(String back);
}