package com.application.projectjavafx.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Supplier extends Partner {
    private String businessField;
    private String businessSize;
    private ArrayList<Product> products;
    private ArrayList<Operation> operations;

    public Supplier(long id, LocalDate signUpDate, String name,
                    String identifierNumber, String identifierType,
                    String businessField, String businessSize) {
        super(id, signUpDate, name, identifierNumber, identifierType);
        this.businessField = businessField;
        this.businessSize = businessSize;
        this.products = new ArrayList<Product>();
        this.operations = new ArrayList<Operation>();
    }

  public Supplier(long id, LocalDate signUpDate, String name, String identifierNumber, String identifierType) {
    super(id, signUpDate, name, identifierNumber, identifierType);
  }

  public void addProduct(Product product) {
        product.setSupplier(this);
        this.products.add(product);
    }

    public void addProducts(ArrayList<Product> products) {
        products.forEach((product) -> product.setSupplier(this));
        this.products.addAll(products);
    }

    public String getBusinessField() { return businessField; }
    public void setBusinessField(String businessField) {
        this.businessField = businessField;
    }
    public String getBusinessSize() { return businessSize; }
    public void setBusinessSize(String businessSize) {
        this.businessSize = businessSize;
    }
    public ArrayList<Operation> getOperations() { return this.operations; }
    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Supplier{\n"
                + "signUpDate=" + signUpDate + "\n"
                + "name=" + name + "\n"
                + "identifierNumber=" + identifierNumber + "\n"
                + "identifierType=" + identifierType + "\n"
                + "businessField=" + businessField + "\n"
                + "businessSize=" + businessSize + "\n"
                + "}";
    }
}
