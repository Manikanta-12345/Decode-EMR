package com.decode.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decode.masters.dto.CombrobiditiesMastersDTO;
import com.decode.masters.dto.DiabetecTypesDTO;
import com.decode.masters.dto.DiabetesMastersDTO;
import com.decode.masters.dto.DiseaseInterventionMastersDTO;
import com.decode.masters.dto.EmrResponse;
import com.decode.masters.dto.FeetObservationMastersDTO;
import com.decode.masters.dto.HabitualPatternMastersDTO;
import com.decode.masters.dto.LifeStyleMedicationMastersDTO;
import com.decode.masters.dto.MedicationMastersDTO;
import com.decode.masters.dto.SuggestedDilatedEyeExaminationDTO;
import com.decode.masters.dto.SuggestedEyeInterventionDTO;
import com.decode.masters.dto.SuggestedHeartInterventionDTO;
import com.decode.masters.dto.SuggestedKidneyInterventionDTO;
import com.decode.model.GlobalSequenceCounters;
import com.decode.model.Patient;
import com.decode.repository.CombrobiditiesMastersRepository;
import com.decode.repository.DiabeticTypesRepository;
import com.decode.repository.DiabetisMastersRepository;
import com.decode.repository.DiseaseInterventionMastersRepository;
import com.decode.repository.EmrDao;
import com.decode.repository.FeetObservationMastersRepository;
import com.decode.repository.GlobalSequenceRepository;
import com.decode.repository.HabitualPatternMastersRepository;
import com.decode.repository.LifeStyleMedicationRespository;
import com.decode.repository.MedicationMastersRepository;
import com.decode.repository.PatientRepository;
import com.decode.repository.SuggestedDilatedEyeExaminationRepository;
import com.decode.repository.SuggestedEyeInterventionRepository;
import com.decode.repository.SuggestedHeartInterventionRepository;
import com.decode.repository.SuggestedKidneyInterventionRepository;
import com.decode.service.DecodeBirtService;
import com.decode.service.EmrMasterService;
import com.decode.utils.BirtReportConstants;

@Service
public class EmrMasterServiceImpl implements EmrMasterService {

	@Autowired
	private DiabetisMastersRepository emrMasterRepository;
	@Autowired
	private DiabeticTypesRepository diabeticTypesRepository;
	@Autowired
	private LifeStyleMedicationRespository lifeStyleMedicationRespository;
	@Autowired
	private MedicationMastersRepository medicationMastersRepository;
	@Autowired
	private CombrobiditiesMastersRepository combrobiditiesMastersRepository;
	@Autowired
	private FeetObservationMastersRepository feetObservationMastersRepository;
	@Autowired
	private HabitualPatternMastersRepository habitualPatternMastersRepository;
	@Autowired
	private DiseaseInterventionMastersRepository diseaseInterventionMastersRepository;
	@Autowired
	private SuggestedDilatedEyeExaminationRepository suggestedDilatedEyeExaminationRepository;
	@Autowired
	private SuggestedEyeInterventionRepository suggestedEyeInterventionRepository;
	@Autowired
	private SuggestedHeartInterventionRepository suggestedHeartInterventionRepository;
	@Autowired
	private SuggestedKidneyInterventionRepository suggestedKidneyInterventionRepository;
	@Autowired
	private GlobalSequenceRepository sequenceRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DecodeBirtService decodeBirtService;
	@Autowired
	private EmrDao emrDao;

	@Override
	public List<DiabetesMastersDTO> getDiabetesMasters() {
		List<DiabetesMastersDTO> diabetesMastersList = new ArrayList<>();
		emrMasterRepository.findAll().parallelStream().forEach(master -> {
			DiabetesMastersDTO diabetesMaster = new DiabetesMastersDTO();
			diabetesMaster.setId(master.getId());
			diabetesMaster.setName(master.getName());
			diabetesMastersList.add(diabetesMaster);
		});
		return diabetesMastersList;
	}

