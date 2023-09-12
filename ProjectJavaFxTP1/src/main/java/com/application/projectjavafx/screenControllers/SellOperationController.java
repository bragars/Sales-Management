package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import static javafx.scene.paint.Color.GREEN;

@Component
@FxmlView("sellOperation.fxml")
public class SellOperationController implements ControlledScreen {
  ScreenController controller;

  @FXML
  private Stage stage;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private FXMLLoader fxmlLoader;

  @FXML
  private Scene scene;

  @FXML
  private Label minPriceLabel;

  @FXML
  private Label maxQuantityLabel;

  @FXML
  private ChoiceBox<String> customerBox;

  @FXML
  private ChoiceBox<String> supplierBox;

  @FXML
  private ChoiceBox<String> productBox;

  @FXML
  private ChoiceBox<String> sellerBox;

  @FXML
  private PasswordField passwordField;

  @FXML
  private TextField unitPriceField;

  @FXML
  private TextField quantityField;

  @FXML
  private Label totalLabel;

  @FXML
  private Label messageLabel;

  @FXML
  private Button executeButton;

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

  public void initialize() throws ParseException {
//    quantityField.setText("1");
//
//    ArrayList<Customer> customersList = App.getCustomersList();
//    ArrayList<String> customersStringList = new ArrayList<>();
//    for (int i = 0; i < customersList.size(); i++) {
//      customersStringList.add(customersList.get(i).getName()+" - ID "+customersList.get(i).getIdentifierNumber());
//    }
//    ObservableList<String> observableCustomersList = FXCollections.observableArrayList(customersStringList);
//    customerBox.setItems(observableCustomersList.sorted());
//
//    ArrayList<Employee> employeesList = App.getEmployeesList();
//    ArrayList<String> employeesStringList = new ArrayList<>();
//    for (int i = 0; i < employeesList.size(); i++) {
//      if (employeesList.get(i).getType().equals("Seller")) {
//        employeesStringList.add(employeesList.get(i).getName()+" - ID "+employeesList.get(i).getIdentifierNumber());
//      }
//    }
//    ObservableList<String> observableEmployeesList = FXCollections.observableArrayList(employeesStringList);
//    sellerBox.setItems(observableEmployeesList.sorted());
//
//    ArrayList<Supplier> suppliersList = App.getSuppliersList();
//    ArrayList<String> suppliersStringList = new ArrayList<>();
//    for (int i = 0; i < suppliersList.size(); i++) {
//      suppliersStringList.add(suppliersList.get(i).getName()+" - ID "+suppliersList.get(i).getIdentifierNumber());
//    }
//    ObservableList<String> observableSuppliersList = FXCollections.observableArrayList(suppliersStringList);
//    supplierBox.setItems(observableSuppliersList.sorted());
//    supplierBox.setOnAction(this::getProduct);
//
//    productBox.setOnAction(this::getUnitPrice);
//
//    quantityField.textProperty().addListener(new ChangeListener<String>() {
//      @Override
//      public void changed(ObservableValue<? extends String> observable, String oldValue,
//                          String newValue) {
//
//        if (newValue.equals("") || newValue.equals("0")) {
//          totalLabel.setText("R$ 0,00");
//          maxQuantityLabel.setVisible(false);
//        }
//        else if (!newValue.matches("\\d*")) {
//          maxQuantityLabel.setVisible(false);
//          quantityField.setText(oldValue);
//        }
//        else {
//          String[] product = productBox.getValue().split(" - ID ");
//          Integer productId = Integer.parseInt(product[1]);
//          Integer maxQuantity;
//          ArrayList<Product> productsList = App.getProductsList();
//          for (int i = 0; i < productsList.size(); i++) {
//            if (productsList.get(i).getId() == productId) {
//              maxQuantity = productsList.get(i).getStock();
//              if (!newValue.equals("") && Integer.parseInt(newValue) > maxQuantity) {
//                quantityField.setText(String.valueOf(maxQuantity));
//                maxQuantityLabel.setText("Qtde. máxima: "+String.valueOf(maxQuantity));
//                maxQuantityLabel.setVisible(true);
//              }
//              else {
//                maxQuantityLabel.setVisible(false);
//              }
//            }
//          }
//          getTotal(this);
//        }
//
//      }
//    });
//
//    unitPriceField.textProperty().addListener(new ChangeListener<String>() {
//      @Override
//      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//        if (newValue.equals("") || newValue.equals("0")) {
//          totalLabel.setText("R$ 0,00");
//          minPriceLabel.setVisible(false);
//        }
//        else if (!newValue.matches("\\d*,?\\d*") || newValue.equals(",")) {
//          minPriceLabel.setVisible(false);
//          unitPriceField.setText(oldValue);
//        }
//        else {
//          unitPriceField.setText(newValue);
//
//          String[] product = productBox.getValue().split(" - ID ");
//          Integer productId = Integer.parseInt(product[1]);
//          Double minPrice;
//          ArrayList<Product> productsList = App.getProductsList();
//          for (int i = 0; i < productsList.size(); i++) {
//            if (productsList.get(i).getId() == productId) {
//              minPrice = productsList.get(i).getMinPrice();
//              if (newValue != null && !newValue.equals("") && Double.parseDouble(newValue.replace(",", ".")) < minPrice) {
//                DecimalFormat f = new DecimalFormat("##.00");
//                minPriceLabel.setText("Valor abaixo do mínimo: R$ " + String.valueOf(f.format((new BigDecimal(minPrice).setScale(2, RoundingMode.HALF_DOWN)).doubleValue())).replace(".", ","));
//                minPriceLabel.setVisible(true);
//              } else {
//                unitPriceField.setText(newValue);
//                minPriceLabel.setVisible(false);
//              }
//            }
//          }
//          getTotal(this);
//        }
//      }
//    });
  }

