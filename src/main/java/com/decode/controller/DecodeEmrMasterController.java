package com.decode.controller;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.decode.masters.dto.EmrResponse;
import com.decode.masters.dto.FeetObservationMastersDTO;
import com.decode.masters.dto.HabitualPatternMastersDTO;
import com.decode.masters.dto.LifeStyleMedicationMastersDTO;
import com.decode.masters.dto.MedicationMastersDTO;
import com.decode.masters.dto.PatientDto;
import com.decode.masters.dto.PatientSearchDto;
import com.decode.masters.dto.StateDto;
import com.decode.masters.dto.SuggestedDilatedEyeExaminationDTO;
import com.decode.masters.dto.SuggestedEyeInterventionDTO;
import com.decode.masters.dto.SuggestedHeartInterventionDTO;
import com.decode.masters.dto.SuggestedKidneyInterventionDTO;
import com.decode.model.Episode;
import com.decode.model.Patient;
import com.decode.repository.CountriesRepository;
import com.decode.repository.DistrictRepository;
import com.decode.repository.EpisodeRepository;
import com.decode.repository.PatientRepository;
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
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private EpisodeRepository episodeRepository;

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

	@RequestMapping(value = "/getPatientsList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Cacheable
	public ResponseEntity<List<String>> getPatients(@RequestParam("query") String query) {
		List<PatientSearchDto> patients = patientRepository.getPatientsList(query);
		List<String> patientsList = patients.parallelStream().map(PatientSearchDto::getMatchedPatient)
				.collect(Collectors.toList());
		return new ResponseEntity<List<String>>(patientsList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getEpisodesList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Cacheable
	public ResponseEntity<List<String>> getEpisodes(@RequestParam("patientId") String patientId) {
		List<String> epList = episodeRepository.getEpisodesList(patientId);
		return new ResponseEntity<List<String>>(epList, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveemr", method = RequestMethod.POST)
	public ResponseEntity<byte[]> saveeEmr(@RequestBody PatientDto patientDTO) {
		System.out.println("org " + patientDTO.getOrgId());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFieldMatchingEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldAccessLevel(AccessLevel.PRIVATE).setPropertyCondition(Conditions.isNotNull())
				.setAmbiguityIgnored(true).setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
		Patient patient = mapper.map(patientDTO, Patient.class);
		System.out.println("patient " + patient);
		setPatientProperties(patient);
		try {
			EmrResponse response = emrMasterService.savePatient(patient);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			System.out.println("res in con " + response.getReport());
			byte[] input = "manikanta".getBytes();
			System.out.println("in b" + input);
			String encodeBase64String = Base64.getEncoder().encodeToString(response.getReport());
			System.out.println("base64 " + encodeBase64String);
			return new ResponseEntity<byte[]>(response.getReport(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setPatientProperties(Patient patient) {
		if (patient.getPatientAddress() != null) {
			patient.getPatientAddress().setPatient(patient);
		}
		patient.getEpisodes().parallelStream().forEach(ep -> {
			ep.setPatient(patient);
			setDiseaseHistory(ep);
			setSeverity(ep);
			setEyeHealth(ep);
			setFamilyHistory(ep);
			setHeartHealth(ep);
			setFeetHealth(ep);
			setKidneyHealth(ep);
			setNextAppointments(ep);

		});
	}

	public void setDiseaseHistory(Episode ep) {
		if (ep.getDiseaseHistory() != null) {
			ep.getDiseaseHistory().setEpisode(ep);
			if (ep.getDiseaseHistory().getComorBidities() != null) {
				ep.getDiseaseHistory().setComorBidities(
						ep.getDiseaseHistory().getComorBidities().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
		}
	}

	public void setSeverity(Episode ep) {
		if (ep.getDiseaseSeverity() != null) {
			ep.getDiseaseSeverity().setEpisode(ep);
			if (ep.getDiseaseSeverity().getSuggestedInterventionForDisease() != null) {
				ep.getDiseaseSeverity().setSuggestedInterventionForDisease(ep.getDiseaseSeverity()
						.getSuggestedInterventionForDisease().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
		}
	}

	public void setEyeHealth(Episode ep) {
		if (ep.getEyeHealth() != null) {
			ep.getEyeHealth().setEpisode(ep);
			if (ep.getEyeHealth().getSuggestedDilatedEyeExamination() != null) {
				ep.getEyeHealth().setSuggestedDilatedEyeExamination(ep.getEyeHealth()
						.getSuggestedDilatedEyeExamination().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			if (ep.getEyeHealth().getSuggestedInterventionForEye() != null) {
				ep.getEyeHealth().setSuggestedInterventionForEye(
						ep.getEyeHealth().getSuggestedInterventionForEye().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
		}
	}

	public void setFamilyHistory(Episode ep) {
		if (ep.getFamilyHistory() != null) {
			ep.getFamilyHistory().setEpisode(ep);
		}
	}

	public void setHeartHealth(Episode ep) {
		if (ep.getHeartHealth() != null) {
			ep.getHeartHealth().setEpisode(ep);
			if (ep.getHeartHealth().getSuggestedInterventionForheart() != null) {
				ep.getHeartHealth().setSuggestedInterventionForheart(ep.getHeartHealth()
						.getSuggestedInterventionForheart().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
		}
	}

	public void setFeetHealth(Episode ep) {
		if (ep.getFeetHealth() != null) {
			ep.getFeetHealth().setEpisode(ep);
			if (ep.getFeetHealth().getRightFeetObservation() != null) {
				ep.getFeetHealth().setRightFeetObservation(
						ep.getFeetHealth().getRightFeetObservation().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			if (ep.getFeetHealth().getLeftFeetObservation() != null) {
				ep.getFeetHealth().setLeftFeetObservation(
						ep.getFeetHealth().getLeftFeetObservation().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			if (ep.getFeetHealth().getRightFeetUlceration() != null) {
				ep.getFeetHealth().setRightFeetUlceration(
						ep.getFeetHealth().getRightFeetUlceration().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			if (ep.getFeetHealth().getLeftFeetUlceration() != null) {
				ep.getFeetHealth().setLeftFeetUlceration(
						ep.getFeetHealth().getLeftFeetUlceration().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			if (ep.getFeetHealth().getRightFeetVibration() != null) {
				ep.getFeetHealth().setRightFeetVibration(
						ep.getFeetHealth().getRightFeetVibration().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
			if (ep.getFeetHealth().getLeftFeetVibration() != null) {
				ep.getFeetHealth().setLeftFeetVibration(
						ep.getFeetHealth().getLeftFeetVibration().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
		}
	}

	public void setKidneyHealth(Episode ep) {
		if (ep.getKidneyHealth() != null) {
			ep.getKidneyHealth().setEpisode(ep);
			if (ep.getKidneyHealth().getSuggestedInterventionForKidney() != null) {
				ep.getKidneyHealth().setSuggestedInterventionForKidney(ep.getKidneyHealth()
						.getSuggestedInterventionForKidney().replaceAll("\\[", "").replaceAll("\\]", ""));
			}
		}
	}

	public void setNextAppointments(Episode ep) {
		if (ep.getNextAppointments() != null) {
			ep.getNextAppointments().setEpisode(ep);
		}
	}

}
