package com.decode.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
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
import com.decode.masters.dto.LocationsDTO;
import com.decode.masters.dto.MedicationMastersDTO;
import com.decode.masters.dto.NextAppointmentsDto;
import com.decode.masters.dto.PatientDto;
import com.decode.masters.dto.PatientSearchDto;
import com.decode.masters.dto.ReportDTO;
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
import com.decode.service.DecodeBirtService;
import com.decode.service.EmrMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/masters")
@EnableScheduling
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

	@RequestMapping(value = "/getlocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocationsDTO>> getLocations() {
		List<LocationsDTO> locations = emrMasterService.getLocations();
		return new ResponseEntity<List<LocationsDTO>>(locations, HttpStatus.OK);
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
			episodeDto.setLeftFileName(episode.getLeftFileName());
			episodeDto.setRightFileName(episode.getRightFileName());
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
				feet.setFeetNotes(feetModel.getFeetNotes());
				feet.setLeftFeetSelected(feetModel.getLeftFeetSelected() != null
						? Arrays.asList(feetModel.getLeftFeetSelected().split(","))
						: null);
				feet.setRightFeetSelected(feetModel.getRightFeetSelected() != null
						? Arrays.asList(feetModel.getRightFeetSelected().split(","))
						: null);
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

	@PostMapping(value = "/saveemr/{user}")
	public ResponseEntity<byte[]> saveeEmr(@PathVariable("user") String user, @RequestPart("patient") String patientDTO,
			@RequestPart(value = "leftfile", required = false) MultipartFile leftfile,
			@RequestPart(value = "rightfile", required = false) MultipartFile rightfile) throws Exception {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFieldMatchingEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldAccessLevel(AccessLevel.PRIVATE).setPropertyCondition(Conditions.isNotNull())
				.setAmbiguityIgnored(true).setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
		// Patient patient = mapper.map(patientDTO, Patient.class);
		PatientDto patientdt = new ObjectMapper().readValue(patientDTO, PatientDto.class);
		Patient patient = mapper.map(patientdt, Patient.class);
		System.out.println("patient " + patient);

		setPatientProperties(patient, user, leftfile != null ? leftfile.getOriginalFilename() : null,
				rightfile != null ? rightfile.getOriginalFilename() : null);
		try {
			if (patient.getPatientId() != null) {
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
						uploadToS3Bucket(patient, leftfile, rightfile);
						return new ResponseEntity<byte[]>(response.getReport(), HttpStatus.OK);
					} else {
						return new ResponseEntity(null, HttpStatus.OK);
					}

				} else if (patient.getEpisodes() == null) {
					System.out.println("yes only patient..." + patient.getPatientId());
					setDates(patient, user);
					emrDao.updatePatient(patient);
					return new ResponseEntity(null, HttpStatus.CREATED);
				}
			} else {
				System.out.println("yes only patient save..." + patient.getPatientId());
				setDates(patient, user);
				EmrResponse response = emrMasterService.savePatient(patient);
				if (response.getReport() != null) {
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_PDF);
					System.out.println("res in con " + response.getReport());
					byte[] input = "manikanta".getBytes();
					System.out.println("in b" + input);
					String encodeBase64String = Base64.getEncoder().encodeToString(response.getReport());
					System.out.println("base64 " + encodeBase64String);
					uploadToS3Bucket(patient, leftfile, rightfile);
					return new ResponseEntity<byte[]>(response.getReport(), HttpStatus.OK);
				} else {
					return new ResponseEntity(null, HttpStatus.CREATED);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/getFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFiles(@RequestParam("patientId") String patientId,
			@RequestParam("episodeId") String episodeId, @RequestParam("currentEye") String currentEye,
			@RequestParam("fileName") String fileName) throws Exception {
		BasicAWSCredentials creds = new BasicAWSCredentials("AKIAVSJSPPJPABQSEDFW",
				"+snXV+LTbl9EEaRmWSBVmeQzCXevf6OHbmMo+QCu");
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds))
				.withRegion(Regions.AP_SOUTH_1).build();

		GetObjectRequest req = new GetObjectRequest("decode-patients-images",
				patientId + "/" + episodeId + "/" + currentEye + "/" + fileName);
		S3Object object = s3Client.getObject(req);
		InputStream is = object.getObjectContent();
		byte[] bytes = getBytesFromInputStream(is);
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentLength(bytes.length);
		respHeaders.setContentType(new MediaType("text", "json"));
		respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		return new ResponseEntity<byte[]>(bytes, respHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/getReports", method = RequestMethod.GET)
	public ResponseEntity<List<ReportDTO>> getReportsData(
			@RequestParam(value = "patientId", required = false) String patientId,
			@RequestParam(value = "from", required = false) String fromDate,
			@RequestParam(value = "to", required = false) String toDate) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date frmDate = null;
		Date tDate = null;
		List<ReportDTO> reports=null;
		if (!fromDate.equals("null")) {
			frmDate = getStartTime(format.parse(fromDate)).getTime();
		}
		if (!toDate.equals("null")) {
			tDate = getEndTime(format.parse(toDate)).getTime();
		}
		System.out.println("from date " + frmDate);
		System.out.println("to date " + tDate);
		if(patientId.equals("null")) {
		 reports = episodeRepository.getRepors(frmDate, tDate);
		}else if(patientId!=null) {
			 reports = episodeRepository.getReporsOfPatient(frmDate, tDate,patientId);
		}
		return new ResponseEntity<List<ReportDTO>>(reports, HttpStatus.OK);
	}
	@Autowired
	public DecodeBirtService decodeBirtService;

	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getBirtReport(@RequestParam("patientId") String patientId, @RequestParam("episodeId") String episodeId
		) {
		Map<Object, Object> reportParams = new HashMap<Object, Object>();
		reportParams.put("patientId", patientId);
		reportParams.put("episodeId", episodeId);

		byte[] generateReport = decodeBirtService.generateReport(reportParams, "pdf");
		return new ResponseEntity<byte[]>(generateReport, HttpStatus.OK);
	}
	public Calendar getEndTime(Date toDate) {
		if (toDate != null) {
			Calendar endDate = Calendar.getInstance();
			endDate.setTime(toDate);

			endDate.set(Calendar.HOUR_OF_DAY, 23);
			endDate.set(Calendar.MINUTE, 59);
			endDate.set(Calendar.SECOND, 59);
			endDate.set(Calendar.MILLISECOND, 999);

			return endDate;
		} else {
			return null;
		}

	}

	public Calendar getStartTime(Date fromDate) {
		if (fromDate != null) {
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(fromDate);
			startDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DATE), 0,
					0, 0);
			return startDate;
		} else {
			return null;
		}

	}

	public static byte[] getBytesFromInputStream(InputStream is) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] buffer = new byte[0xFFFF];
		for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
			os.write(buffer, 0, len);
		}
		return os.toByteArray();
	}

	public void uploadToS3Bucket(Patient patient, MultipartFile leftFile, MultipartFile rightFile) throws Exception {
		BasicAWSCredentials creds = new BasicAWSCredentials("AKIAVSJSPPJPABQSEDFW",
				"+snXV+LTbl9EEaRmWSBVmeQzCXevf6OHbmMo+QCu");
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds))
				.withRegion(Regions.AP_SOUTH_1).build();
		File leftEyeImage = convertMultipartFileToFile(leftFile);
		File rightEyeImage = convertMultipartFileToFile(rightFile);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String todayDate = formatter.format(new Date());
		if (leftFile != null && leftEyeImage != null) {
			s3Client.deleteObject("decode-patients-images", patient.getPatientId() + "/"
					+ patient.getEpisodes().stream().findFirst().get().getEpisodeId() + "/");
			PutObjectRequest leftPutObjectRequest = new PutObjectRequest("decode-patients-images",
					patient.getPatientId() + "/" + patient.getEpisodes().stream().findFirst().get().getEpisodeId() + "/"
							+ "Left_Eye/" + leftEyeImage.getName(),
					leftEyeImage);
			s3Client.putObject(leftPutObjectRequest);
		}
		if (rightFile != null && rightEyeImage != null) {
			s3Client.deleteObject("decode-patients-images", patient.getPatientId() + "/"
					+ patient.getEpisodes().stream().findFirst().get().getEpisodeId() + "/");
			PutObjectRequest rightPutObjectRequest = new PutObjectRequest("decode-patients-images",
					patient.getPatientId() + "/" + patient.getEpisodes().stream().findFirst().get().getEpisodeId() + "/"
							+ "Right_Eye/" + rightEyeImage.getName(),
					rightEyeImage);
			s3Client.putObject(rightPutObjectRequest);
		}

	}

	private File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convertedFile = null;
		if (file != null) {
			convertedFile = new File(file.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(convertedFile);
			fos.write(file.getBytes());
			fos.close();

		}
		return convertedFile;
	}

	private void setPatientProperties(Patient patient, String user, String leftName, String rightName) {
		if (patient.getPatientAddress() != null) {
			patient.getPatientAddress().setPatient(patient);
		}
		setDates(patient, user);
		if (patient.getEpisodes() != null) {
			patient.getEpisodes().parallelStream().forEach(ep -> {
				ep.setPatient(patient);
				ep.setStatus("Active");
				if (leftName != null) {
					ep.setLeftFileName(leftName);
				}
				if (rightName != null) {
					ep.setRightFileName(rightName);
				}
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

	public void setDates(Patient patient, String user) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged user " + name);
		if (patient.getPatientId() == null) {
			patient.setCreatedDate(new Date());
			patient.setCreateduser(user);
		} else {
			patient.setLastUpdateDate(new Date());
			patient.setLastUpdatedUser(user);
		}
		if (patient.getEpisodes() != null) {
			patient.getEpisodes().parallelStream().forEach(ep -> {
				if (ep.getEpisodeId() == null) {
					ep.setCreatedDate(new Date());
					ep.setCreatedUser(user);
				} else {
					ep.setLastUpdateDate(new Date());
					ep.setLastUpdatedUser(user);
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
			if (ep.getFeetHealth().getLeftFeetSelected() != null) {

				String trim = ep.getFeetHealth().getLeftFeetSelected().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setLeftFeetSelected(result);
			}
			if (ep.getFeetHealth().getRightFeetSelected() != null) {

				String trim = ep.getFeetHealth().getRightFeetSelected().replaceAll("\\[", "").replaceAll("\\]", "")
						.trim();
				String result = trim.replaceAll("(\\s*,\\s*)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", ",");
				ep.getFeetHealth().setRightFeetSelected(result);
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

	@Scheduled(cron = "0 0 0 * * ?")
	public void run() {
		emrDao.inactiveEpisodes();
	}
}
