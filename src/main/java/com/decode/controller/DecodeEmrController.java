package com.decode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emr")
public class DecodeEmrController {

	@GetMapping(value = "/saveemr")
	public String saveeEmr() {
		return "Welcome To Decode EMR";
	}

}
