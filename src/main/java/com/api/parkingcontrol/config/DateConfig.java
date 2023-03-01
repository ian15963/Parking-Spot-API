package com.api.parkingcontrol.config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class DateConfig {

	public static final String DATE_FORMAT ="yyyy-MM-dd'T'HH-mm-ss'Z'";
	public static LocalDateTimeSerializer localDateTimerSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT));
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		JavaTimeModule module = new JavaTimeModule();
		module.addSerializer(localDateTimerSerializer);
		return new ObjectMapper().registerModule(module);
	}
	
}
