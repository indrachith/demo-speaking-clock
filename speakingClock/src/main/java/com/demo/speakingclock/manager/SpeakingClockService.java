package com.demo.speakingclock.manager;

import com.demo.speakingclock.handler.SpeakingClockCustomException;

public interface SpeakingClockService {

	String getStringTime(String time) throws SpeakingClockCustomException;

}
