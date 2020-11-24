package com.decode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decode.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
