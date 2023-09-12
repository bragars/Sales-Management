package com.application.projectjavafx.models;

import java.time.LocalDate;
import java.util.*;

public class Manager extends User {
  private String type;
  private ArrayList<Employee> subordinates;

  public Manager(int id, String identifierType, String identifierNumber, LocalDate signUpDate, String email, String name, String password) {
    super(id, identifierType, identifierNumber, signUpDate, email, name, password);
  }

  public Manager(int id, String identifierType, String identifierNumber, LocalDate signUpDate, String email,
                 String name, String password, String type) {
    super(id, identifierType, identifierNumber, signUpDate, email, name, password);
    this.identifierNumber = identifierNumber;
    this.type = type;
    this.subordinates = new ArrayList<Employee>();
  }

  public void addSubordinate(Employee employee) {
    this.subordinates.add(employee);
  }
  public void addSubordinates(ArrayList<Employee> employees) {
    this.subordinates.addAll(employees);
  }

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  public ArrayList<Employee> getSubordinates() { return subordinates; }
  public void setSubordinates(ArrayList<Employee> subordinates) {
    this.subordinates = subordinates;
  }

  @Override
  public String toString() {
    return "Manager{\n"
            + "id=" + getId() + "\n"
            + "identifierNumber=" + identifierNumber + "\n"
            + "signUpDate=" + getSignUpDate() + "\n"
            + "email=" + getEmail() + "\n"
            + "name=" + getName() + "\n"
            + "password=" + getPassword() + "\n"
            + "ManagerType=" + type + "\n"
            + "subordinates=" + subordinates + "\n}";
  }
}
