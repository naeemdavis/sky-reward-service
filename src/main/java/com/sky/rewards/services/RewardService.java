package com.sky.rewards.services;

import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;


public interface RewardService {

    Reward getRewards(Integer accountId,Portfolio portfolio);

}
