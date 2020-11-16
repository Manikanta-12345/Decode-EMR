package com.decode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decode.masters.dto.DiabetecTypesDTO;
import com.decode.masters.dto.DiabetesMastersDTO;
import com.decode.service.EmrMasterService;

@RestController
@RequestMapping("/masters")
public class DecodeEmrMasterController {

	@Autowired
	private EmrMasterService emrMasterService;

	@RequestMapping(value = "/getdiabetesmasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DiabetesMastersDTO>> getDiabetetsMasters() {
		List<DiabetesMastersDTO> diabetesMastersList = emrMasterService.getDiabetesMasters();
		return new ResponseEntity<List<DiabetesMastersDTO>>(diabetesMastersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getdiabetestypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DiabetecTypesDTO>> getDiabetetsType() {
		List<DiabetecTypesDTO> diabetesTypesList = emrMasterService.getDiabetesTypes();
		return new ResponseEntity<List<DiabetecTypesDTO>>(diabetesTypesList, HttpStatus.OK);
	}

}
