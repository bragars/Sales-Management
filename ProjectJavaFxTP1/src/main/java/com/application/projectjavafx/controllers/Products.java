package com.application.projectjavafx.controllers;

import com.application.projectjavafx.models.Product;
import java.util.ArrayList;

public class Products {
  public static ArrayList<Product> products = new ArrayList<>();

  public static ArrayList<Product> getProducts() {
    return products;
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void remove(Product product) {
    products.remove(product);
  }

  public Product searchProduct(String name) {
    boolean exist = false;
    Product product = null;
    for(int index = 0; index < this.products.size(); index++){
      if(this.products.get(index).getName().equals(name)) {
        exist = true;
        product = this.products.get(index);
      }
    }
    if (exist)
      return product;
    else
      return null;
  }
}
