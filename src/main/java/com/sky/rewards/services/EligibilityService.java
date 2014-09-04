package com.sky.rewards.services;

import com.sky.rewards.type.EligibleType;

public interface EligibilityService {

   EligibleType getAccountElgibiltyByAccountId(Integer accountId);

}
