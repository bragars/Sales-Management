package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.Employee;
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

public class SellersLowPerformanceController implements ControlledScreen {
  ScreenController controller;

  @FXML
  private Stage stage;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private TableView<Employee> tableView;

  @FXML
  private TableColumn<Employee, String> signUpDateColumn;

  @FXML
  private TableColumn<Employee, String> nameColumnn;

  @FXML
  private TableColumn<Employee, String> identifierNumberColumnn;

  @FXML
  private TableColumn<Employee, String> seniorityColumn;

  @FXML
  private TableColumn<Employee, Double> ammountColumn;

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
//    LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3);
//    String todayString = today.format(formatter);
//    String threeMonthsAgoString = threeMonthsAgo.format(formatter);
//    labelTimeframe.setText(threeMonthsAgoString + " a " + todayString);
//
//    // Cria relatório, chama método para preencher relatório e popula a tableview
//    Date todayDate = Date.from(today.atZone(ZoneId.systemDefault()).toInstant());
//    Date threeMonthsAgoDate = Date.from(threeMonthsAgo.atZone(ZoneId.systemDefault()).toInstant());
//
//    Report report = new Report(threeMonthsAgoDate, todayDate, "SellersLowPerformance");
//
//    ArrayList<Employee> employeesArrayList = report.sellersLowPerformance(1.2);
//    //Caso o método de Report (acima) passe a exigir from e to (além de threshold), é só passar todayDate e threeMonthsAgoDate, que já estão no formato
//    if (employeesArrayList != null  && !employeesArrayList.isEmpty()) {
//      ArrayList<Employee> sellersListArrayList = new ArrayList<>();
//      for (Employee employee : employeesArrayList) {
//        Employee item = new Employee(employee);
//        sellersListArrayList.add(item);
//      }
//      ObservableList<Employee> list = FXCollections.observableArrayList(sellersListArrayList);
//      signUpDateColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("signUpDate"));
//      nameColumnn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
//      identifierNumberColumnn.setCellValueFactory(new PropertyValueFactory<Employee, String>("identifierNumber"));
//      seniorityColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("seniority"));
//      ammountColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("ammount"));
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