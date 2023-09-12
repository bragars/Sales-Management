package com.application.projectjavafx.models;

import java.util.*;
import java.util.Date;
import java.util.stream.*;

public class Report {
  private Date from;
  private Date to;
  private Date issuedAt;
  private String type;
  private ArrayList<Operation> operations;

  Report(){};

  public Report(Date from, Date to, String type) {
    this.from = from;
    this.to = to;
    this.type = type;
    this.operations = new ArrayList<Operation>();
  }

  public ArrayList<Customer> customersActiveTimeframe(Date from, Date to) {
    ArrayList<Customer> r =
            (ArrayList<Customer>)this.getOperations()
                    .stream()
                    .filter((o)
                            -> o.getDateTime().compareTo(from) >= 0 &&
                            o.getDateTime().compareTo(to) <= 0)
                    .map((o) -> o.getCustomer())
                    .distinct()
                    .collect(Collectors.toList());
    return r;
  }

  public ArrayList<Customer> customersInactiveTimeframe(Date from, Date to) {
    Set<Customer> all =
            new HashSet<Customer>(this.getOperations()
                    .stream()
                    .map((o) -> o.getCustomer())
                    .distinct()
                    .collect(Collectors.toList()));
    Set<Customer> subsetTimeframe =
            new HashSet<>(this.customersActiveTimeframe(from, to));
    all.removeAll(subsetTimeframe);
    ArrayList<Customer> r =
            (ArrayList<Customer>)all.stream().collect(Collectors.toList());
    return r;
  }

  public ArrayList<Customer> customersHighVolume(Double threshold) {
    ArrayList<Customer> r =
            (ArrayList<Customer>)this.getOperations()
                    .stream()
                    .filter((o) -> (o.getQuantity() * o.getUnitPrice()) >= threshold)
                    .map((o) -> o.getCustomer())
                    .distinct()
                    .collect(Collectors.toList());
    return r;
  }

  public ArrayList<Product> productsSoldTimeframe(Date from, Date to) {
    ArrayList<Product> r =
            (ArrayList<Product>)this.getOperations()
                    .stream()
                    .filter((o)
                            -> o.getDateTime().compareTo(from) >= 0 &&
                            o.getDateTime().compareTo(to) <= 0)
                    .map((o) -> o.getProduct())
                    .distinct()
                    .collect(Collectors.toList());
    return r;
  }

  public ArrayList<Product> productsNotSoldTimeframe(Date from, Date to) {
    Set<Product> all = new HashSet<Product>(this.getOperations()
            .stream()
            .map((o) -> o.getProduct())
            .distinct()
            .collect(Collectors.toList()));
    Set<Product> subsetTimeframe =
            new HashSet<>(this.productsSoldTimeframe(from, to));
    all.removeAll(subsetTimeframe);
    ArrayList<Product> r =
            (ArrayList<Product>)all.stream().collect(Collectors.toList());
    return r;
  }

  public ArrayList<Employee> sellersHighPerformance(Double threshold, Date from,
                                                    Date to) {
    ArrayList<Operation> r =
            (ArrayList<Operation>)this.getOperations()
                    .stream()
                    .filter((o)
                            -> o.getDateTime().compareTo(from) >= 0 &&
                            o.getDateTime().compareTo(to) <= 0)
                    .filter((o)
                            -> o.getEmployee().getSeniority().equals("Junior") ||
                            o.getEmployee().getSeniority().equals("Mid"))
                    .collect(Collectors.toList());

    HashMap<Employee, Double> m = new HashMap<>();
    Double mean_employees = (double)0;

    for (Operation o : r) {
      // Get total sold by employee in timeframe.
      Employee e = o.getEmployee();
      Double k = m.getOrDefault(e, (double)0);
      Double sold = o.getQuantity() * o.getUnitPrice();
      k += sold;
      m.put(e, k);

      // Compute mean across all employees
      mean_employees += sold;
    }
    mean_employees /= m.size();
    Double cut_off = threshold * mean_employees;

    // Get final list of employees
    ArrayList<Employee> f = new ArrayList<>();
    for (Map.Entry<Employee, Double> e : m.entrySet()) {
      if (e.getValue() >= cut_off)
        f.add(e.getKey());
    }

    return f;
  }

  public ArrayList<Supplier> suppliersHighVolume(Double threshold, Date from,
                                                 Date to) {
    ArrayList<Operation> r =
            (ArrayList<Operation>)this.getOperations()
                    .stream()
                    .filter((o)
                            -> o.getDateTime().compareTo(from) >= 0 &&
                            o.getDateTime().compareTo(to) <= 0)
                    .collect(Collectors.toList());

    HashMap<Supplier, Double> m = new HashMap<>();
    Double mean_supplier = (double)0;

    for (Operation o : r) {
      // Get total sold by employee in timeframe.
      Supplier s = o.getSupplier();
      Double k = m.getOrDefault(s, (double)0);
      Double sold = o.getQuantity() * o.getUnitPrice();
      k += sold;
      m.put(s, k);

      // Compute mean across all employees
      mean_supplier += sold;
    }
    mean_supplier /= m.size();
    Double cut_off = threshold * mean_supplier;

    // Get final list of employees
    ArrayList<Supplier> f = new ArrayList<>();
    for (Map.Entry<Supplier, Double> e : m.entrySet()) {
      if (e.getValue() >= cut_off)
        f.add(e.getKey());
    }

    return f;
  }

  public ArrayList<Operation> getPurchasesTimeframe(Date from, Date to) {
    ArrayList<Operation> r =
            (ArrayList<Operation>)this.getOperations()
                    .stream()
                    .filter((o)
                            -> o.getType().equals("Buy") &&
                            o.getDateTime().compareTo(from) >= 0 &&
                            o.getDateTime().compareTo(to) <= 0)
                    .collect(Collectors.toList());
    return r;
  }

  public ArrayList<Operation> getSalesTimeframe(Date from, Date to) {
    ArrayList<Operation> r =
            (ArrayList<Operation>)this.getOperations()
                    .stream()
                    .filter((o)
                            -> o.getType().equals("Sell") &&
                            o.getDateTime().compareTo(from) >= 0 &&
                            o.getDateTime().compareTo(to) <= 0)
                    .collect(Collectors.toList());
    return r;
  }

  // TODO: Fazer sellers low performance? (como se certificar de que TODOS os
  // empregados serão buscados? a classe operations pode não conter todos os
  // empregados... Mesmo raciocínio vale para produtos vendidos, clientes,
  // etc...)

  public Date getFrom() { return from; }

  public void setFrom(Date from) { this.from = from; }

  public Date getTo() { return to; }

  public void setTo(Date to) { this.to = to; }

  public Date getIssuedAt() { return issuedAt; }

  public void setIssuedAt(Date issuedAt) { this.issuedAt = issuedAt; }

  public String getType() { return type; }

  public void setType(String type) { this.type = type; }

  public ArrayList<Operation> getOperations() { return this.operations; }

  public void setOperations(ArrayList<Operation> operations) {
    this.operations = operations;
  }
}