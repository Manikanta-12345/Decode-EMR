package com.decode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.decode.model.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, String>{
	@Query("select ep.episodeId from Episode  ep where ep.patient.patientId = :patientId and status='Active'")
	public List<String> getEpisodesList(String patientId);
}