	@Override
	public List<DiabetecTypesDTO> getDiabetesTypes() {
		List<DiabetecTypesDTO> diabetesTypesList = new ArrayList<>();
		diabeticTypesRepository.findAll().parallelStream().forEach(master -> {
			DiabetecTypesDTO diabetesType = new DiabetecTypesDTO();
			diabetesType.setId(master.getId());
			diabetesType.setName(master.getName());
			diabetesTypesList.add(diabetesType);
		});
		return diabetesTypesList;
	}

	@Override
	public List<LifeStyleMedicationMastersDTO> getLifeStyleMedication() {
		List<LifeStyleMedicationMastersDTO> lifeStyleMedicationMastersList = new ArrayList<>();
		lifeStyleMedicationRespository.findAll().parallelStream().forEach(master -> {
			LifeStyleMedicationMastersDTO lifeStyleMedicationMasters = new LifeStyleMedicationMastersDTO();
			lifeStyleMedicationMasters.setId(master.getId());
			lifeStyleMedicationMasters.setName(master.getName());
			lifeStyleMedicationMastersList.add(lifeStyleMedicationMasters);
		});
		return lifeStyleMedicationMastersList;
	}

	@Override
	public List<MedicationMastersDTO> getMedicationMasters() {
		List<MedicationMastersDTO> medicationMastersList = new ArrayList<>();
		medicationMastersRepository.findAll().parallelStream().forEach(master -> {
			MedicationMastersDTO medicationMasters = new MedicationMastersDTO();
			medicationMasters.setId(master.getId());
			medicationMasters.setName(master.getName());
			medicationMastersList.add(medicationMasters);
		});
		return medicationMastersList;
	}

	@Override
	public List<CombrobiditiesMastersDTO> getCombrobiditiesMasters() {
		List<CombrobiditiesMastersDTO> combrobiditiesMastersList = new ArrayList<>();
		combrobiditiesMastersRepository.findAll().parallelStream().forEach(master -> {
			CombrobiditiesMastersDTO combrobiditiesMasters = new CombrobiditiesMastersDTO();
			combrobiditiesMasters.setId(master.getId());
			combrobiditiesMasters.setName(master.getName());
			combrobiditiesMastersList.add(combrobiditiesMasters);
		});
		return combrobiditiesMastersList;
	}

	@Override
	public List<FeetObservationMastersDTO> getFeetObservationMasters() {
		List<FeetObservationMastersDTO> feetObservationMastersList = new ArrayList<>();
		feetObservationMastersRepository.findAll().parallelStream().forEach(master -> {
			FeetObservationMastersDTO feetObservationMasters = new FeetObservationMastersDTO();
			feetObservationMasters.setId(master.getId());
			feetObservationMasters.setName(master.getName());
			feetObservationMastersList.add(feetObservationMasters);
		});
		return feetObservationMastersList;
	}

	@Override
	public List<HabitualPatternMastersDTO> getHabitualPatternMasters() {
		List<HabitualPatternMastersDTO> habitualPatternMastersList = new ArrayList<>();
		habitualPatternMastersRepository.findAll().parallelStream().forEach(master -> {
			HabitualPatternMastersDTO habitualPatternMasters = new HabitualPatternMastersDTO();
			habitualPatternMasters.setId(master.getId());
			habitualPatternMasters.setName(master.getName());
			habitualPatternMastersList.add(habitualPatternMasters);
		});
		return habitualPatternMastersList;
	}

	@Override
	public List<DiseaseInterventionMastersDTO> getDiseaseInterventionMasters() {
		List<DiseaseInterventionMastersDTO> diseaseInterventionMastersList = new ArrayList<>();
		diseaseInterventionMastersRepository.findAll().parallelStream().forEach(master -> {
			DiseaseInterventionMastersDTO diseaseInterventionMasters = new DiseaseInterventionMastersDTO();
			diseaseInterventionMasters.setId(master.getId());
			diseaseInterventionMasters.setName(master.getName());
			diseaseInterventionMastersList.add(diseaseInterventionMasters);
		});
		return diseaseInterventionMastersList;
	}

