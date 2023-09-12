package com.application.projectjavafx.models;

import java.time.LocalDate;

public abstract class User {
  private long id;
  protected String identifierNumber;
  protected String identifierType;
  private LocalDate signUpDate;
  private String email;
  private String name;
  private String password;

  User() {};
  public User(long id, String identifierType, String identifierNumber, LocalDate signUpDate, String email, String name, String password) {
    this.id = id;
    this.identifierType = identifierType;
    this.identifierNumber = identifierNumber;
    this.signUpDate = signUpDate;
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public long getId() { return id; }
  public void setId(long id) { this.id = id; }
  public String getIdentifierNumber() {
    return identifierNumber;
  }
  public void setIdentifierType(String identifierType) {
    this.identifierType = identifierType;
  }
  public String getIdentifierType() {
    return identifierType;
  }
  public void setIdentifierNumber(String identifierNumber) {
    this.identifierNumber = identifierNumber;
  }
  public LocalDate getSignUpDate() { return signUpDate; }
  public void setSignUpDate(LocalDate signUpDate) { signUpDate = signUpDate; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
}