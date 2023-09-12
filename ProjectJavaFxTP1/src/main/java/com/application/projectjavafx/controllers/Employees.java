package com.application.projectjavafx.controllers;

import com.application.projectjavafx.models.Employee;

import java.util.ArrayList;

public class Employees {
  public static ArrayList<Employee> employees = new ArrayList<>();

  public static ArrayList<Employee> getEmployees() {
    return employees;
  }

  public void addEmployee(Employee customer) {
    employees.add(customer);
  }

  public void remove(Employee customer) {
    employees.remove(customer);
  }
}
