package com.decode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decode.model.GlobalSequenceCounters;

public interface GlobalSequenceRepository extends JpaRepository<GlobalSequenceCounters, Integer>{

}
