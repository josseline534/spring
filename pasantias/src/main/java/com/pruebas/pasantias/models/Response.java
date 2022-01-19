package com.pruebas.pasantias.models;

import java.util.List;


public class Response {

	private Integer code;
	private String message;
	private List<ResponseUsers> response;
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setResponse(List<ResponseUsers> response) {
		this.response = response;
	}

	public List<ResponseUsers> getResponse() {
		return response;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
