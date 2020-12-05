package com.decode.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.fop.image.EPSImage;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decode.masters.dto.CombrobiditiesMastersDTO;
import com.decode.masters.dto.CountryDto;
import com.decode.masters.dto.DiabetecTypesDTO;
import com.decode.masters.dto.DiabetesMastersDTO;
import com.decode.masters.dto.DiseaseHistoryDto;
import com.decode.masters.dto.DiseaseInterventionMastersDTO;
import com.decode.masters.dto.DiseaseSeverityAndControlStatusDto;
import com.decode.masters.dto.DistrictDto;
import com.decode.masters.dto.EmrResponse;
import com.decode.masters.dto.EpisodeDto;
import com.decode.masters.dto.EyeHealthDto;
import com.decode.masters.dto.FamilyHistoryDto;
import com.decode.masters.dto.FeetHealthDto;
import com.decode.masters.dto.FeetObservationMastersDTO;
import com.decode.masters.dto.HabitualPatternMastersDTO;
import com.decode.masters.dto.HeartHealthDto;
import com.decode.masters.dto.KidneyHealthDto;
import com.decode.masters.dto.LifeStyleMedicationMastersDTO;
import com.decode.masters.dto.MedicationMastersDTO;
import com.decode.masters.dto.NextAppointmentsDto;
import com.decode.masters.dto.PatientDto;
import com.decode.masters.dto.PatientSearchDto;
import com.decode.masters.dto.StateDto;
import com.decode.masters.dto.SuggestedDilatedEyeExaminationDTO;
import com.decode.masters.dto.SuggestedEyeInterventionDTO;
import com.decode.masters.dto.SuggestedHeartInterventionDTO;
import com.decode.masters.dto.SuggestedKidneyInterventionDTO;
import com.decode.model.Episode;
import com.decode.model.EyeHealth;
import com.decode.model.FeetHealth;
import com.decode.model.KidneyHealth;
import com.decode.model.NextAppointments;
import com.decode.model.Patient;
import com.decode.repository.CountriesRepository;
import com.decode.repository.DistrictRepository;
import com.decode.repository.EmrDao;
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
	@Autowired
	private EmrDao emrDao;

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

	@RequestMapping(value = "/getPatient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Cacheable
	public ResponseEntity<PatientDto> getPatient(@RequestParam("patientId") String patientId) {
		System.out.println("pa" + patientId);
		Patient patient = emrDao.getPatient(patientId);
		ModelMapper mapper = new ModelMapper();
		PatientDto response = mapper.map(patient, PatientDto.class);
		return new ResponseEntity<PatientDto>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getEpisode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Cacheable
	public ResponseEntity<PatientDto> geEpisode(@RequestParam("episodeId") String episodeId) {
		System.out.println("pa" + episodeId);
		Episode episode = emrDao.getEpisode(episodeId);
		List<EpisodeDto> episodes = new ArrayList<>();
		PatientDto response = new PatientDto();

		episodes.add(getEpisodeDto(episode));
		response.setEpisodes(episodes);
		return new ResponseEntity<PatientDto>(response, HttpStatus.OK);
	}

	public EpisodeDto getEpisodeDto(Episode episode) {
		if (episode != null) {
			EpisodeDto episodeDto = new EpisodeDto();

			episodeDto.setCreatedUser(episode.getCreatedUser());
			episodeDto.setCreatedDate(episode.getCreatedDate());
			episodeDto.setEpisodeId(episode.getEpisodeId());
			episodeDto.setOrgId(episode.getOrgId());
			episodeDto.setLocationId(episode.getLocationId());
			if (episode.getDiseaseHistory() != null) {
				DiseaseHistoryDto history = new DiseaseHistoryDto();
				history.setComorBidities(episode.getDiseaseHistory().getComorBidities() != null
						? Arrays.asList(episode.getDiseaseHistory().getComorBidities().split(","))
						: null);
				history.setDiseaseName(episode.getDiseaseHistory().getDiseaseName());
				history.setDiseaseType(episode.getDiseaseHistory().getDiseaseType());
				history.setDuration(episode.getDiseaseHistory().getDuration());
				history.setId(episode.getDiseaseHistory().getId());
				history.setLsm(episode.getDiseaseHistory().getLsm());
				history.setMedication(episode.getDiseaseHistory().getMedication());
				history.setTypeOfOralMedication(episode.getDiseaseHistory().getTypeOfOralMedication());
				history.setCreatedDate(episode.getDiseaseHistory().getCreatedDate());
				history.setCreateduser(episode.getDiseaseHistory().getCreateduser());
				episodeDto.setDiseaseHistory(history);

			}
			if (episode.getDiseaseSeverity() != null) {
				DiseaseSeverityAndControlStatusDto severity = new DiseaseSeverityAndControlStatusDto();
				severity.setCreatedDate(episode.getDiseaseSeverity().getCreatedDate());
				severity.setCreateduser(episode.getDiseaseSeverity().getCreateduser());
				severity.setBloodSugarLevels(episode.getDiseaseSeverity().getBloodSugarLevels());
				severity.setHbA1c(episode.getDiseaseSeverity().getHbA1c());
				severity.setId(episode.getDiseaseSeverity().getId());
				severity.setSuggestedHba1cMonitoring(episode.getDiseaseSeverity().getSuggestedHba1cMonitoring());
				severity.setSuggestedPlasma(episode.getDiseaseSeverity().getSuggestedPlasma());
				severity.setSuggestedInterventionForDisease(
						episode.getDiseaseSeverity().getSuggestedInterventionForDisease() != null
								? Arrays.asList(
										episode.getDiseaseSeverity().getSuggestedInterventionForDisease().split(","))
								: null);
				episodeDto.setDiseaseSeverity(severity);
			}
			if (episode.getFamilyHistory() != null) {
				FamilyHistoryDto family = new FamilyHistoryDto();
				family.setAlcoholConsumption(episode.getFamilyHistory().getAlcoholConsumption());
				family.setCreatedDate(episode.getFamilyHistory().getCreatedDate());
				family.setCreateduser(episode.getFamilyHistory().getCreateduser());
				family.setEmotionalStress(episode.getFamilyHistory().getEmotionalStress());
				family.setHabitualPattern(episode.getFamilyHistory().getHabitualPattern());
				family.setHistoryOfSmoking(episode.getFamilyHistory().getHistoryOfSmoking());
				family.setRelation(episode.getFamilyHistory().getRelation());
				family.setId(episode.getFamilyHistory().getId());
				family.setSleep(episode.getFamilyHistory().getSleep());
				episodeDto.setFamilyHistory(family);
			}
			if (episode.getHeartHealth() != null) {
				HeartHealthDto heart = new HeartHealthDto();
				heart.setBloodPressure(episode.getHeartHealth().getBloodPressure());
				heart.setBmi(episode.getHeartHealth().getBmi());
				heart.setCreatedDate(episode.getHeartHealth().getCreatedDate());
				heart.setCreateduser(episode.getHeartHealth().getCreateduser());
				heart.setHdlCholestrol(episode.getHeartHealth().getHdlCholestrol());
				heart.setHdlRatio(episode.getHeartHealth().getHdlRatio());
				heart.setHeight(episode.getHeartHealth().getHeight());
				heart.setLdlCholestrol(episode.getHeartHealth().getLdlCholestrol());
				heart.setWeight(episode.getHeartHealth().getWeight());
				heart.setId(episode.getHeartHealth().getId());
				heart.setVldlCholestrol(episode.getHeartHealth().getVldlCholestrol());
				heart.setLdlCholestrol(episode.getHeartHealth().getLdlCholestrol());
				heart.setTriglycerides(episode.getHeartHealth().getTriglycerides());
				heart.setTotalCholestrol(episode.getHeartHealth().getTotalCholestrol());
				heart.setSuggestedCholestrolMonitoring(episode.getHeartHealth().getSuggestedCholestrolMonitoring());
				heart.setSuggestePressureMonitoring(episode.getHeartHealth().getSuggestePressureMonitoring());
				heart.setSuggestedInterventionForheart(
						episode.getHeartHealth().getSuggestedInterventionForheart() != null
								? Arrays.asList(episode.getHeartHealth().getSuggestedInterventionForheart().split(","))
								: null);
				episodeDto.setHeartHealth(heart);

			}
			if (episode.getKidneyHealth() != null) {
				KidneyHealthDto kidney = new KidneyHealthDto();
				KidneyHealth kidneyModel = episode.getKidneyHealth();
				kidney.setBloodUrea(kidneyModel.getBloodUrea());
				kidney.setCreatedDate(kidneyModel.getCreatedDate());
				kidney.setCreateduser(kidneyModel.getCreateduser());
				kidney.setId(kidneyModel.getId());
				kidney.setMicroAlbumin(kidneyModel.getMicroAlbumin());
				kidney.setProtien(kidneyModel.getProtien());
				kidney.setSerumCreatinine(kidneyModel.getSerumCreatinine());
				kidney.setSugar(kidneyModel.getSugar());
				kidney.setSuggestedKidneyMonitoring(kidneyModel.getSuggestedKidneyMonitoring());
				kidney.setSuggestedInterventionForKidney(kidneyModel.getSuggestedInterventionForKidney() != null
						? Arrays.asList(kidneyModel.getSuggestedInterventionForKidney().split(","))
						: null);
				episodeDto.setKidneyHealth(kidney);
			}
			if (episode.getEyeHealth() != null) {
				EyeHealthDto eye = new EyeHealthDto();
				EyeHealth eyeModel = episode.getEyeHealth();
				eye.setCreatedDate(eyeModel.getCreatedDate());
				eye.setCreateduser(eyeModel.getCreateduser());
				eye.setId(eyeModel.getId());
				eye.setLeftEyeNotes(eyeModel.getLeftEyeNotes());
				eye.setRightEyeNotes(eyeModel.getRightEyeNotes());
				eye.setSuggestedDilatedEyeExamination(eyeModel.getSuggestedDilatedEyeExamination() != null
						? Arrays.asList(eyeModel.getSuggestedDilatedEyeExamination().split(","))
						: null);
				eye.setSuggestedInterventionForEye(eyeModel.getSuggestedInterventionForEye() != null
						? Arrays.asList(eyeModel.getSuggestedInterventionForEye().split(","))
						: null);
				episodeDto.setEyeHealth(eye);
			}
			if (episode.getFeetHealth() != null) {
				FeetHealthDto feet = new FeetHealthDto();
				FeetHealth feetModel = episode.getFeetHealth();
				feet.setCreatedDate(feetModel.getCreatedDate());
				feet.setCreateduser(feetModel.getCreateduser());
				feet.setId(feetModel.getId());
				feet.setLeftFeetCondition(feetModel.getLeftFeetCondition());
				feet.setRightFeetCondition(feetModel.getRightFeetCondition());
				feet.setLeftFeetCounter(feetModel.getLeftFeetCounter());
				feet.setRightFeetCounter(feetModel.getRightFeetCounter());
				// observation
				feet.setLeftFeetObservation(feetModel.getLeftFeetObservation() != null
						? Arrays.asList(feetModel.getLeftFeetObservation().split(","))
						: null);
				feet.setRightFeetObservation(feetModel.getRightFeetObservation() != null
						? Arrays.asList(feetModel.getRightFeetObservation().split(","))
						: null);

				// ulceration
				feet.setRightFeetUlceration(feetModel.getRightFeetUlceration() != null
						? Arrays.asList(feetModel.getRightFeetUlceration().split(","))
						: null);
				feet.setLeftFeetUlceration(feetModel.getLeftFeetUlceration() != null
						? Arrays.asList(feetModel.getLeftFeetUlceration().split(","))
						: null);

				// vibration
				feet.setLeftFeetVibration(feetModel.getLeftFeetVibration() != null
						? Arrays.asList(feetModel.getLeftFeetVibration().split(","))
						: null);
				feet.setRightFeetVibration(feetModel.getRightFeetVibration() != null
						? Arrays.asList(feetModel.getRightFeetVibration().split(","))
						: null);

				episodeDto.setFeetHealth(feet);
			}
			if (episode.getNextAppointments() != null) {
				NextAppointmentsDto app = new NextAppointmentsDto();
				NextAppointments appModel = episode.getNextAppointments();
				app.setId(appModel.getId());
				app.setRetinalExaminastion(appModel.getRetinalExaminastion());
				app.setBloodPressureDate(appModel.getBloodPressureDate());
				app.setCholestrolMonitoring(appModel.getCholestrolMonitoring());
				app.setCreatedDate(appModel.getCreatedDate());
				app.setCreateduser(appModel.getCreateduser());
				app.setHbA1cMonitoring(appModel.getHbA1cMonitoring());
				app.setKidneyFunctions(appModel.getKidneyFunctions());
				app.setNeuropathyScreening(appModel.getNeuropathyScreening());
				app.setPlasmaMonitoring(appModel.getPlasmaMonitoring());
				episodeDto.setNextAppointments(app);
			}

			return episodeDto;
		}
		return null;
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
			if (patient.getEpisodes() != null) {
				EmrResponse response = emrMasterService.savePatient(patient);
				if (response.getReport() != null) {
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_PDF);
					System.out.println("res in con " + response.getReport());
					byte[] input = "manikanta".getBytes();
					System.out.println("in b" + input);
					String encodeBase64String = Base64.getEncoder().encodeToString(response.getReport());
					System.out.println("base64 " + encodeBase64String);
					return new ResponseEntity<byte[]>(response.getReport(), HttpStatus.OK);
				} else {
					return new ResponseEntity(null, HttpStatus.OK);
				}
			} else if (patient.getEpisodes() == null) {
				System.out.println("yes only patient...");
				emrDao.updatePatient(patient);
				return new ResponseEntity(null, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setPatientProperties(Patient patient) {
		if (patient.getPatientAddress() != null) {
			patient.getPatientAddress().setPatient(patient);
		}
		setDates(patient);
		if (patient.getEpisodes() != null) {
			patient.getEpisodes().parallelStream().forEach(ep -> {
				ep.setPatient(patient);
				ep.setStatus("Active");
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
	}

	public void setDates(Patient patient) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged user " + name);
		if (patient.getPatientId() == null) {
			patient.setCreatedDate(new Date());
			patient.setCreateduser(name);
		} else {
			patient.setLastUpdateDate(new Date());
			patient.setLastUpdatedUser(name);
		}
		if (patient.getEpisodes() != null) {
			patient.getEpisodes().parallelStream().forEach(ep -> {
				if (ep.getEpisodeId() == null) {
					ep.setCreatedDate(new Date());
					ep.setCreatedUser(name);
				} else {
					ep.setLastUpdateDate(new Date());
					ep.setLastUpdatedUser(name);
				}
			});
		}
	}

	public void setDiseaseHistory(Episode ep) {
		if (ep.getDiseaseHistory() != null) {
			ep.getDiseaseHistory().setEpisode(ep);
			if (ep.getDiseaseHistory().getComorBidities() != null) {
				String trim = ep.getDiseaseHistory().getComorBidities().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				System.out.println("trim  " + trim);
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getDiseaseHistory().setComorBidities(result);
			}
		}
	}

	public void setSeverity(Episode ep) {
		if (ep.getDiseaseSeverity() != null) {
			ep.getDiseaseSeverity().setEpisode(ep);
			if (ep.getDiseaseSeverity().getSuggestedInterventionForDisease() != null) {
				String trim = ep.getDiseaseSeverity().getSuggestedInterventionForDisease().replaceAll("\\[", "")
						.replaceAll("\\]", "");
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getDiseaseSeverity().setSuggestedInterventionForDisease(result);
			}
		}
	}

	public void setEyeHealth(Episode ep) {
		if (ep.getEyeHealth() != null) {
			ep.getEyeHealth().setEpisode(ep);
			if (ep.getEyeHealth().getSuggestedDilatedEyeExamination() != null) {
				String trim = ep.getEyeHealth().getSuggestedDilatedEyeExamination().replaceAll("\\[", "")
						.replaceAll("\\]", "");
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getEyeHealth().setSuggestedDilatedEyeExamination(result);
			}
			if (ep.getEyeHealth().getSuggestedInterventionForEye() != null) {
				String trim = ep.getEyeHealth().getSuggestedInterventionForEye().replaceAll("\\[", "").replaceAll("\\]",
						"");
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getEyeHealth().setSuggestedInterventionForEye(result);
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
				String trim = ep.getHeartHealth().getSuggestedInterventionForheart().replaceAll("\\[", "")
						.replaceAll("\\]", "");
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getHeartHealth().setSuggestedInterventionForheart(result);
			}
		}
	}

	public void setFeetHealth(Episode ep) {
		if (ep.getFeetHealth() != null) {
			ep.getFeetHealth().setEpisode(ep);
			if (ep.getFeetHealth().getRightFeetObservation() != null) {
				String trim = ep.getFeetHealth().getRightFeetObservation().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setRightFeetObservation(result);
			}
			if (ep.getFeetHealth().getLeftFeetObservation() != null) {

				String trim = ep.getFeetHealth().getLeftFeetObservation().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setLeftFeetObservation(result);
			}
			if (ep.getFeetHealth().getRightFeetUlceration() != null) {

				String trim = ep.getFeetHealth().getRightFeetUlceration().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setRightFeetUlceration(result);
			}
			if (ep.getFeetHealth().getLeftFeetUlceration() != null) {

				String trim = ep.getFeetHealth().getRightFeetUlceration().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setLeftFeetUlceration(result);
			}
			if (ep.getFeetHealth().getRightFeetVibration() != null) {
				String trim = ep.getFeetHealth().getRightFeetVibration().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setRightFeetVibration(result);
			}
			if (ep.getFeetHealth().getLeftFeetVibration() != null) {
				String trim = ep.getFeetHealth().getLeftFeetVibration().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setLeftFeetVibration(result);
			}
		}
	}

	public void setKidneyHealth(Episode ep) {
		if (ep.getKidneyHealth() != null) {
			ep.getKidneyHealth().setEpisode(ep);
			if (ep.getKidneyHealth().getSuggestedInterventionForKidney() != null) {
				String trim = ep.getKidneyHealth().getSuggestedInterventionForKidney().replaceAll("\\[", "")
						.replaceAll("\\]", "").trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getKidneyHealth().setSuggestedInterventionForKidney(result);
			}
		}
	}

	public void setNextAppointments(Episode ep) {
		if (ep.getNextAppointments() != null) {
			ep.getNextAppointments().setEpisode(ep);
		}
	}

}
