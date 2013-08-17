package com.boosed.gwt.ui.widget;

import com.boosed.gwt.ui.Criterion;
import com.boosed.gwt.ui.Resources;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusWidget;

public abstract class CriterionBase<T extends FocusWidget> extends Composite
		implements Criterion {

	/* wrapped widget */
	@UiField
	public T value;

	private String key;
	
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
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		value.setEnabled(enabled);	
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