	@Override
	public List<SuggestedDilatedEyeExaminationDTO> getSuggestedDilatedEyeExamination() {
		List<SuggestedDilatedEyeExaminationDTO> suggestedDilatedEyeExaminationList = new ArrayList<>();
		suggestedDilatedEyeExaminationRepository.findAll().parallelStream().forEach(master -> {
			SuggestedDilatedEyeExaminationDTO suggestedDilatedEyeExamination = new SuggestedDilatedEyeExaminationDTO();
			suggestedDilatedEyeExamination.setId(master.getId());
			suggestedDilatedEyeExamination.setName(master.getName());
			suggestedDilatedEyeExaminationList.add(suggestedDilatedEyeExamination);
		});
		return suggestedDilatedEyeExaminationList;
	}

	@Override
	public List<SuggestedEyeInterventionDTO> getSuggestedEyeIntervention() {
		List<SuggestedEyeInterventionDTO> suggestedEyeInterventionList = new ArrayList<>();
		suggestedEyeInterventionRepository.findAll().parallelStream().forEach(master -> {
			SuggestedEyeInterventionDTO suggestedEyeIntervention = new SuggestedEyeInterventionDTO();
			suggestedEyeIntervention.setId(master.getId());
			suggestedEyeIntervention.setName(master.getName());
			suggestedEyeInterventionList.add(suggestedEyeIntervention);
		});
		return suggestedEyeInterventionList;
	}

	@Override
	public List<SuggestedHeartInterventionDTO> getSuggestedHeartIntervention() {
		List<SuggestedHeartInterventionDTO> suggestedHeartInterventionList = new ArrayList<>();
		suggestedHeartInterventionRepository.findAll().parallelStream().forEach(master -> {
			SuggestedHeartInterventionDTO suggestedHeartIntervention = new SuggestedHeartInterventionDTO();
			suggestedHeartIntervention.setId(master.getId());
			suggestedHeartIntervention.setName(master.getName());
			suggestedHeartInterventionList.add(suggestedHeartIntervention);
		});
		return suggestedHeartInterventionList;
	}

	@Override
	public List<SuggestedKidneyInterventionDTO> getSuggestedKidneyIntervention() {
		List<SuggestedKidneyInterventionDTO> suggestedKidneyInterventionList = new ArrayList<>();
		suggestedKidneyInterventionRepository.findAll().parallelStream().forEach(master -> {
			SuggestedKidneyInterventionDTO suggestedKidneyIntervention = new SuggestedKidneyInterventionDTO();
			suggestedKidneyIntervention.setId(master.getId());
			suggestedKidneyIntervention.setName(master.getName());
			suggestedKidneyInterventionList.add(suggestedKidneyIntervention);
		});
		return suggestedKidneyInterventionList;
	}

	@Override
	public EmrResponse savePatient(Patient patient) {
		Patient patientFromDB = patientRepository.save(patient);
		EmrResponse response = new EmrResponse();
		if (patient.getEpisodes() != null) {
			Map<Object, Object> reportParams = new HashMap<>();
			reportParams.put("patientId", patientFromDB.getPatientId());
			reportParams.put("episodeId", patientFromDB.getEpisodes().stream().findFirst().get().getEpisodeId());
			byte[] report = decodeBirtService.generateReport(reportParams, BirtReportConstants.PDF_FORMAT);
			response.setReport(report);
		}
		response.setMessage("Patient Created Successfully");
		response.setStatusCode("Success");
		System.out.println("before return " + response.getReport());
		return response;
	}

	@Override
	public void updateGlobalCounter(GlobalSequenceCounters globalCounter) {
		sequenceRepository.save(globalCounter);
	}

	@Override
	public GlobalSequenceCounters getSequenceCounter(int orgId) {
		return emrDao.getPatientSequenceCounter(orgId);
	}

	@Override
	public GlobalSequenceCounters getEpisodeCounter(int orgId, int locId) {
		return emrDao.getEpisodeSequenceCounter(orgId, locId);
	}
}
