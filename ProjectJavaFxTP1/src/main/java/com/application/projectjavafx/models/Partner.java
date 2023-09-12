package com.application.projectjavafx.models;

import java.time.LocalDate;

public abstract class Partner {
  protected long id;
  protected LocalDate signUpDate;
  protected String name;
  protected String identifierNumber;
  protected String identifierType;

  Partner() {};
  Partner(long id, LocalDate signUpDate, String name, String identifierNumber, String identifierType) {
    this.id = id;
    this.signUpDate = signUpDate;
    this.name = name;
    this.identifierNumber = identifierNumber;
    this.identifierType = identifierType;
  }

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public LocalDate getSignUpDate() {
    return signUpDate;
  }
  public void setSignUpDate(LocalDate signUpDate) {
    this.signUpDate = signUpDate;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getIdentifierNumber() {
    return identifierNumber;
  }
  public void setIdentifierNumber(String identifierNumber) {
    this.identifierNumber = identifierNumber;
  }
  public String getIdentifierType() {
    return identifierType;
  }
  public void setIdentifierType(String identifierType) {
    this.identifierType = identifierType;
  }
}

