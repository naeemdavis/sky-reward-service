package com.sky.rewards.dao;

import java.util.List;

import com.sky.rewards.type.ChannelType;
import com.sky.rewards.type.RewardType;

public interface RewardDAO {

    public List<RewardType> getReward(ChannelType channelType);

}
