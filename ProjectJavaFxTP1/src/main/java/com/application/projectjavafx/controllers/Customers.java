package com.application.projectjavafx.controllers;

import com.application.projectjavafx.models.Customer;
import java.util.ArrayList;

public class Customers {
  public static ArrayList<Customer> customers = new ArrayList<>();

  public static ArrayList<Customer> getCustomers() {
    return customers;
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  public void remove(Customer customer) {
    customers.remove(customer);
  }

  public Customer searchCustomer(String name) {
    boolean exist = false;
    Customer customer = null;
    for(int index = 0; index < this.customers.size(); index++){
      if(this.customers.get(index).getName().equals(name)) {
        exist = true;
        customer = this.customers.get(index);
      }
    }
    if (exist)
      return customer;
    else
      return null;
  }
}
