package com.decode.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decode.service.DecodeBirtService;
import com.decode.utils.BirtReportConstants;
import com.decode.utils.BirtRunnableCacheService;

@Service
public class DecodeBirtServiceImpl implements DecodeBirtService {

	@Autowired
	private BirtRunnableCacheService birtRunnableCacheService;
	
	
	@Autowired
	private IReportEngine birtEngine;

	@Override
	public void generateReport(Map<Object, Object> reportParams, String reportFormat) {
		IReportRunnable runnable = birtRunnableCacheService.getRunnableCache().get("decode_report");
		if (reportFormat.equalsIgnoreCase(BirtReportConstants.PDF_FORMAT)) {
			try {
				generatePdf(BirtReportConstants.PDF_FORMAT, runnable, reportParams);
			} catch (EngineException e) {
				e.printStackTrace();
			}
		}

	}

	public byte[] generatePdf(String pdfFormat, IReportRunnable runnable, Map<Object, Object> reportParams)
			throws EngineException {
		// execute report
		IRunAndRenderTask task = birtEngine.createRunAndRenderTask(runnable);
		ByteArrayOutputStream out = null;
		RenderOption renderOption = null;
		out = new ByteArrayOutputStream();
		renderOption = new PDFRenderOption();
		renderOption.setOutputFormat(pdfFormat);
		renderOption.setOutputStream(out);
		renderOption.setOutputFileName("D:/dream_project/Decode-EMR/decode.pdf");
		task.setRenderOption(renderOption);
		task.setParameterValues(reportParams);
		task.run();
		task.close();
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
