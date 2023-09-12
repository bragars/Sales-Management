package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.Employee;
import com.application.projectjavafx.models.Operation;
import com.application.projectjavafx.models.Product;
import com.application.projectjavafx.models.Supplier;
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
public class BuyOperationController implements ControlledScreen {
  ScreenController controller;

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

  @FXML
  private Stage stage;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private FXMLLoader fxmlLoader;

  @FXML
  private Scene scene;

  @FXML
  private ChoiceBox<String> supplierBox;

  @FXML
  private ChoiceBox<String> productBox;

  @FXML
  private ChoiceBox<String> buyerBox;

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

  public void initialize() throws ParseException {
    System.out.println("");
//    quantityField.setText("1");
//
//    ArrayList<Employee> employeesList = App.getEmployeesList();
//    ArrayList<String> employeesStringList = new ArrayList<>();
//    for (int i = 0; i < employeesList.size(); i++) {
//      if (employeesList.get(i).getType().equals("Buyer")) {
//        employeesStringList.add(employeesList.get(i).getName()+" - ID "+employeesList.get(i).getIdentifierNumber());
//      }
//    }
//    ObservableList<String> observableEmployeesList = FXCollections.observableArrayList(employeesStringList);
//    buyerBox.setItems(observableEmployeesList.sorted());
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
//    quantityField.textProperty().addListener(new ChangeListener<String>() {
//      @Override
//      public void changed(ObservableValue<? extends String> observable, String oldValue,String newValue) {
//        if (newValue.equals("") || newValue.equals("0")) {
//          totalLabel.setText("R$ 0,00");
//        }
//        else if (!newValue.matches("\\d*")) {
//          quantityField.setText(oldValue);
//        }
//        else {
//          quantityField.setText(newValue);
//          getTotal(this);
//        }
//      }
//    };

//    unitPriceField.textProperty().addListener(new ChangeListener<String>() {
//      @Override
//      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//        if (newValue.equals("") || newValue.equals("0")) {
//          totalLabel.setText("R$ 0,00");
//        }
//        else if (!newValue.matches("\\d*,?\\d*") || newValue.equals(",")) {
//          unitPriceField.setText(oldValue);
//        }
//        else {
//          unitPriceField.setText(newValue);
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

  public void getTotal(ChangeListener event) {
    DecimalFormat f = new DecimalFormat("##.00");
    if (!unitPriceField.getText().equals("") && !quantityField.getText().equals("")) {
      Double unitPriceDouble = Double.parseDouble(unitPriceField.getText().replace(",","."));
      Double quantityDouble = Double.parseDouble(quantityField.getText().replace(",","."));
      totalLabel.setText("R$ "+ f.format((new BigDecimal(unitPriceDouble * quantityDouble).setScale(2, RoundingMode.HALF_DOWN)).doubleValue()));
    }
  }

  public void executeOperation(ActionEvent event) throws ParseException {
//    String supplierStr = supplierBox.getValue();
//    String productStr = productBox.getValue();
//    String unitPriceStr = unitPriceField.getText();
//    String quantityStr = quantityField.getText();
//    String buyerStr = buyerBox.getValue();
//    String passwordStr = passwordField.getText();
//
//    Supplier supplierObj = null;
//    Product productObj = null;
//    Employee employeeObj = null;
//
//    if (supplierStr == null ||
//            productStr == null ||
//            unitPriceStr.equals("") ||
//            quantityStr.equals("") ||
//            buyerStr == null ||
//            passwordStr.equals("")) {
//      messageLabel.setVisible(true);
//    }
//    else {
//      ArrayList<Employee> employeesList = App.getEmployeesList();
//      String employeeId = buyerStr.split(" - ID ")[1];
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
//        Operation operation = new Operation(opId,null, todayDate, employeeObj, productObj, quantityInteger, supplierObj, "Buy", unitPriceDouble);
//
//        App.addOperation(operation);
//
//        messageLabel.setText("Compra realizada com sucesso!\nNúmero da operação: " + opId + "!");
//        messageLabel.setTextFill(GREEN);
//        messageLabel.setVisible(true);
//
//        passwordField.setDisable(true);
//        productBox.setDisable(true);
//        supplierBox.setDisable(true);
//        quantityField.setDisable(true);
//        unitPriceField.setDisable(true);
//        buyerBox.setDisable(true);
//        executeButton.setDisable(true);
//
//      }
//    }
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