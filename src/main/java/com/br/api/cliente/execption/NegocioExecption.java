package com.br.api.cliente.execption;

public class NegocioExecption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2155864181745018635L;

	public NegocioExecption() {
		super();
	}

	public NegocioExecption(String message) {
		super(message);
	}

	public NegocioExecption(Throwable cause) {
		super(cause);
	}

	public NegocioExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public NegocioExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
