package com.offerciti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.offerciti.model.Offer;
import com.offerciti.model.User;
import com.offerciti.repository.OfferRepository;

@Component
public class OfferService {
  @Autowired
  private OfferRepository offerRepository;

  public Offer createOffer(Offer offer) {
     return offerRepository.save(offer);
  }

  public Offer getOffer(int id) {
    return offerRepository.findOne(id);
  }

  public void deleteOffer(int id) {
     offerRepository.delete(id);
  }

  public List<Offer> getAllOffers() {
    return (List<Offer>)offerRepository.findAll();
  }
  
  
  
}
