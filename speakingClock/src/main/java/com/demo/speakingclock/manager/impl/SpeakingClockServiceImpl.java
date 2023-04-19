package com.demo.speakingclock.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.speakingclock.error.TimeErrors;
import com.demo.speakingclock.handler.SpeakingClockCustomException;
import com.demo.speakingclock.manager.SpeakingClockService;
import com.demo.speakingclock.model.ClockModel;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {
	
	Map<Integer, String> hours = new HashMap<>();
	Map<Integer, String> mins = new HashMap<>();

	@Override
	public String getStringTime(String time) {
		String digitalTime[] = null;
		int digitalHours = 0;
		int digitalMins = 0;
		try {
			digitalTime = time.split(":");
			digitalHours = Integer.parseInt(digitalTime[0]);
			digitalMins = Integer.parseInt(digitalTime[1]);
		} catch (Exception ex) {
			throw new SpeakingClockCustomException(TimeErrors.INVALID_TIME);
		}
		try {
			if (digitalHours > 24 || digitalHours < 0) {
				throw new SpeakingClockCustomException(TimeErrors.INVALID_HOUR);
			}
		} catch (Exception ex) {
			throw new SpeakingClockCustomException(TimeErrors.INVALID_HOUR);
		}
		try {

			if (digitalMins > 60 || digitalHours < 0) {
				throw new SpeakingClockCustomException(TimeErrors.INVALID_MIN);
			}
		} catch (Exception ex) {
			throw new SpeakingClockCustomException(TimeErrors.INVALID_MIN);
		}

		getHours();
		getMins();
		ClockModel clock = new ClockModel();
		String outputTime = null;

		if (digitalMins <= 30 && digitalMins != 0) {
			clock.setReadableText(" pass ");
			clock.setHours(hours.get(digitalHours));

		} else if (digitalMins != 0 && digitalMins > 30) {
			clock.setReadableText(" to ");
			if (digitalHours == 23) {
				clock.setHours(hours.get(12));
			} else {
				clock.setHours(hours.get(digitalHours + 1));
			}
		} else {
			clock.setHours(hours.get(digitalHours));
		}

		clock.setMins(mins.get(digitalMins));

		outputTime = (clock.getMins() != null ? clock.getMins() : "")
				+ (clock.getReadableText() != null ? clock.getReadableText() : "")
				+ (clock.getHours() != null ? clock.getHours() : "")
				+ (clock.getReadableText() == null ? " o'clock" : "");
		return outputTime;
	}

	private void getMins() {
		mins.put(5, "Five");
		mins.put(10, "Ten");
		mins.put(15, "Quarter");
		mins.put(20, "Twenty");
		mins.put(25, "Twenty Five");
		mins.put(30, "Half");
		mins.put(35, "Five");
		mins.put(40, "Twenty");
		mins.put(45, "Quarter");
		mins.put(50, "Ten");
		mins.put(55, "Five");

	}

	private void getHours() {
		hours.put(1, "One");
		hours.put(2, "Two");
		hours.put(3, "Three");
		hours.put(4, "Four");
		hours.put(5, "Five");
		hours.put(6, "Six");
		hours.put(7, "Seven");
		hours.put(8, "Eight");
		hours.put(9, "Nine");
		hours.put(10, "Ten");
		hours.put(11, "Elevan");
		hours.put(12, "Twelve");
		hours.put(13, "One");
		hours.put(14, "Two");
		hours.put(15, "Three");
		hours.put(16, "Four");
		hours.put(17, "Five");
		hours.put(18, "Six");
		hours.put(19, "Seven");
		hours.put(20, "Eight");
		hours.put(21, "Nine");
		hours.put(22, "Ten");
		hours.put(23, "Elevan");
		hours.put(00, "Twelve");

	}
}