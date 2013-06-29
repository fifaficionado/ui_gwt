package com.boosed.gwt.ui.widget;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

public class PageSelectorPager extends SimplePager {

	private final HTML pageLabel = new HTML();
	private final TextBox pageSelector = new TextBox();

	public PageSelectorPager(SimplePager.Resources pagerResources) {
		super(TextLocation.CENTER, pagerResources, false, 0, true);
		HorizontalPanel layout = (HorizontalPanel) getWidget();

		pageSelector.setWidth("30px");
		pageSelector.setText("1");
		pageSelector.setAlignment(TextAlignment.RIGHT);
		pageSelector.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
					if (!pageSelector.getValue().isEmpty()) {
						Integer value = 0;
						try {
							value = Integer.parseInt(pageSelector.getValue());
						} catch (NumberFormatException nfe) {
							Window.alert("The page number must be a valid number");
							return;
						}
						if (value == 0 || !hasPage(value - 1)) {
							Window.alert("The page number is not in the range of available pages.");
							return;
						} else {
							setPage(value - 1);
						}
					}
				}
			}
		});

		layout.add(pageSelector);
		layout.add(pageLabel);
		layout.setCellHorizontalAlignment(pageSelector, HasAlignment.ALIGN_CENTER);
		layout.setCellHorizontalAlignment(pageLabel, HasAlignment.ALIGN_CENTER);
		layout.setCellVerticalAlignment(pageSelector, HasAlignment.ALIGN_MIDDLE);
		layout.setCellVerticalAlignment(pageLabel, HasAlignment.ALIGN_MIDDLE);
	}

	protected String createPageText() {
		NumberFormat formatter = NumberFormat.getFormat("#,###");
		return "&nbsp;of " + formatter.format(getPageCount());
	}
	
	@Override
	protected void onRangeOrRowCountChanged() {
		super.onRangeOrRowCountChanged();
		pageLabel.setHTML(createPageText());
		pageSelector.setText(String.valueOf( (getPage()+1) ));
	}
}