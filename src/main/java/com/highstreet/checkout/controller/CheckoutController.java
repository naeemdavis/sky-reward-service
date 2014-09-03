package com.highstreet.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.highstreet.checkout.services.CheckoutService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {


	@Autowired
    private CheckoutService checkoutService;

    /**
     * get rewards
     */
    @RequestMapping( value = {"/account/{accountId}"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Double getTotalPrice(@PathVariable Integer accountId) {
      
        return null;
    }

}
