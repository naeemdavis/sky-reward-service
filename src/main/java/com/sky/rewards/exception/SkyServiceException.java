package com.sky.rewards.exception;

import com.sky.rewards.type.ResultCodeType;


public class SkyServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
	private ResultCodeType resultCode;

	/**
     * Creates a new SkyServiceException with a given result code and message.
     *
     * @param resultCode
     * @param message
     */
    public SkyServiceException(ResultCodeType resultCode) {
        super(resultCode.getDescription());
        this.resultCode = resultCode;
    }
    
    public ResultCodeType getResultCode() {
		return resultCode;
	}
}
