package com.sky.rewards.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.rewards.dao.RewardDAO;
import com.sky.rewards.exception.SkyServiceException;
import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;
import com.sky.rewards.services.EligibilityService;
import com.sky.rewards.services.RewardService;
import com.sky.rewards.type.EligibleType;
import com.sky.rewards.type.ResultCodeType;
import com.sky.rewards.type.RewardType;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private EligibilityService eligibilityService;


    @Autowired
    protected RewardDAO rewardDAO;



    public Reward getRewards(Integer accountId, Portfolio portfolio) {

        validateInput(accountId, portfolio);

        Reward reward = new Reward();

        EligibleType eligibleType = null;
        
        	eligibleType = eligibilityService.getAccountElgibiltyByAccountId(accountId);
        

        if(eligibleType!=null){

            if(eligibleType.getCode().equals(EligibleType.CUSTOMER_ELIGIBLE.getCode())){
                List<RewardType> rewardTypes = rewardDAO.getReward(portfolio.getChannelType());
                reward.setRewardTypes(rewardTypes);
                reward.setAccountId(accountId);
                return reward;
            }

            if(eligibleType.getCode().equals(EligibleType.CUSTOMER_INELIGIBLE.getCode())){
                reward.setAccountId(accountId);
                //No needs to set rewards if customer not eligible
                return reward;
            }
        }else{

            throw new SkyServiceException(ResultCodeType.ELIGIBLE_TYPE_NOT_FOUND);

        }

        return null;
    }


    private void validateInput(Integer accountId,  Portfolio portfolio) {
        if(accountId == null){
            throw new SkyServiceException(ResultCodeType.INVALID_ACCOUNT);
         }

        if(portfolio == null || portfolio.getChannelType() == null){
            throw new SkyServiceException(ResultCodeType.PORTFOLIO_NOT_FOUND);
         }
    }


}
