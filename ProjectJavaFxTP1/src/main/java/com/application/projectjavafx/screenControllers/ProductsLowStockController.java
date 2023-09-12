package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.Product;
import com.application.projectjavafx.models.Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ProductsLowStockController implements ControlledScreen {
  ScreenController controller;

  @FXML
  private Stage stage;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private TableView<Product> tableView;

  @FXML
  private TableColumn<Product, String> nameColumnn;

  @FXML
  private TableColumn<Product, String> supplierColumnn;

  @FXML
  private TableColumn<Product, Integer> stockColumn;

  @FXML
  private TableColumn<Product, String> suggestedPriceColumn;

  @FXML
  private FXMLLoader fxmlLoader;

  @FXML
  private Scene scene;

  @FXML
  private Label labelTimeframe;

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

  public void initialize() throws ParseException {
    // Atualiza a label com o período de referência do relatório
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    LocalDateTime today = LocalDateTime.now();
//    LocalDateTime thirtyDaysLater = LocalDateTime.now().plusDays(30);
//    String todayString = today.format(formatter);
//    String thirtyDaysLaterString = thirtyDaysLater.format(formatter);
//    labelTimeframe.setText(todayString + " a " + thirtyDaysLaterString);
//
//    // Cria relatório, chama método para preencher relatório e popula a tableview
//    Date todayDate = Date.from(today.atZone(ZoneId.systemDefault()).toInstant());
//    Date thirtyDaysLaterDate = Date.from(thirtyDaysLater.atZone(ZoneId.systemDefault()).toInstant());
//
//    Report report = new Report(todayDate, thirtyDaysLaterDate, "productsLowStock");
//
//    ArrayList<Product> productsArrayList = report.productsLowStock();
//
//    if (productsArrayList != null  && !productsArrayList.isEmpty()) {
//      ArrayList<Product> productsListArrayList = new ArrayList<>();
//      for (Product product : productsArrayList) {
//        Product item = new Product(product);
//        productsListArrayList.add(item);
//      }
//      ObservableList<Product> list = FXCollections.observableArrayList(productsListArrayList);
//      nameColumnn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
//      supplierColumnn.setCellValueFactory(new PropertyValueFactory<Product, String>("supplier"));
//      stockColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));
//      suggestedPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("suggestedPrice"));
//      tableView.setItems(list);
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