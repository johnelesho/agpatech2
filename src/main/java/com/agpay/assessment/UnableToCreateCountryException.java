package com.agpay.assessment.exceptions;

public class UnableToCreateCountryException extends RuntimeException {

	public UnableToCreateCountryException(String message) {
            super(message);
        }

	public UnableToCreateCountryException() {
            super("Error saving the country details");
        }

    }
