package com.demo.speakingclock.handler;

import com.demo.speakingclock.error.TimeErrors;

@SuppressWarnings("serial")
public class SpeakingClockCustomException extends RuntimeException {

	private final TimeErrors timeErrors;

	public TimeErrors getTimeErrors() {
		return timeErrors;
	}

	public SpeakingClockCustomException(TimeErrors timeErrors) {
		super(timeErrors.getErrorMessage());
		this.timeErrors = timeErrors;
	}
}
