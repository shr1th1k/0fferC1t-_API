package com.offerciti.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class OffercitiSerializable implements Serializable {
  
  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
