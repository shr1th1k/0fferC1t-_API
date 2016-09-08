package com.offerciti.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="merchants")
public class Merchant implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(name="merchant_id")
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private  int merchantId;
  @Column(name="user_name")
  private String userName;
  private String password;
  private short status;
  @Column(name="business_name")
  private String businessName;
  @Column(name="business_logo")
  private String businessLogo;
  private String description;
  @Column(name="website_url")
  private String websiteUrl;
  @Column(name="facebook_url")
  private String facebookUrl;
  @Column(name="twitter_url")
  private String twitterUrl;
  @Column(name="google_plus_url")
  private String googlePlusUrl;
  @Column(name="pan_number")
  private String panNumber;
  @Column(name="address_proof")
  private String addressProof;
  @Column(name="wallet_balance")
  private int walletBalance;
  @Column(name="created_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar createdDate;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="last_updated")
  private Calendar lastUpdated;
  @Column(name="last_login")
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar lastLogin;
  public int getMerchantId() {
    return merchantId;
  }
  public void setMerchantId(int merchantId) {
    this.merchantId = merchantId;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public short getStatus() {
    return status;
  }
  public void setStatus(short status) {
    this.status = status;
  }
  public String getBusinessName() {
    return businessName;
  }
  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }
  public String getBusinessLogo() {
    return businessLogo;
  }
  public void setBusinessLogo(String businessLogo) {
    this.businessLogo = businessLogo;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getWebsiteUrl() {
    return websiteUrl;
  }
  public void setWebsiteUrl(String websiteUrl) {
    this.websiteUrl = websiteUrl;
  }
  public String getFacebookUrl() {
    return facebookUrl;
  }
  public void setFacebookUrl(String facebookUrl) {
    this.facebookUrl = facebookUrl;
  }
  public String getTwitterUrl() {
    return twitterUrl;
  }
  public void setTwitterUrl(String twitterUrl) {
    this.twitterUrl = twitterUrl;
  }
  public String getGooglePlusUrl() {
    return googlePlusUrl;
  }
  public void setGooglePlusUrl(String googlePlusUrl) {
    this.googlePlusUrl = googlePlusUrl;
  }
  public String getPanNumber() {
    return panNumber;
  }
  public void setPanNumber(String panNumber) {
    this.panNumber = panNumber;
  }
  public String getAddressProof() {
    return addressProof;
  }
  public void setAddressProof(String addressProof) {
    this.addressProof = addressProof;
  }
  public int getWalletBalance() {
    return walletBalance;
  }
  public void setWalletBalance(int walletBalance) {
    this.walletBalance = walletBalance;
  }
  public Calendar getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }
  public Calendar getLastUpdated() {
    return lastUpdated;
  }
  public void setLastUpdated(Calendar lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
  public Calendar getLastLogin() {
    return lastLogin;
  }
  public void setLastLogin(Calendar lastLogin) {
    this.lastLogin = lastLogin;
  }
}
