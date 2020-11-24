package com.decode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.decode.masters.dto.StateDto;
import com.decode.masters.models.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	@Query("SELECT new com.decode.masters.dto.StateDto(s.id,s.name,s.country.id) FROM State s WHERE s.country.id=:countryId OR s.id=:stateId")
	List<StateDto> findStates(@Param("stateId") Integer stateId, @Param("countryId") Integer countryId);
}
