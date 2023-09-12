package com.application.projectjavafx.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Customer extends Partner {
  private ArrayList<Operation> operations;

//  Customer() {};
  public Customer(long id, LocalDate signUpDate, String name, String identifierNumber, String identifierType) {
    super(id, signUpDate, name, identifierNumber, identifierType);
  }

  public ArrayList<Operation> getPurchasesTimeframe(Date from, Date to) {
    ArrayList<Operation> r =
            (ArrayList<Operation>)this.getOperations()
                    .stream()
                    .filter((o)
                            -> o.getType().equals("Buy") &&
                            o.getDateTime().compareTo(from) >= 0 &&
                            o.getDateTime().compareTo(to) <= 0)
                    .collect(Collectors.toList());
    return r;
  }

  public long getId() { return id; }
  public void setId(long id) { this.id = id; }
  public LocalDate getSignUpDate() { return signUpDate; }
  public void setSignUpDate(LocalDate signUpDate) { this.signUpDate = signUpDate; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getIdentifierNumber() { return identifierNumber; }
  public void setIdentifierNumber(String identifierNumber) {
    this.identifierNumber = identifierNumber;
  }
  public String getIdentifierType() { return identifierType; }
  public void setIdentifierType(String identifierType) {
    this.identifierType = identifierType;
  }
  public ArrayList<Operation> getOperations() { return this.operations; }
  public void setOperations(ArrayList<Operation> operations) {
    this.operations = operations;
  }
}
