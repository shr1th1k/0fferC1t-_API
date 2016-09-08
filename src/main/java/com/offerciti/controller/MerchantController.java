package com.offerciti.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offerciti.model.Merchant;
import com.offerciti.service.MerchantService;

@Controller
public class MerchantController {
  
  @Autowired
  private MerchantService merchantService;
  
  @RequestMapping(value="offerciti/merchant/create",method=RequestMethod.POST)
  public @ResponseBody Merchant createUser(@RequestBody Merchant Merchant) {
      Merchant.setCreatedDate(Calendar.getInstance());
      return  merchantService.createMerchant(Merchant);
  }
  
  @RequestMapping(value="offerciti/merchant/{id}",method=RequestMethod.GET)
  public @ResponseBody Merchant getUser(@PathVariable int id) {
      return merchantService.getMerchant(id);
  }
  
  @RequestMapping(value="offerciti/merchant/delete/{id}",method=RequestMethod.GET)
  public void deleteUser(@PathVariable int id) {
       merchantService.deleteMerchant(id);
  }
  
  @RequestMapping(value="offerciti/merchants",method=RequestMethod.GET)
  public @ResponseBody List<Merchant> getAllMerchants() {
      return merchantService.getAllMerchants();
  }

}
