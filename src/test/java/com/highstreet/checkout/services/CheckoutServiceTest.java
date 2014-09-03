package com.highstreet.checkout.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.highstreet.checkout.model.Item;


public class CheckoutServiceTest {

	//@Mock
	//public EligibilityService eligibilityService;

	//@Mock

//	@InjectMocks
	//public RewardServiceImpl rewardService = new RewardServiceImpl();

	@Before
	public void initilizeBeforeClass() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCheckOut_promotionRule_itemDiscount() {
	
		Item item1 = new Item();
		item1.setCode(001);
		item1.setName("Travel Card Holder");
		item1.setPrice(9.25);
		
		Item item2 = new Item();
		item2.setCode(002);
		item2.setName("Personalized cufflinks");
		item2.setPrice(45.00);

		Item item3 = new Item();
		item3.setCode(003);
		item3.setName("Kids T-shirt");
		item3.setPrice(19.95);
		
		
		
	}

//		List<RewardType> rewardsList = new ArrayList<RewardType>();
//		rewardsList.add(RewardType.CHAMPIONS_LEAGUE_FINAL_TICKET);
//
//		when(eligibilityService.getAccountElgibiltyByAccountId(anyInt()))
//				.thenReturn(EligibleType.CUSTOMER_ELIGIBLE);
//		when(rewardDAO.getReward(any(ChannelType.class))).thenReturn(
//				rewardsList);
//
//		Portfolio portfolio = new Portfolio();
//		portfolio.setChannelType(ChannelType.SPORTS);
//		Reward reward = rewardService.getRewards(1, portfolio);
//		Assert.assertNotNull(reward);
//		Assert.assertEquals(reward.getRewardTypes().get(0),
//				RewardType.CHAMPIONS_LEAGUE_FINAL_TICKET);

	

	@Test
	public void testRewardService_ineligible_success() {

//		when(eligibilityService.getAccountElgibiltyByAccountId(anyInt()))
//				.thenReturn(EligibleType.CUSTOMER_INELIGIBLE);
//
//		Portfolio portfolio = new Portfolio();
//		portfolio.setChannelType(ChannelType.KIDS);
//		Reward reward = rewardService.getRewards(1, portfolio);
//		Assert.assertNotNull(reward);
//		Assert.assertNull(reward.getRewardTypes());

	}



}
