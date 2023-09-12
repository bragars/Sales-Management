package com.application.projectjavafx.models;

public class Product {
  private int id;
  private String description;
  private String name;
  private double minPrice;
  private double suggestedPrice;
  private int stock;
  private Supplier supplier;

  public Product(int id, String description, String name, double minPrice,
                 double suggestedPrice, int stock) {
    this.id = id;
    this.description = description;
    this.name = name;
    this.minPrice = minPrice;
    this.suggestedPrice = suggestedPrice;
    this.stock = stock;
  }

  public Product(int id, String description, String name, double minPrice,
                 double suggestedPrice, Supplier supplier, int stock) {
    this.id = id;
    this.description = description;
    this.name = name;
    this.minPrice = minPrice;
    this.suggestedPrice = suggestedPrice;
    this.supplier = supplier;
    this.stock = stock;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public String getDescription() { return description; }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public double getMinPrice() { return minPrice; }
  public void setMinPrice(double minPrice) { this.minPrice = minPrice; }
  public double getSuggestedPrice() { return suggestedPrice; }
  public void setSuggestedPrice(double suggestedPrice) {
    this.suggestedPrice = suggestedPrice;
  }
  public int getStock() { return stock; }
  public void setStock(int stock) { this.stock = stock; }
  public Supplier getSupplier() { return supplier; }
  public void setSupplier(Supplier supplier) { this.supplier = supplier; }

  @Override
  public String toString() {
    return "Product{\n"
            + "id=" + id + "\n"
            + "description=" + description + "\n"
            + "name=" + name + "\n"
            + "minPrice=" + minPrice + "\n"
            + "suggestedPrice=" + suggestedPrice + "\n"
            + "stock=" + stock + "\n"
            + "supplier=" + supplier + "\n}";
  }
}
