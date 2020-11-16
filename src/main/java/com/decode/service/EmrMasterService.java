package com.decode.service;

import java.util.List;

import com.decode.masters.dto.CombrobiditiesMastersDTO;
import com.decode.masters.dto.DiabetecTypesDTO;
import com.decode.masters.dto.DiabetesMastersDTO;
import com.decode.masters.dto.DiseaseInterventionMastersDTO;
import com.decode.masters.dto.FeetObservationMastersDTO;
import com.decode.masters.dto.HabitualPatternMastersDTO;
import com.decode.masters.dto.LifeStyleMedicationMastersDTO;
import com.decode.masters.dto.MedicationMastersDTO;
import com.decode.masters.dto.SuggestedDilatedEyeExaminationDTO;
import com.decode.masters.dto.SuggestedEyeInterventionDTO;
import com.decode.masters.dto.SuggestedHeartInterventionDTO;
import com.decode.masters.dto.SuggestedKidneyInterventionDTO;

public interface EmrMasterService {

	public List<DiabetesMastersDTO> getDiabetesMasters();

	public List<DiabetecTypesDTO> getDiabetesTypes();

	public List<LifeStyleMedicationMastersDTO> getLifeStyleMedication();

	public List<MedicationMastersDTO> getMedicationMasters();

	public List<CombrobiditiesMastersDTO> getCombrobiditiesMasters();

	public List<FeetObservationMastersDTO> getFeetObservationMasters();

	public List<HabitualPatternMastersDTO> getHabitualPatternMasters();

	public List<DiseaseInterventionMastersDTO> getDiseaseInterventionMasters();

	public List<SuggestedDilatedEyeExaminationDTO> getSuggestedDilatedEyeExamination();

	public List<SuggestedEyeInterventionDTO> getSuggestedEyeIntervention();

	public List<SuggestedHeartInterventionDTO> getSuggestedHeartIntervention();

	public List<SuggestedKidneyInterventionDTO> getSuggestedKidneyIntervention();
}
