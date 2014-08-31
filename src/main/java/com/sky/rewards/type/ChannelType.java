package com.sky.rewards.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ChannelType {

    SPORTS(1, "SPORTS"),
    KIDS(2, "KIDS"),
    MUSIC(3, "MUSIC"),
    NEWS(4, "NEWS"),
    MOVIES(5, "MOVIES");


    private Integer code;

    private String description;


    private static final Map<Integer, ChannelType> lookupByResultCode = new HashMap<Integer, ChannelType>();
    static {
        for (ChannelType s : EnumSet.allOf(ChannelType.class)) {
            lookupByResultCode.put(s.getCode(), s);
        }
    }


    private ChannelType(Integer code, String description){
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
