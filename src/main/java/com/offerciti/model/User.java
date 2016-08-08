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


@Entity @Table(name="users") 
public class User implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private @GeneratedValue(strategy = GenerationType.IDENTITY) @Id Integer id;
  private String title;
  @Column(name="first_name")
  private String firstName;
  @Column(name="last_name")
  private String lastName;
  private String dob;
  @Column(name="contact_number")
  private String contactNumber;
  private String email;
  private String password;
  private String status;
  private String gender;
  private String area;
  private String landmark;
  @Column(name="zip_code")
  private String zipCode;
  private String city;
  private String state;
  @Column(name="created_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar createdDate;
  @Column(name="last_login")
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar lastLogin;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getDob() {
    return dob;
  }
  public void setDob(String dob) {
    this.dob = dob;
  }
  public String getContactNumber() {
    return contactNumber;
  }
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getArea() {
    return area;
  }
  public void setArea(String area) {
    this.area = area;
  }
  public String getLandmark() {
    return landmark;
  }
  public void setLandmark(String landmark) {
    this.landmark = landmark;
  }
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public Calendar getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }
  public Calendar getLastLogin() {
    return lastLogin;
  }
  public void setLastLogin(Calendar lastLogin) {
    this.lastLogin = lastLogin;
  }
  

}
