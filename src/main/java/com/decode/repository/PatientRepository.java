package com.decode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.decode.masters.dto.PatientSearchDto;
import com.decode.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {
    @Query("select new com.decode.masters.dto.PatientSearchDto(pt.patientId,pt.firstName,pt.mobile) from Patient  pt where pt.firstName like %:query% or pt.mobile like %:query%")
	public List<PatientSearchDto> getPatientsList(String query);
		

}
