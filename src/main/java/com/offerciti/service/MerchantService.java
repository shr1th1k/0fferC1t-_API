package com.offerciti.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.offerciti.model.Merchant;
import com.offerciti.repository.MerchantRepository;

@Component
public class MerchantService {
  @Autowired
  private MerchantRepository merchantRepository;

  public com.offerciti.model.Merchant createMerchant(Merchant merchant) {
    merchant.setCreatedDate(Calendar.getInstance());
    merchant.setLastLogin(Calendar.getInstance());
    return merchantRepository.save(merchant);
  }

  public Merchant getMerchant(int id) {
    return merchantRepository.findOne(id);
  }

  public void deleteMerchant(int id) {
    merchantRepository.delete(id);
  }

  public List<Merchant> getAllMerchants() {
    return (List<Merchant>)merchantRepository.findAll();
  }
  
  

}
