package com.sky.rewards.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ResultCodeType {

    INVALID_ACCOUNT(1, "The supplied account number is invalid"),
    PORTFOLIO_NOT_FOUND(2, "Portfolio not found"),
    INTERNAL_ERROR(3, "Service technical failure"),
    ELIGIBLE_TYPE_NOT_FOUND(4, "Eligible type not found");
    ;

    private static final Map<Integer, ResultCodeType> lookupByResultCode = new HashMap<Integer, ResultCodeType>();
    static {
        for (ResultCodeType s : EnumSet.allOf(ResultCodeType.class)) {
            lookupByResultCode.put(s.getResultCode(), s);
        }
    }


    private Integer resultCode;


    private String message;


    private ResultCodeType(Integer resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;

    }

    public Integer getResultCode() {
        return resultCode;
    }

    public String getDescription() {
        return message;
    }

    public static ResultCodeType getByResultCode(Integer id) {
        return lookupByResultCode.get(id);
    }

}
