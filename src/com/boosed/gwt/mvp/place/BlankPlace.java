package com.boosed.gwt.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BlankPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<BlankPlace> {
		@Override
		public String getToken(BlankPlace place) {
			return "blank";
		}

		@Override
		public BlankPlace getPlace(String token) {
			return new BlankPlace();
		}
	}

	// used for navigation label
	@Override
	public String toString() {
		return "blank";
	}
}