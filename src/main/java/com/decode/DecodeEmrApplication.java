package com.decode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.decode.service.DecodeBirtService;
import com.decode.service.impl.DecodeBirtServiceImpl;

@SpringBootApplication
public class DecodeEmrApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DecodeEmrApplication.class, args);
	}

}
