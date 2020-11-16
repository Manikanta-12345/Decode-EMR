package com.decode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decode.masters.dto.DiabetecTypesDTO;
import com.decode.masters.dto.DiabetesMastersDTO;
import com.decode.repository.DiabeticTypesRepository;
import com.decode.repository.DiabetisMastersRepository;
import com.decode.service.EmrMasterService;
@Service
public class EmrMasterServiceImpl implements EmrMasterService {

	@Autowired
	private DiabetisMastersRepository emrMasterRepository;
	@Autowired
	private DiabeticTypesRepository diabeticTypesRepository;
	
	@Override
	public List<DiabetesMastersDTO> getDiabetesMasters() {
		List<DiabetesMastersDTO> diabetesMastersList=new ArrayList<>();
		emrMasterRepository.findAll().parallelStream().forEach(master->{
			DiabetesMastersDTO diabetesMaster=new DiabetesMastersDTO();
			diabetesMaster.setId(master.getId());
			diabetesMaster.setName(master.getName());
			diabetesMastersList.add(diabetesMaster);
		});
		return diabetesMastersList;
	}

	
	@Override
	public List<DiabetecTypesDTO> getDiabetesTypes() {
		List<DiabetecTypesDTO> diabetesTypesList=new ArrayList<>();
		diabeticTypesRepository.findAll().parallelStream().forEach(master->{
			DiabetecTypesDTO diabetesType=new DiabetecTypesDTO();
			diabetesType.setId(master.getId());
			diabetesType.setName(master.getName());
			diabetesTypesList.add(diabetesType);
		});
		return diabetesTypesList;
	}
}
