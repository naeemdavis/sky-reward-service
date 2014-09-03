package com.highstreet.checkout.exception;

import com.highstreet.checkout.type.ResultCodeType;


public class CheckoutServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	private ResultCodeType resultCode;

	/**
     * Creates a new SkyServiceException with a given result code and message.
     *
     * @param resultCode
     * @param message
     */
    public CheckoutServiceException(ResultCodeType resultCode) {
        super(resultCode.getDescription());
        this.resultCode = resultCode;
    }
    
    public ResultCodeType getResultCode() {
		return resultCode;
	}
}
