package com.decode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.decode.masters.dto.DistrictDto;
import com.decode.masters.models.District;

public interface DistrictRepository extends JpaRepository<District, Integer> {
	@Query("SELECT new  com.decode.masters.dto.DistrictDto(d.id,d.name,d.country.id,d.state.id) FROM District d WHERE d.state.id=:stateId OR d.id=:districtId")
	List<DistrictDto> findDistricts(@Param("districtId") Integer districtId, @Param("stateId") Integer stateId);

}
