package com.decode.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
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

	@Transactional
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

	@Transactional
	public void updatePatient(Patient patient) {
		Session ses = sessionFactory.unwrap(Session.class);
		Query query = ses.createQuery(
				"update Patient set firstName = :firstName , lastName = :lastName , dateOfBirth = :dateOfBirth,lastUpdatedUser= :lastUpdatedUser,lastUpdateDate = :lastUpdatedDate , gender = :gender , mobile = :mobile , email = :email ,  title = :title ,countryId = :countryId,stateId = :stateId,districtId = :districtId,years = :years,months = :months,days = :days ,nextKin = :nextKin,contact = :contact where patientId = :patientId");
		query.setParameter("firstName", patient.getFirstName());
		query.setParameter("lastName", patient.getLastName());
		query.setParameter("dateOfBirth", patient.getDateOfBirth());
		query.setParameter("gender", patient.getGender());
		query.setParameter("mobile", patient.getMobile());
		query.setParameter("email", patient.getEmail());
		query.setParameter("title", patient.getTitle());
		query.setParameter("countryId", patient.getCountryId());
		query.setParameter("stateId", patient.getStateId());
		query.setParameter("districtId", patient.getDistrictId());
		query.setParameter("years", patient.getYears());
		query.setParameter("months", patient.getMonths());
		query.setParameter("days", patient.getDays());
		query.setParameter("patientId", patient.getPatientId());
		
		query.setParameter("nextKin", patient.getNextKin());
		query.setParameter("contact", patient.getContact());
		query.setParameter("lastUpdatedUser", patient.getLastUpdatedUser());
		query.setParameter("lastUpdatedDate", patient.getLastUpdateDate());
		Query query1 = ses
				.createQuery("update Address as a set a.address = :address,a.location= :location where a.patient.patientId = :patientId");
		query1.setParameter("address", patient.getPatientAddress().getAddress());
		query1.setParameter("location", patient.getPatientAddress().getLocation());
		query1.setParameter("patientId", patient.getPatientId());
		int result = query.executeUpdate();
		int result1 = query1.executeUpdate();
	}
	@Transactional
	public void inactiveEpisodes() {
		Session ses = sessionFactory.unwrap(Session.class);
		Query query = ses.createQuery(
				"update Episode set status = :status");
		query.setParameter("status", "InActive");
		int result1 = query.executeUpdate();
	}
}
