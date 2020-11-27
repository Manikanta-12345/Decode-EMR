package com.decode.masters.dto;

public class EmrResponse {
private String message;
private String statusCode;
private byte[] report;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getStatusCode() {
	return statusCode;
}
public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}
public byte[] getReport() {
	return report;
}
public void setReport(byte[] report) {
	this.report = report;
}

}
