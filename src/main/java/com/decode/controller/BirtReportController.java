package com.decode.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decode.service.DecodeBirtService;

@RestController
public class BirtReportController {
	@Autowired
	public DecodeBirtService decodeBirtService;

	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public void getBirtReport(@RequestParam("patientId") String patientId, @RequestParam("episodeId") String episodeId,
			@RequestParam("reportFormat") String reportFormat) {
		Map<Object, Object> reportParams = new HashMap<Object, Object>();
		reportParams.put("patientId", patientId);
		reportParams.put("episodeId", episodeId);

		decodeBirtService.generateReport(reportParams, reportFormat);
	}

}
