package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.Report;
import com.application.projectjavafx.models.Supplier;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class SuppliersLowVolumeController implements ControlledScreen {
  ScreenController controller;

  @FXML
  private Stage stage;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private TableView<Supplier> tableView;

  @FXML
  private TableColumn<Supplier, String> nameColumnn;

  @FXML
  private TableColumn<Supplier, String> identifierNumberColumnn;

  @FXML
  private TableColumn<Supplier, String> identifierTypeColumn;

  @FXML
  private TableColumn<Supplier, String> businessFieldColumn;

  @FXML
  private TableColumn<Supplier, String> businessSizeColumn;

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
//    LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
//    String todayString = today.format(formatter);
//    String thirtyDaysAgoString = thirtyDaysAgo.format(formatter);
//    labelTimeframe.setText(thirtyDaysAgoString + " a " + todayString);
//
//    // Cria relatório, chama método para preencher relatório e popula a tableview
//    Date todayDate = Date.from(today.atZone(ZoneId.systemDefault()).toInstant());
//    Date thirtyDaysAgoDate = Date.from(thirtyDaysAgo.atZone(ZoneId.systemDefault()).toInstant());
//
//    Report report = new Report(thirtyDaysAgoDate, todayDate, "suppliersLowVolume");
//
//    ArrayList<Supplier> suppliersArrayList = report.suppliersLowVolume(thirtyDaysAgoDate, todayDate);
//    //Talvez seja necessário ajustes os argumentos caso quando o método de Report (acima) for implementado
//    if (suppliersArrayList != null  && !suppliersArrayList.isEmpty()) {
//      ArrayList<Supplier> suppliersListArrayList = new ArrayList<>();
//      for (Supplier supplier : suppliersArrayList) {
//        Supplier item = new Supplier(supplier);
//        suppliersListArrayList.add(item);
//      }
//      ObservableList<Supplier> list = FXCollections.observableArrayList(suppliersListArrayList);
//      nameColumnn.setCellValueFactory(new PropertyValueFactory<Supplier, String>("name"));
//      identifierNumberColumnn.setCellValueFactory(new PropertyValueFactory<Supplier, String>("identifierNumber"));
//      identifierTypeColumn.setCellValueFactory(new PropertyValueFactory<Supplier, String>("identifierType"));
//      businessFieldColumn.setCellValueFactory(new PropertyValueFactory<Supplier, String>("businessField"));
//      businessSizeColumn.setCellValueFactory(new PropertyValueFactory<Supplier, String>("businessSize"));
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