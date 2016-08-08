
package com.offerciti.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Offer implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private @GeneratedValue(strategy = GenerationType.IDENTITY) @Id int offerCode;
  
  private int merchantId;
  private int branchId;
  private String offerName;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar fromDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar toDate;
  private short status;
  private int category_code;
  private int likeCount;
  private int viewCount;
  private int fbShareCount;
  private int twitterShareCount;
  private int googlePlusShareCount;
  private int emailShareCount;
  private int whatsPppShareCount;
  private int smsShareCount;
  private String description;
  private String discountType;
  private String discount;
  private int buyCount;
  private int getCount;
  private String social_media_image_url;
  private int transactionId;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar createdDate;
  public int getOfferCode() {
    return offerCode;
  }
  public void setOfferCode(int offerCode) {
    this.offerCode = offerCode;
  }
  public int getMerchantId() {
    return merchantId;
  }
  public void setMerchantId(int merchantId) {
    this.merchantId = merchantId;
  }
  public int getBranchId() {
    return branchId;
  }
  public void setBranchId(int branchId) {
    this.branchId = branchId;
  }
  public String getOfferName() {
    return offerName;
  }
  public void setOfferName(String offerName) {
    this.offerName = offerName;
  }
  public Calendar getFromDate() {
    return fromDate;
  }
  public void setFromDate(Calendar fromDate) {
    this.fromDate = fromDate;
  }
  public Calendar getToDate() {
    return toDate;
  }
  public void setToDate(Calendar toDate) {
    this.toDate = toDate;
  }
  public short getStatus() {
    return status;
  }
  public void setStatus(short status) {
    this.status = status;
  }
  public int getCategory_code() {
    return category_code;
  }
  public void setCategory_code(int category_code) {
    this.category_code = category_code;
  }
  public int getLikeCount() {
    return likeCount;
  }
  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getFbShareCount() {
    return fbShareCount;
  }
  public void setFbShareCount(int fbShareCount) {
    this.fbShareCount = fbShareCount;
  }
  public int getTwitterShareCount() {
    return twitterShareCount;
  }
  public void setTwitterShareCount(int twitterShareCount) {
    this.twitterShareCount = twitterShareCount;
  }
  public int getGooglePlusShareCount() {
    return googlePlusShareCount;
  }
  public void setGooglePlusShareCount(int googlePlusShareCount) {
    this.googlePlusShareCount = googlePlusShareCount;
  }
  public int getEmailShareCount() {
    return emailShareCount;
  }
  public void setEmailShareCount(int emailShareCount) {
    this.emailShareCount = emailShareCount;
  }
  public int getWhatsPppShareCount() {
    return whatsPppShareCount;
  }
  public void setWhatsPppShareCount(int whatsPppShareCount) {
    this.whatsPppShareCount = whatsPppShareCount;
  }
  public int getSmsShareCount() {
    return smsShareCount;
  }
  public void setSmsShareCount(int smsShareCount) {
    this.smsShareCount = smsShareCount;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getDiscountType() {
    return discountType;
  }
  public void setDiscountType(String discountType) {
    this.discountType = discountType;
  }
  public String getDiscount() {
    return discount;
  }
  public void setDiscount(String discount) {
    this.discount = discount;
  }
  public int getBuyCount() {
    return buyCount;
  }
  public void setBuyCount(int buyCount) {
    this.buyCount = buyCount;
  }
  public int getGetCount() {
    return getCount;
  }
  public void setGetCount(int getCount) {
    this.getCount = getCount;
  }
  public String getSocial_media_image_url() {
    return social_media_image_url;
  }
  public void setSocial_media_image_url(String social_media_image_url) {
    this.social_media_image_url = social_media_image_url;
  }
  public int getTransactionId() {
    return transactionId;
  }
  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }
  public Calendar getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }
}
