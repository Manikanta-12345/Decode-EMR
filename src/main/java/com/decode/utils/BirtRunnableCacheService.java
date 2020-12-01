package com.decode.utils;

import java.io.InputStream;
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

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

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
			InputStream rptFromAmazonS3 = getRptFromAmazonS3();
			runnable = birtEngineFactory.openReportDesign(rptFromAmazonS3);
			runnableCache.put("decode_report", runnable);
			logger.info("cache loading completed...." + runnableCache.size());
		} catch (EngineException e) {
			e.printStackTrace();
		}
	}

	public InputStream getRptFromAmazonS3() {
		Regions clientRegion = Regions.DEFAULT_REGION;
		String bucketName = "decode-rpts";
		String key = "decode_status_report.rptdesign";

		S3Object fullObject = null, objectPortion = null, headerOverrideObject = null;
		try {
			
			BasicAWSCredentials creds = new BasicAWSCredentials("AKIAVSJSPPJPABQSEDFW", "+snXV+LTbl9EEaRmWSBVmeQzCXevf6OHbmMo+QCu");
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
			        .withCredentials(new AWSStaticCredentialsProvider(creds))
			        .withRegion(Regions.AP_SOUTH_1).build();
			// Get an object and print its contents.
			System.out.println("Downloading an object");
			fullObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
			System.out.println("Content-Type: " + fullObject.getObjectMetadata().getContentType());
		} catch (AmazonServiceException e) {
			// The call was transmitted successfully, but Amazon S3 couldn't process
			// it, so it returned an error response.
			e.printStackTrace();
		} catch (SdkClientException e) {
			// Amazon S3 couldn't be contacted for a response, or the client
			// couldn't parse the response from Amazon S3.
			e.printStackTrace();
		}
		return fullObject.getObjectContent();
	}

	public void loadRunnableCaches() {

		IReportRunnable runnable = null;
		runnableCache = new HashMap<String, IReportRunnable>();
		try {
			InputStream rptFromAmazonS3 = getRptFromAmazonS3();
			runnable = birtEngineFactory.openReportDesign(rptFromAmazonS3);
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
