package com.decode.service;

import java.util.Map;

public interface DecodeBirtService {

	public byte[] generateReport(Map<Object,Object> reportParams,String reportFormat);
}
