package com.sky.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;
import com.sky.rewards.services.RewardService;

@Controller
@RequestMapping("/rewards")
public class RewardController {


	@Autowired
    private RewardService rewardService;

    /**
     * get rewards
     */
    @RequestMapping( value = {"/account/{accountId}"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Reward getReward(@PathVariable Integer accountId, Portfolio portfolio) {
        return rewardService.getRewards(accountId, portfolio);
    }

}
