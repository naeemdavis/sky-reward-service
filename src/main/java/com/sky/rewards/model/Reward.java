package com.sky.rewards.model;

import java.util.List;

import com.sky.rewards.type.RewardType;

public class Reward {



    private Integer accountId;
    private List<RewardType> rewardTypes;


    /**
     * @return the rewardTypes
     */
    public List<RewardType> getRewardTypes() {
        return rewardTypes;
    }
    /**
     * @param rewardTypes the rewardTypes to set
     */
    public void setRewardTypes(List<RewardType> rewardTypes) {
        this.rewardTypes = rewardTypes;
    }
	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}


  }
