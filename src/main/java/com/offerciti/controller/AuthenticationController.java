package com.offerciti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offerciti.model.LoginRequest;
import com.offerciti.model.LoginResponse;
import com.offerciti.security.OfferCitiUserDetailsService;
import com.offerciti.util.AuthenticationUtils;

@RestController
public class AuthenticationController {
  
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  private OfferCitiUserDetailsService offerCitiUserDetailsService;
  
  @Autowired
  private AuthenticationUtils authenticationUtils;
  
  @RequestMapping(value="offerciti/authentication/login",method=RequestMethod.POST)
  public @ResponseBody LoginResponse login(@RequestBody LoginRequest loginRequest){
    System.out.println("username "+loginRequest.getUserName());
    Authentication authentication = this.authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
          loginRequest.getUserName(),
          loginRequest.getPassword()
      )
    );
    
    SecurityContextHolder.getContext().setAuthentication(authentication);
    UserDetails userDetails = this.offerCitiUserDetailsService.loadUserByUsername(loginRequest.getUserName());
    String token = this.authenticationUtils.generateToken(userDetails);

    return new LoginResponse(token);
    
  }

}
