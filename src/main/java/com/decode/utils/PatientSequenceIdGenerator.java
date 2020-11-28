package com.decode.utils;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;

import com.decode.model.GlobalSequenceCounters;
import com.decode.model.Patient;
import com.decode.service.EmrMasterService;

public class PatientSequenceIdGenerator implements IdentifierGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientSequenceIdGenerator.class);

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		String employeeId = null;
		try {
			employeeId = getEmployeeId(session, object);
		} catch (HibernateOptimisticLockingFailureException e) {
			// hey two thread trying to update emp counter retry
			LOGGER.info("hey optimistic raised");
			employeeId = getEmployeeId(session, object);

		}
		return employeeId;
	}

	public String getEmployeeId(SharedSessionContractImplementor session, Object object) {
		String employeeId = null;
		Patient patient = (Patient) object;// cast to emp object
		int presentYear = Calendar.getInstance().get(Calendar.YEAR);
		GlobalSequenceCounters employeeCounter = TechBeanUtil.getBean(EmrMasterService.class).getSequenceCounter(patient.getOrgId());
		// if employee counter configured in organization
		if (null != employeeCounter) {
			LOGGER.info("yes emp counter not null");
			// constructing year patterns based on digits like 2020 or 20
			String yearPattern = String.valueOf(presentYear)
					.substring(employeeCounter.getYearPattern().length() == 2 ? 2 : 0, 4);
			// check current year and year in db are same or not(2020=2020)
			if (presentYear == employeeCounter.getCurrentYear()) {
				int currentEmployeesCount = employeeCounter.getCurrentCount();
				// increment count and assign to new employee
				currentEmployeesCount = currentEmployeesCount + 1;
				employeeId = employeeCounter.getPattern() + yearPattern
						+ getPrefixValue(currentEmployeesCount, employeeCounter.getNoOfDigits());

				employeeCounter.setCurrentCount(currentEmployeesCount);
				TechBeanUtil.getBean(EmrMasterService.class).updateGlobalCounter(employeeCounter);
			} else {
				try {
					// plz update the year in the database
					int resetCount = 1;// reset count to 1 in new year
					employeeCounter.setCurrentCount(resetCount);
					employeeCounter.setCurrentYear(presentYear);
					TechBeanUtil.getBean(EmrMasterService.class).updateGlobalCounter(employeeCounter);
				} catch (HibernateOptimisticLockingFailureException e) {
					LOGGER.info("hey another thread also update curent year plz neglect");
					getEmployeeId(session, object);
				}

			}

		} else {
			// throw exception no counter in org
		}

		return employeeId;
	}

	/**
	 * @author manikanta m
	 * @param currentValue
	 * @param noOfDigits
	 * @return
	 */
	public String getPrefixValue(int currentValue, int noOfDigits) {
		String prefixValue = "";
		String curValue = String.valueOf(currentValue);
		int zerosLen = noOfDigits - curValue.length();
		for (int i = 0; i < zerosLen; i++) {
			prefixValue += "0";
		}
		// 000100
		return prefixValue + curValue;
	}
}
