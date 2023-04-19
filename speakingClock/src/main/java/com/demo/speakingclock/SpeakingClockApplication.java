package com.demo.speakingclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.speakingclock")
public class SpeakingClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingClockApplication.class, args);
	}

}
