package com.application.projectjavafx.models;

import java.util.*;

public class ReportType {
  public static ArrayList<String> types = new ArrayList<String>(Arrays.asList(
          "SuppliersSoldProducts", "SuppliersHighVolume", "SellersLowPerformance",
          "SellersHighPerformance", "ProductsNotSold", "ProductsSold",
          "CustomersInactive", "CustomersHighVolume", "CustomersActive"));
}
