package com.application.projectjavafx.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Employee extends User {
  private Manager manager;
  private String seniority;
  private String type;
  private ArrayList<Operation> operations;


  public Employee(int id, String identifierType, String identifierNumber, LocalDate signUpDate, String email,
                  String name, String password, String type, String seniority) {
    super(id, identifierType, identifierNumber, signUpDate, email, name, password);
    this.seniority = seniority;
    this.type = type;
    this.operations = new ArrayList<Operation>();
  }

  public Employee(int id, String identifierType, String identifierNumber, LocalDate signUpDate, String email,
                  String name, String password, String type, Manager manager, String seniority) {
    super(id, identifierType, identifierNumber, signUpDate, email, name, password);
    this.identifierNumber = identifierNumber;
    this.type = type;
    this.manager = manager;
    this.seniority = seniority;
    this.operations = new ArrayList<Operation>();
  }

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public Manager getManager() { return manager; }
  public void setManager(Manager manager) { this.manager = manager; }
  public String getSeniority() { return seniority; }
  public void setSeniority(String seniority) { this.seniority = seniority; }
  public void setIdentifierType(String identifierType) {
    this.identifierType = identifierType;
  }

  public ArrayList<Operation> getOperations() { return this.operations; }
  public void setOperations(ArrayList<Operation> operations) {
    this.operations = operations;
  }

//  public ArrayList<Operation> getPurchasesTimeframe(LocalDate from, LocalDate to) {
//    ArrayList<Operation> r =
//            (ArrayList<Operation>)this.getOperations()
//                    .stream()
//                    .filter((o)
//                            -> o.getType().equals("Buy") &&
//                            o.getDateTime().compareTo(from) >= 0 &&
//                            o.getDateTime().compareTo(to) <= 0)
//                    .collect(Collectors.toList());
//    return r;
//  }
//
//  public ArrayList<Operation> getSalesTimeframe(Date from, Date to) {
//    ArrayList<Operation> r =
//            (ArrayList<Operation>)this.getOperations()
//                    .stream()
//                    .filter((o)
//                            -> o.getType().equals("Sell") &&
//                            o.getDateTime().compareTo(from) >= 0 &&
//                            o.getDateTime().compareTo(to) <= 0)
//                    .collect(Collectors.toList());
//    return r;
//  }


  @Override
  public String toString() {
    return "Employee{\n"
            + "id=" + getId() + "\n"
            + "identifierNumber=" + identifierNumber + "\n"
            + "signUpDate=" + getSignUpDate() + "\n"
            + "email=" + getEmail() + "\n"
            + "name=" + getName() + "\n"
            + "password=" + getPassword() + "\n"
            + "EmployeeType=" + getType() + "\n"
            + "SeniorityType=" + getSeniority() + "\n}";
  }
}
