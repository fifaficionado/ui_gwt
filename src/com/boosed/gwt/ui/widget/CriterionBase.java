package com.boosed.gwt.ui.widget;

import com.boosed.gwt.ui.Criterion;
import com.boosed.gwt.ui.Resources;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public abstract class CriterionBase<T extends Widget> extends Composite
		implements Criterion {

	/* wrapped widget */
	@UiField
	T value;

	static {
		// static init of css resources
		Resources.INSTANCE.criterionCss().ensureInjected();
	}

	@Override
	public void showError(String error) {
		if (error == null) {
			value.removeStyleName(Resources.INSTANCE.criterionCss().error());
			value.setTitle("");
		} else {
			value.addStyleName(Resources.INSTANCE.criterionCss().error());
			value.setTitle(error);
		}
	}

	@Override
	public void setHeight(String height) {
		value.setHeight(height);
	}

	@Override
	public void setWidth(String width) {
		// super.setWidth(width);
		value.setWidth(width);
	}
}