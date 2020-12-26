package com.decode.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.decode.masters.dto.ReportDTO;
import com.decode.model.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, String>{
	@Query("select ep.episodeId from Episode  ep where ep.patient.patientId = :patientId and status='Active'")
	public List<String> getEpisodesList(String patientId);
	
	@Query("SELECT  new com.decode.masters.dto.ReportDTO(p.patientId,p.firstName,e.episodeId,e.createdDate,p.years,p.gender,p.mobile,e.status) FROM Patient p join Episode e on p.patientId=e.patient.patientId WHERE (e.createdDate >= :createdOn AND e.createdDate <=:createdOn1) order by e.createdDate desc")
	public List<ReportDTO> getRepors(@Param("createdOn") Date createdOn,@Param("createdOn1") Date createdOn1);
	
	@Query("SELECT  new com.decode.masters.dto.ReportDTO(p.patientId,p.firstName,e.episodeId,e.createdDate,p.years,p.gender,p.mobile,e.status) FROM Patient p join Episode e on p.patientId=e.patient.patientId WHERE (e.patient.patientId=:patientId AND e.createdDate >= :createdOn AND e.createdDate <=:createdOn1) order by e.createdDate desc")
	public List<ReportDTO> getReporsOfPatient(@Param("createdOn") Date createdOn,@Param("createdOn1") Date createdOn1,@Param("patientId") String patientId);
}
