package com.abisoft.abisoft.dto;

import org.springframework.http.HttpStatus;

public class ResponseWs {

	private HttpStatus code;
	private String mensaje;

	/**
	 * @return the code
	 */
	public HttpStatus getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
