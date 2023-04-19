package com.demo.speakingclock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.speakingclock.handler.SpeakingClockCustomException;
import com.demo.speakingclock.manager.SpeakingClockService;

@RestController
public class SpeakingClockController {

	Logger logger = LoggerFactory.getLogger(SpeakingClockController.class);

	@Autowired
	SpeakingClockService speakingClockService;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "v1/clock/{time}")
	public ResponseEntity getReadableTime(@PathVariable("time") String time) throws SpeakingClockCustomException {
		logger.info("Convert time to strig time");
		return new ResponseEntity<>(speakingClockService.getStringTime(time), HttpStatus.OK);
	}

}
