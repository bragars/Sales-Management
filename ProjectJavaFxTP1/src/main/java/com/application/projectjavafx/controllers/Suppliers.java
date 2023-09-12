package com.application.projectjavafx.controllers;

import com.application.projectjavafx.models.Supplier;

import java.util.ArrayList;

public class Suppliers {
    public static ArrayList<Supplier> suppliers = new ArrayList<>();

    public static ArrayList<Supplier> getSuppliers() {
      return suppliers;
    }

    public void addSupplier(Supplier customer) {
      suppliers.add(customer);
    }

    public void remove(Supplier customer) {
      suppliers.remove(customer);
    }

    public Supplier searchCustomer(String name) {
      boolean exist = false;
      Supplier supplier = null;
      for(int index = 0; index < this.suppliers.size(); index++){
        if(this.suppliers.get(index).getName().equals(name)) {
          exist = true;
          supplier = this.suppliers.get(index);
        }
      }
      if (exist)
        return supplier;
      else
        return null;
    }

}
