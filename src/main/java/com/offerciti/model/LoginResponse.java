package com.offerciti.model;

public class LoginResponse extends OffercitiSerializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String token;
  
  public LoginResponse(String token){
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
  

}
