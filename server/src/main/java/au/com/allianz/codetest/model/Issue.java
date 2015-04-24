/*
 * Copyright (c) 2002-2003 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package au.com.allianz.codetest.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Issue {
  
  private int id;
  private String name;
  private Date createdDate;
   
  public int getId() {
      return id;
  }
  public void setId(int id) {
      this.id = id;
  }
  public String getName() {
      return name;
  }
  public void setName(String name) {
      this.name = name;
  }
   
  @JsonSerialize(using=DateSerializer.class)
  public Date getCreatedDate() {
      return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
  }
}
