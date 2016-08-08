
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
@Table(name="offers")
public class Offer implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(name="offer_code")
  private @GeneratedValue(strategy = GenerationType.IDENTITY) @Id int offerCode;
  @Column(name="merchant_id")
  private int merchantId;
  @Column(name="branch_id")
  private int branchId;
  @Column(name="offer_name")
  private String offerName;
  @Column(name="from_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar fromDate;
  @Column(name="to_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar toDate;
  @Column(name="status")
  private short status;
  @Column(name="category_code")
  private int categoryCode;
  @Column(name="like_count")
  private int likeCount;
  @Column(name="view_count")
  private int viewCount;
  @Column(name="fb_share_count")
  private int fbShareCount;
  @Column(name="twitter_share_count")
  private int twitterShareCount;
  @Column(name="google_plus_share_count")
  private int googlePlusShareCount;
  @Column(name="email_share_count")
  private int emailShareCount;
  @Column(name="whats_app_share_count")
  private int whatsPppShareCount;
  @Column(name="sms_share_count")
  private int smsShareCount;
  @Column(name="description")
  private String description;
  @Column(name="discount_type")
  private String discountType;
  @Column(name="discount")
  private String discount;
  @Column(name="buy_count")
  private int buyCount;
  @Column(name="get_count")
  private int getCount;
  @Column(name="social_media_image_url")
  private String socialMediaImageUrl;
  @Column(name="transaction_id")
  private int transactionId;
  @Column(name="created_date")
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
  public int getCategoryCode() {
    return categoryCode;
  }
  public void setCategoryCode(int category_code) {
    this.categoryCode = category_code;
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
  public String getSocialMediaImageUrl() {
    return socialMediaImageUrl;
  }
  public void setSocial_media_image_url(String socialMediaImageUrl) {
    this.socialMediaImageUrl = socialMediaImageUrl;
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
