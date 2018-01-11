package com.cargain.micro.landscape.composite.dto;

/**
 * DTO for User entity
 *
 */
public class User {

  private Integer id;

  private String name;

  private String organization;


  public User() {}

  public Integer getId() {
    return id;
  }

  public User setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }


  public String getOrganization() {
    return organization;
  }

  public User setOrganization(String organization) {
    this.organization = organization;
    return this;
  }
}
