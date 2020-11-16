package com.decode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decode.masters.models.MedicationMasters;

public interface MedicationMastersRepository extends JpaRepository<MedicationMasters, Integer>{

}