  public void getProduct(ActionEvent event) {
//    ArrayList<Supplier> suppliersList = App.getSuppliersList();
//    String[] supplier = supplierBox.getValue().split(" - ID ");
//    String supplierId = supplier[1];
//    ArrayList<Product> productsList = App.getProductsList();
//    ArrayList<String> productsStringList = new ArrayList<>();
//    for (int i = 0; i < suppliersList.size(); i++) {
//      if (suppliersList.get(i).getIdentifierNumber().equals(supplierId)) {
//        for (int j = 0; j < productsList.size(); j++) {
//          if (productsList.get(j).getSupplier() == suppliersList.get(i)) {
//            productsStringList.add(productsList.get(j).getName()+" - ID "+ productsList.get(j).getId());
//          }
//        }
//      }
//    }
//    ObservableList<String> observableProductsList = FXCollections.observableArrayList(productsStringList);
//    productBox.setItems(observableProductsList.sorted());
  }

  public void getUnitPrice(ActionEvent event) {
//    ArrayList<Product> productsList = App.getProductsList();
//    String[] product = productBox.getValue().split(" - ID ");
//    Integer productId = Integer.parseInt(product[1]);
//    Double suggestedPriceDouble;
//    String suggestedPriceString;
//    DecimalFormat f = new DecimalFormat("##.00");
//    for (int i = 0; i < productsList.size(); i++) {
//      if (productsList.get(i).getId() == productId) {
//        suggestedPriceDouble = productsList.get(i).getSuggestedPrice();
//        suggestedPriceString = f.format((new BigDecimal(suggestedPriceDouble).setScale(2, RoundingMode.HALF_DOWN)).doubleValue());
//        unitPriceField.setText(suggestedPriceString);
//      }
//    }
//    unitPriceField.setEditable(true);
//    quantityField.setEditable(true);
//
//    Double unitPriceDouble = Double.parseDouble(unitPriceField.getText().replace(",","."));
//    Double quantityDouble = Double.parseDouble(quantityField.getText().replace(",","."));
//    totalLabel.setText("R$ "+ f.format((new BigDecimal(unitPriceDouble * quantityDouble).setScale(2, RoundingMode.HALF_DOWN)).doubleValue()));

  }

  public void getTotal(ChangeListener event) {
    DecimalFormat f = new DecimalFormat("##.00");
    if (!unitPriceField.getText().equals("") && !quantityField.getText().equals("")) {
      Double unitPriceDouble = Double.parseDouble(unitPriceField.getText().replace(",","."));
      Double quantityDouble = Double.parseDouble(quantityField.getText().replace(",","."));
      totalLabel.setText("R$ "+ f.format((new BigDecimal(unitPriceDouble * quantityDouble).setScale(2, RoundingMode.HALF_DOWN)).doubleValue()));
    }
  }

