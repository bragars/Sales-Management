/*
### Esta classe transforma os objetos Operation em arrays que podem ser exibidas na tableview.
*/

package com.application.projectjavafx.controllers;

import com.application.projectjavafx.models.Operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SalesAndPurchasesList {
  private String dateTime;
  private String product;
  private Integer quantity;
  private String supplier;
  private Double ammount;

  public SalesAndPurchasesList(Operation operation) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime date = LocalDateTime.ofInstant(operation.getDateTime().toInstant(),
            ZoneId.systemDefault());
    String formattedDate = date.format(formatter);
    dateTime = formattedDate;
    product = operation.getProduct().getName();
    quantity = (Integer)operation.getQuantity();
    supplier = operation.getSupplier().getName();
    ammount = (new BigDecimal(operation.getUnitPrice() * Double.parseDouble(String.valueOf(quantity))).setScale(2,RoundingMode.HALF_DOWN)).doubleValue();
  }

  public String getDateTime() {
    return dateTime;
  }

  public String getProduct() {
    return product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public String getSupplier() {
    return supplier;
  }

  public Double getAmmount() {
    return ammount;
  }
}