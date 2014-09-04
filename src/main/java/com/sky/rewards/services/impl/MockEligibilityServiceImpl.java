package com.sky.rewards.services.impl;

import org.springframework.stereotype.Service;

import com.sky.rewards.exception.SkyServiceException;
import com.sky.rewards.services.EligibilityService;
import com.sky.rewards.type.EligibleType;
import com.sky.rewards.type.ResultCodeType;

@Service
public class MockEligibilityServiceImpl implements EligibilityService {

    public EligibleType getAccountElgibiltyByAccountId(Integer accountId) {

        if(accountId==1){
            return EligibleType.CUSTOMER_ELIGIBLE;
        }else if(accountId==2){
            return EligibleType.CUSTOMER_INELIGIBLE;
        }else if(accountId==3){
            throw new SkyServiceException(ResultCodeType.INVALID_ACCOUNT);
        }else{
            throw new SkyServiceException(ResultCodeType.INTERNAL_ERROR);
        }
    }

}