  public void executeOperation(ActionEvent event) throws ParseException {
//    String customerStr = customerBox.getValue();
//    String supplierStr = supplierBox.getValue();
//    String productStr = productBox.getValue();
//    String unitPriceStr = unitPriceField.getText();
//    String quantityStr = quantityField.getText();
//    String sellerStr = sellerBox.getValue();
//    String passwordStr = passwordField.getText();
//
//    Customer customerObj = null;
//    Supplier supplierObj = null;
//    Product productObj = null;
//    Employee employeeObj = null;
//
//    if (customerStr == null ||
//            supplierStr == null ||
//            productStr == null ||
//            unitPriceStr.equals("") ||
//            quantityStr.equals("") ||
//            sellerStr == null ||
//            passwordStr.equals("")) {
//      messageLabel.setVisible(true);
//    }
//    else {
//      ArrayList<Employee> employeesList = App.getEmployeesList();
//      String employeeId = sellerStr.split(" - ID ")[1];
//      for (int i = 0; i < employeesList.size(); i++) {
//        if (employeesList.get(i).getIdentifierNumber().equals(employeeId)) {
//          employeeObj = employeesList.get(i);
//        }
//      }
//
//      if (!employeeObj.getPassword().equals(passwordStr)) {
//        messageLabel.setText("Atenção! Senha incorreta!");
//        messageLabel.setVisible(true);
//        passwordField.setText("");
//      }
//
//      else {
//        ArrayList<Supplier> suppliersList = App.getSuppliersList();
//        String supplierId = supplierStr.split(" - ID ")[1];
//        for (int i = 0; i < suppliersList.size(); i++) {
//          if (suppliersList.get(i).getIdentifierNumber().equals(supplierId)) {
//            supplierObj = suppliersList.get(i);
//          }
//        }
//
//        ArrayList<Customer> customersList = App.getCustomersList();
//        String customerId = customerStr.split(" - ID ")[1];
//        for (int i = 0; i < customersList.size(); i++) {
//          if (customersList.get(i).getIdentifierNumber().equals(customerId)) {
//            customerObj = customersList.get(i);
//          }
//        }
//
//        ArrayList<Product> productsList = App.getProductsList();
//        Integer productId = Integer.parseInt(productStr.split(" - ID ")[1]);
//        for (int i = 0; i < productsList.size(); i++) {
//          if (productsList.get(i).getId() == productId) {
//            productObj = productsList.get(i);
//          }
//        }
//
//        Double unitPriceDouble = Double.parseDouble(unitPriceStr.replace(",","."));
//        Integer quantityInteger = Integer.parseInt(quantityStr);
//
//        int opId = 1;
//        ArrayList<Operation> operationsList = App.getOperationsList();
//        for (int i =0; i < operationsList.size(); i++) {
//          if (operationsList.get(i).getId() >= opId) {
//            opId = operationsList.get(i).getId() + 1;
//          }
//        }
//
//        LocalDateTime today = LocalDateTime.now();
//        Date todayDate = Date.from(today.atZone(ZoneId.systemDefault()).toInstant());
//
//        Operation operation = new Operation(opId, customerObj, todayDate, employeeObj, productObj, quantityInteger, supplierObj, "Sell", unitPriceDouble);
//
//        App.addOperation(operation);
//
//        messageLabel.setText("Venda realizada com sucesso!\nNúmero da operação: " + opId + "!");
//
//
//        messageLabel.setTextFill(GREEN);
//        messageLabel.setVisible(true);
//
//
//        passwordField.setDisable(true);
//        customerBox.setDisable(true);
//        productBox.setDisable(true);
//        supplierBox.setDisable(true);
//        quantityField.setDisable(true);
//        unitPriceField.setDisable(true);
//        sellerBox.setDisable(true);
//        executeButton.setDisable(true);
//
//      }
//
//
//
//
//
//
//
//
//
//    }
//

  }

  //Faz logout quando o usuário clica na label Sair. Contém tela de confirmação. A tela de confirmação
  // para o "X" deve ser inserida na main.

  @FXML
  public void logout(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Sair");
    alert.setHeaderText("Você está encerrando a aplicação!");
    alert.setContentText("Deseja realmente sair?");

    if(alert.showAndWait().get() == ButtonType.OK) {
      stage = (Stage) anchorPane.getScene().getWindow();
      stage.close();
    }
  }

  //Retorna ao menu, quando o usuário clica na label Menu

  @FXML
  public void backToMenu(ActionEvent event) throws IOException {
    controller.setScreen(JavaFxApplication.homeScreenId);
  }
}