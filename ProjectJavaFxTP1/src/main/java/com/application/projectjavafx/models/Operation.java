package com.application.projectjavafx.models;

import java.util.Date;

public class Operation {
  private int id;
  private Customer customer;
  private Date dateTime;
  private Employee employee;
  private Product product;
  private int quantity;
  private Supplier supplier;
  private String type;
  private double unitPrice;

  Operation() {};
  public Operation(int id, Customer customer, Date dateTime, Employee employee, Product product, int quantity, Supplier supplier, String type, double unitPrice) {
    this.id = id;
    this.customer = customer;
    this.dateTime = dateTime;
    this.employee = employee;
    this.product = product;
    this.quantity = quantity;
    this.supplier = supplier;
    this.type = type;
    this.unitPrice = unitPrice;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  public Date getDateTime() {
    return dateTime;
  }
  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }
  public Employee getEmployee() {
    return employee;
  }
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public Supplier getSupplier() {
    return supplier;
  }
  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public double getUnitPrice() {
    return unitPrice;
  }
  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public String toString() {
    return "Operation{\n"
            + "id=" + id + "\n"
            + "customer=" + customer + "\n"
            + "dateTime=" + dateTime + "\n"
            + "employee=" + employee + "\n"
            + "product=" + product + "\n"
            + "quantity=" + quantity + "\n"
            + "supplier=" + supplier + "\n"
            + "type=" + type + "\n"
            + "unitPrice=" + unitPrice + "\n"
            + "}";
  }
}
