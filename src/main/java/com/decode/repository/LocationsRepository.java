package com.decode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decode.model.Locations;

public interface LocationsRepository  extends JpaRepository<Locations, Integer>{

}
