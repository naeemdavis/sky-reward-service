package com.sky.rewards.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sky.rewards.dao.RewardDAO;
import com.sky.rewards.type.ChannelType;
import com.sky.rewards.type.RewardType;

@Service
public class RewardDAOImpl implements RewardDAO {

    @SuppressWarnings("static-access")
	public List<RewardType> getReward(ChannelType channelType) {
        // Stub data, can be replace by Database

        List<RewardType> list = new ArrayList<RewardType>();

        if (channelType.getCode().equals(channelType.SPORTS.getCode())) {
             list.add(RewardType.CHAMPIONS_LEAGUE_FINAL_TICKET);
        } else if (channelType.getCode().equals(channelType.MOVIES.getCode())) {
            list.add(RewardType.PIRATES_OF_THE_CARIBBEAN_COLLECTION);
        } else if (channelType.getCode().equals(channelType.MUSIC.getCode())) {
            list.add(RewardType.KARAOKE_PRO_MICROPHONE);
        }

        return list;

    }

}
