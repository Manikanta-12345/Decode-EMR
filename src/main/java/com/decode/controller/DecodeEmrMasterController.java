package com.decode.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decode.masters.dto.CombrobiditiesMastersDTO;
import com.decode.masters.dto.CountryDto;
import com.decode.masters.dto.DiabetecTypesDTO;
import com.decode.masters.dto.DiabetesMastersDTO;
import com.decode.masters.dto.DiseaseInterventionMastersDTO;
import com.decode.masters.dto.DistrictDto;
import com.decode.masters.dto.FeetObservationMastersDTO;
import com.decode.masters.dto.HabitualPatternMastersDTO;
import com.decode.masters.dto.LifeStyleMedicationMastersDTO;
import com.decode.masters.dto.MedicationMastersDTO;
import com.decode.masters.dto.PatientDto;
import com.decode.masters.dto.StateDto;
import com.decode.masters.dto.SuggestedDilatedEyeExaminationDTO;
import com.decode.masters.dto.SuggestedEyeInterventionDTO;
import com.decode.masters.dto.SuggestedHeartInterventionDTO;
import com.decode.masters.dto.SuggestedKidneyInterventionDTO;
import com.decode.model.Patient;
import com.decode.repository.CountriesRepository;
import com.decode.repository.DistrictRepository;
import com.decode.repository.StateRepository;
import com.decode.service.EmrMasterService;

@RestController
@RequestMapping("/masters")
public class DecodeEmrMasterController {

	@Autowired
	private EmrMasterService emrMasterService;
	@Autowired
	private CountriesRepository countriesRepository;
	@Autowired
	private StateRepository statesRepository;
	@Autowired
	private DistrictRepository districtsRepository;

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

	@RequestMapping(value = "/getlifestylemedication", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LifeStyleMedicationMastersDTO>> getLifeStyleMedication() {
		List<LifeStyleMedicationMastersDTO> lifeStyleMedicationMastersList = emrMasterService.getLifeStyleMedication();
		return new ResponseEntity<List<LifeStyleMedicationMastersDTO>>(lifeStyleMedicationMastersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getmedicationmasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MedicationMastersDTO>> getMedicationMasters() {
		List<MedicationMastersDTO> medicationMastersList = emrMasterService.getMedicationMasters();
		return new ResponseEntity<List<MedicationMastersDTO>>(medicationMastersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getcombrobiditiesmasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CombrobiditiesMastersDTO>> getCombrobiditiesMasters() {
		List<CombrobiditiesMastersDTO> combrobiditiesMastersList = emrMasterService.getCombrobiditiesMasters();
		return new ResponseEntity<List<CombrobiditiesMastersDTO>>(combrobiditiesMastersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getfeetobservationmasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FeetObservationMastersDTO>> getFeetObservationMasters() {
		List<FeetObservationMastersDTO> feetObservationMastersList = emrMasterService.getFeetObservationMasters();
		return new ResponseEntity<List<FeetObservationMastersDTO>>(feetObservationMastersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/gethabitualpatternmasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HabitualPatternMastersDTO>> getHabitualPatternMasters() {
		List<HabitualPatternMastersDTO> habitualPatternMastersList = emrMasterService.getHabitualPatternMasters();
		return new ResponseEntity<List<HabitualPatternMastersDTO>>(habitualPatternMastersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getdiseaseinterventionmasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DiseaseInterventionMastersDTO>> getDiseaseInterventionMasters() {
		List<DiseaseInterventionMastersDTO> diseaseInterventionMastersList = emrMasterService
				.getDiseaseInterventionMasters();
		return new ResponseEntity<List<DiseaseInterventionMastersDTO>>(diseaseInterventionMastersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getsuggesteddilatedeyeexamination", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuggestedDilatedEyeExaminationDTO>> getSuggestedDilatedEyeExamination() {
		List<SuggestedDilatedEyeExaminationDTO> suggestedDilatedEyeExaminationList = emrMasterService
				.getSuggestedDilatedEyeExamination();
		return new ResponseEntity<List<SuggestedDilatedEyeExaminationDTO>>(suggestedDilatedEyeExaminationList,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/getsuggestedeyeintervention", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuggestedEyeInterventionDTO>> getSuggestedEyeIntervention() {
		List<SuggestedEyeInterventionDTO> suggestedEyeInterventionList = emrMasterService.getSuggestedEyeIntervention();
		return new ResponseEntity<List<SuggestedEyeInterventionDTO>>(suggestedEyeInterventionList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getsuggestedheartintervention", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuggestedHeartInterventionDTO>> getSuggestedHeartIntervention() {
		List<SuggestedHeartInterventionDTO> suggestedHeartInterventionList = emrMasterService
				.getSuggestedHeartIntervention();
		return new ResponseEntity<List<SuggestedHeartInterventionDTO>>(suggestedHeartInterventionList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getsuggestedkidneyintervention", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuggestedKidneyInterventionDTO>> getSuggestedKidneyIntervention() {
		List<SuggestedKidneyInterventionDTO> suggestedKidneyInterventionList = emrMasterService
				.getSuggestedKidneyIntervention();
		return new ResponseEntity<List<SuggestedKidneyInterventionDTO>>(suggestedKidneyInterventionList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getCountries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Cacheable
	public ResponseEntity<List<CountryDto>> getCountries() {
		List<CountryDto> response = countriesRepository.findCountries();
		return new ResponseEntity<List<CountryDto>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getStates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Cacheable
	public ResponseEntity<List<StateDto>> getStates(@RequestParam("id") int id,
			@RequestParam("parentId") int countryId) {
		List<StateDto> response = statesRepository.findStates(id, countryId);
		return new ResponseEntity<List<StateDto>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getDistricts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Cacheable
	public ResponseEntity<List<DistrictDto>> getDistricts(@RequestParam("id") int id,
			@RequestParam("parentId") int stateId) {
		List<DistrictDto> districts = districtsRepository.findDistricts(id, stateId);
		return new ResponseEntity<List<DistrictDto>>(districts, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveemr", method = RequestMethod.POST)
	public ResponseEntity<String> saveeEmr(@RequestBody PatientDto patientDTO) {
		System.out.println("patient " + patientDTO);
		patientDTO.getEpisodes().parallelStream().forEach(epi -> {
			System.out.println("episode " + epi);
		});
		ModelMapper mapper = new ModelMapper();

		mapper.getConfiguration().setFieldMatchingEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldAccessLevel(AccessLevel.PRIVATE).setSkipNullEnabled(true).setAmbiguityIgnored(true)
				.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
		Patient patient = mapper.map(patientDTO, Patient.class);
		patient.setPatientId("MRD0002");
		patient.getEpisodes().parallelStream().forEach(ep -> {
			ep.setPatient(patient);
			ep.setEpisodeId("DVN002");
			ep.getDiseaseHistory().setEpisode(ep);
			ep.getEyeHealth().setEpisode(ep);
			ep.getFamilyHistory().setEpisode(ep);
			ep.getHeartHealth().setEpisode(ep);
			ep.getFeetHealth().setEpisode(ep);
			ep.getKidneyHealth().setEpisode(ep);
			ep.getNextAppointments().setEpisode(ep);
		});
		System.out.println("patient model " + patient);
		emrMasterService.savePatient(patient);
		return new ResponseEntity("Hello", HttpStatus.OK);
	}
}
