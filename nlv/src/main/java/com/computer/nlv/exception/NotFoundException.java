package com.computer.nlv.exception;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8946314074351104219L;

	public NotFoundException(Integer id) {

		super(String.format("City with Id %d not found", id));
	}
}
