package com.decode.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.decode.model.Episode;
import com.decode.model.GlobalSequenceCounters;
import com.decode.model.Patient;
import com.decode.utils.IdGeneratorsUtils;

@Repository
public class EmrDao {

	@PersistenceContext
	private EntityManager sessionFactory;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public GlobalSequenceCounters getPatientSequenceCounter(int id) {
		Session ses = sessionFactory.unwrap(Session.class);
		GlobalSequenceCounters counter = (GlobalSequenceCounters) ses.createCriteria(GlobalSequenceCounters.class)
				.add(Restrictions.eq("organizationId", id))
				.add(Restrictions.eq("pattern", IdGeneratorsUtils.PATIEN_ID_PREFIX))
				.setLockMode(LockMode.PESSIMISTIC_WRITE).uniqueResult();

		return counter;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public GlobalSequenceCounters getEpisodeSequenceCounter(int id, int locId) {
		Session ses = sessionFactory.unwrap(Session.class);
		GlobalSequenceCounters counter = (GlobalSequenceCounters) ses.createCriteria(GlobalSequenceCounters.class)
				.add(Restrictions.eq("organizationId", id)).add(Restrictions.eq("locationId", locId))
				.add(Restrictions.eq("pattern", IdGeneratorsUtils.EPISODE_ID_PREFIX))
				.setLockMode(LockMode.PESSIMISTIC_WRITE).uniqueResult();

		return counter;
	}

	@Transactional
	public Patient getPatient(String patientId) {
		Session ses = sessionFactory.unwrap(Session.class);
		Patient patient = null;
		patient = ses.get(Patient.class, patientId);
		if (patient != null) {
			Hibernate.initialize(patient.getPatientAddress());
		}
		return patient;
	}

	public Episode getEpisode(String episodeId) {

		Session ses = sessionFactory.unwrap(Session.class);
		Episode episode = null;
		episode = ses.get(Episode.class, episodeId);
		if (episode != null) {
			Hibernate.initialize(episode.getDiseaseHistory());
			Hibernate.initialize(episode.getDiseaseSeverity());
			Hibernate.initialize(episode.getFamilyHistory());
			Hibernate.initialize(episode.getFeetHealth());
			Hibernate.initialize(episode.getKidneyHealth());
			Hibernate.initialize(episode.getHeartHealth());
			Hibernate.initialize(episode.getEyeHealth());
			Hibernate.initialize(episode.getNextAppointments());
		}
		return episode;
	}
}
