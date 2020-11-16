package com.decode.service;

import java.util.List;

import com.decode.masters.dto.DiabetecTypesDTO;
import com.decode.masters.dto.DiabetesMastersDTO;

public interface EmrMasterService {

	public List<DiabetesMastersDTO> getDiabetesMasters();
	public List<DiabetecTypesDTO> getDiabetesTypes();
}
