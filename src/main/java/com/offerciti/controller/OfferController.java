package com.offerciti.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offerciti.model.Offer;
import com.offerciti.service.OfferService;



@RestController
public class OfferController {
  @Autowired
  private OfferService offerService;
  @RequestMapping(value="offerciti/offer/create",method=RequestMethod.POST)
  public @ResponseBody Offer createUser(@RequestBody Offer offer) {
      offer.setCreatedDate(Calendar.getInstance());
      return  offerService.createOffer(offer);
  }
  
  @RequestMapping(value="offerciti/offer/{id}",method=RequestMethod.GET)
  public @ResponseBody Offer getUser(@PathVariable int id) {
      return offerService.getOffer(id);
  }
  
  @RequestMapping(value="offerciti/offer/delete/{id}",method=RequestMethod.GET)
  public void deleteUser(@PathVariable int id) {
       offerService.deleteOffer(id);
  }
  
  @RequestMapping(value="offerciti/offers",method=RequestMethod.GET)
  public @ResponseBody List<Offer> getAllOffers() {
      return offerService.getAllOffers();
  }
}   
