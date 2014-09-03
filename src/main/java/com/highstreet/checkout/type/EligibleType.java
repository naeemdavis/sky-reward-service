
package com.highstreet.checkout.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EligibleType {

    CUSTOMER_ELIGIBLE(1, "Customer Elgible"),
    CUSTOMER_INELIGIBLE(2, "Customer not elgible"),;

    private Integer code;

    private String description;


    private static final Map<Integer, EligibleType> lookupByResultCode = new HashMap<Integer, EligibleType>();
    static {
        for (EligibleType s : EnumSet.allOf(EligibleType.class)) {
            lookupByResultCode.put(s.getCode(), s);
        }
    }


    private EligibleType(Integer code, String description){
     this.code = code;
     this.description = description;
    }


    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }


}
