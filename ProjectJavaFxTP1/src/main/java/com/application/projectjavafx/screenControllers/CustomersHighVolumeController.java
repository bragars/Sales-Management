package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.Customer;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class CustomersHighVolumeController implements ControlledScreen {
  ScreenController controller;

  @FXML
  private Stage stage;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private TableView<Customer> tableView;

  @FXML
  private TableColumn<Customer, String> nameColumnn;

  @FXML
  private TableColumn<Customer, String> identifierNumberColumnn;

  @FXML
  private TableColumn<Customer, String> identifierTypeColumnn;

  @FXML
  private TableColumn<Customer, String> signUpDateColumn;

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
//    LocalDateTime twelveMonthsAgo = LocalDateTime.now().minusMonths(6);
//    String todayString = today.format(formatter);
//    String twelveMonthsAgoString = twelveMonthsAgo.format(formatter);
//    labelTimeframe.setText(twelveMonthsAgoString + " a " + todayString);
//
//    // Cria relatório, chama método para preencher relatório e popula a tableview
//    Date todayDate = Date.from(today.atZone(ZoneId.systemDefault()).toInstant());
//    Date twelveMonthsAgoDate = Date.from(twelveMonthsAgo.atZone(ZoneId.systemDefault()).toInstant());
//
//    Report report = new Report(twelveMonthsAgoDate, todayDate, "CustomersHighVolume");
//
//    ArrayList<Customer> customersArrayList = report.customersHighVolume(1.03);
//    // Se o método passar a exigir data, é só indicar twelveMonthsAgoDate, todayDate como argumentos.
//    if (customersArrayList != null  && !customersArrayList.isEmpty()) {
//      ArrayList<Customer> customersListArrayList = new ArrayList<>();
//      for (Customer customer : customersArrayList) {
//        Customer item = new Customer(customer);
//        customersListArrayList.add(item);
//      }
//      ObservableList<Customer> list = FXCollections.observableArrayList(customersListArrayList);
//      nameColumnn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
//      identifierNumberColumnn.setCellValueFactory(new PropertyValueFactory<Customer, String>("identifierNumber"));
//      identifierTypeColumnn.setCellValueFactory(new PropertyValueFactory<Customer, String>("identifierType"));
//      signUpDateColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("signUpDate"));
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