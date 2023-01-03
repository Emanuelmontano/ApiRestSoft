package com.abisoft.abisoft.exception;

public class ExceptionResponse {
	
    private String mensaje;
    private String httpCodeMessage;
  
    public ExceptionResponse(String message, String httpCodeMessage) {
      super();
      this.mensaje = message;
      this.httpCodeMessage=httpCodeMessage;
    }
  
    public String getHttpCodeMessage() {
      return httpCodeMessage;
    }
  
    public String getMensaje() {
      return mensaje;
    }
  
  }
  
