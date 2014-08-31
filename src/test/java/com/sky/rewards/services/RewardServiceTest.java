package com.sky.rewards.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.any;

import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.testng.annotations.BeforeMethod;

import com.sky.rewards.dao.RewardDAO;
import com.sky.rewards.exception.SkyServiceException;
import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;
import com.sky.rewards.services.impl.MockEligibilityServiceImpl;
import com.sky.rewards.services.impl.RewardServiceImpl;
import com.sky.rewards.type.ChannelType;
import com.sky.rewards.type.EligibleType;
import com.sky.rewards.type.ResultCodeType;
import com.sky.rewards.type.RewardType;

public class RewardServiceTest {
	

	
	@Mock
	public EligibilityService eligibilityService;
	
	@Mock
	protected RewardDAO rewardDAO;
	
	@InjectMocks
	public RewardServiceImpl rewardService = new RewardServiceImpl();
	
	@Before
	public void initilizeBeforeClass(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRewardService_eligible_success() {

		List<RewardType> rewardsList = new ArrayList<RewardType>();
		rewardsList.add(RewardType.CHAMPIONS_LEAGUE_FINAL_TICKET);
		
			when(eligibilityService.getAccountElgibiltyByAccountId(anyInt())).thenReturn(EligibleType.CUSTOMER_ELIGIBLE);
			when(rewardDAO.getReward(any(ChannelType.class))).thenReturn(rewardsList);

			Portfolio portfolio = new Portfolio();
			portfolio.setChannelType(ChannelType.SPORTS);
			Reward reward = rewardService.getRewards(1, portfolio);
			Assert.assertNotNull(reward);
			Assert.assertEquals(reward.getRewardTypes().get(0),
					RewardType.CHAMPIONS_LEAGUE_FINAL_TICKET);
			
	} 
	
	@Test
	public void testRewardService_ineligible_success() {

			when(eligibilityService.getAccountElgibiltyByAccountId(anyInt())).thenReturn(EligibleType.CUSTOMER_INELIGIBLE);

			Portfolio portfolio = new Portfolio();
			portfolio.setChannelType(ChannelType.KIDS);
			Reward reward = rewardService.getRewards(1, portfolio);
			Assert.assertNotNull(reward);
			Assert.assertNull(reward.getRewardTypes());
			
	} 
	

	@Test
	public void testRewardService_accountIdIsNull_fail() {
		try {
			rewardService.getRewards(null, new Portfolio());
			Assert.fail();
		} catch (SkyServiceException ex) {
			Assert.assertEquals(ex.getMessage(),
					"The supplied account number is invalid");
			Assert.assertEquals(ex.getResultCode().getResultCode(),
					Integer.valueOf(1));
		}
	}
	
	
	@Test
	public void testRewardService_portfolioIsNull_fail() {
		try {
			rewardService.getRewards(1, null);
			Assert.fail();
		} catch (SkyServiceException ex) {
			Assert.assertEquals(ex.getMessage(),
					"Portfolio not found");
			Assert.assertEquals(ex.getResultCode().getResultCode(),
					Integer.valueOf(2));
		}
	}
	
	@Test
	public void testRewardService_eligibilityIsNull_fail() {
		try {
			EligibilityService mock = Mockito.mock(EligibilityService.class);
			when(mock.getAccountElgibiltyByAccountId(anyInt())).thenReturn(null);
			Portfolio portfolio = new Portfolio();
			portfolio.setChannelType(ChannelType.KIDS);
			rewardService.getRewards(1, portfolio);
			Assert.fail();
		} catch (SkyServiceException ex) {
			Assert.assertEquals(ex.getMessage(),
					"Eligible type not found");
			Assert.assertEquals(ex.getResultCode().getResultCode(),
					Integer.valueOf(4));
		}
	}
	
	@Test
	public void testRewardService_accountNotValid() {
		try {
			when(eligibilityService.getAccountElgibiltyByAccountId(anyInt())).thenThrow(new SkyServiceException(ResultCodeType.INVALID_ACCOUNT));
			Portfolio portfolio = new Portfolio();
			portfolio.setChannelType(ChannelType.KIDS);
			rewardService.getRewards(1, portfolio);
			Assert.fail();
		} catch (SkyServiceException ex) {
			Assert.assertEquals(ex.getMessage(),
					"The supplied account number is invalid");
			Assert.assertEquals(ex.getResultCode().getResultCode(),
					Integer.valueOf(1));
		}
	}
	
	
	//A bit different flavour of error
	@Test(expected=SkyServiceException.class)
	public void testRewardService_internalError_fail() {
	
			when(eligibilityService.getAccountElgibiltyByAccountId(anyInt())).thenThrow(new SkyServiceException(ResultCodeType.INTERNAL_ERROR));
			Portfolio portfolio = new Portfolio();
			portfolio.setChannelType(ChannelType.KIDS);
			rewardService.getRewards(1, portfolio);
			Assert.fail();
	
	}
	
	
	
	

}
