package com.decode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.decode.masters.dto.CountryDto;
import com.decode.masters.models.Country;

public interface CountriesRepository extends JpaRepository<Country, Integer> {
	@Query("SELECT new com.decode.masters.dto.CountryDto(c.id,c.name) FROM Country c")
    List<CountryDto> findCountries();

}
