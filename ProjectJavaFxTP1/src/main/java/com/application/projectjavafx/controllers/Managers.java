package com.application.projectjavafx.controllers;

import com.application.projectjavafx.models.Manager;

import java.util.ArrayList;

public class Managers {
  public static ArrayList<Manager> managers = new ArrayList<>();

  public static ArrayList<Manager> getManagers() {
    return managers;
  }

  public void addManager(Manager customer) {
    managers.add(customer);
  }

  public void remove(Manager customer) {
    managers.remove(customer);
  }

  public Manager searchManager(String name) {
    boolean exist = false;
    Manager customer = null;
    for(int index = 0; index < this.managers.size(); index++){
      if(this.managers.get(index).getName().equals(name)) {
        exist = true;
        customer = this.managers.get(index);
      }
    }
    if (exist)
      return customer;
    else
      return null;
  }
}
