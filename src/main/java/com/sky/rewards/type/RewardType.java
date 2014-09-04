package com.sky.rewards.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum RewardType {

    CHAMPIONS_LEAGUE_FINAL_TICKET(1, "CHAMPIONS_LEAGUE_FINAL_TICKET"),
    KARAOKE_PRO_MICROPHONE(2, "KARAOKE_PRO_MICROPHONE"),
    PIRATES_OF_THE_CARIBBEAN_COLLECTION(3, "PIRATES_OF_THE_CARIBBEAN_COLLECTION");


    private Integer code;

    private String description;


    private static final Map<Integer, RewardType> lookupByResultCode = new HashMap<Integer, RewardType>();
    static {
        for (RewardType s : EnumSet.allOf(RewardType.class)) {
            lookupByResultCode.put(s.getCode(), s);
        }
    }


    private RewardType(Integer code, String description){
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
