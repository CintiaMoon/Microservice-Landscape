package com.cargain.micro.landscape.composite.dto;

import java.util.Date;

/**
 * DTO for UserLog
 * @author cargain
 *
 */
public class UserLog {

  private Integer id;

  private String content;
  private Date createdAt;

  private Integer userId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public UserLog() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
