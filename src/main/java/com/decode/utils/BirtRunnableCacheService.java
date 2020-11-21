package com.decode.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirtRunnableCacheService {
	private Map<String, IReportRunnable> runnableCache = null;
	private static final Logger logger = LoggerFactory.getLogger(BirtRunnableCacheService.class);
	@Autowired
	private IReportEngine birtEngineFactory;

	@PostConstruct
	public void init() {
		loadRunnableCaches();
	}

	public void loadRunnableCaches(String reportName) {

		IReportRunnable runnable = null;
		runnableCache = new HashMap<String, IReportRunnable>();
		try {
			runnable = birtEngineFactory.openReportDesign("D:/dream_project/Decode-EMR/decode_status_report.rptdesign");
			runnableCache.put("decode_report", runnable);
			logger.info("cache loading completed...." + runnableCache.size());
		} catch (EngineException e) {
			e.printStackTrace();
		}
	}

	public void loadRunnableCaches() {

		IReportRunnable runnable = null;
		runnableCache = new HashMap<String, IReportRunnable>();
		try {
			runnable = birtEngineFactory.openReportDesign("D:/dream_project/Decode-EMR/decode_status_report.rptdesign");
			runnableCache.put("decode_report", runnable);
			logger.info("cache loading completed...." + runnableCache.size());
		} catch (EngineException e) {
			e.printStackTrace();
		}
	}

	public Map<String, IReportRunnable> getRunnableCache() {
		return runnableCache;
	}

	public void setRunnableCache(Map<String, IReportRunnable> runnableCache) {
		this.runnableCache = runnableCache;
	}

	public IReportEngine getBirtEngineFactory() {
		return birtEngineFactory;
	}

	public void setBirtEngineFactory(IReportEngine birtEngineFactory) {
		this.birtEngineFactory = birtEngineFactory;
	}

}
