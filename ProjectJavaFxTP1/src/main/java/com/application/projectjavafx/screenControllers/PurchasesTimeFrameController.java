package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.controllers.SalesAndPurchasesList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Component
@FxmlView("purchasesTimeFrame.fxml")
public class PurchasesTimeFrameController implements ControlledScreen {
  ScreenController controller;

  @FXML
  private Stage stage;

  @FXML
  private Label invalidStartDateLabel;

  @FXML
  private Label invalidEndDateLabel;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private TableView<SalesAndPurchasesList> tableView;

  @FXML
  private TableColumn<SalesAndPurchasesList, String> dateTimeColumn;

  @FXML
  private TableColumn<SalesAndPurchasesList, String> productColumn;

  @FXML
  private TableColumn<SalesAndPurchasesList, String> supplierColumn;

  @FXML
  private TableColumn<SalesAndPurchasesList, Integer> quantityColumn;

  @FXML
  private TableColumn<SalesAndPurchasesList, Double> ammountColumn;

  @FXML
  private TextField startDateInput;

  @FXML
  private TextField endDateInput;

  @FXML
  private FXMLLoader fxmlLoader;

  @FXML
  private Scene scene;


    /*PASSEI PARA O MÉTODO DE REPORT
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date data = formato.parse("23/11/2015");

    Supplier supplier = new Supplier(1, data,"Firma do Zé", "12314", "CNPJ", "Aeronautics", "Small");
    Product product = new Product(121,"blabla","Coca-cola",1.8,2.55,100,supplier);
    Customer customer = new Customer(12131,data,"João","123123","CPF");
    Manager manager = new Manager("1231321", data, "ada@ada.com","Beltrano","ada","sales");
    Employee employee = new Employee("123123",data,"andmilhe@com","Fulano","12312","seller", manager, "senior");
    Operation operation = new Operation(123123,customer,data,employee,product,12,supplier,"sales",1.98);
    */

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

  public void initialize() {

  }

  // Especifica o formato da string para convertê-la em Date.

  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  // Cria relatório, chama método para preencher relatório e popula a tableview

  public void fillObservableList(Date from, Date to) throws ParseException {
//    Report report = new Report(from, to, "PurchasesTimeframe");
//    ArrayList<Operation> purchasesArrayList = report.getPurchasesTimeframe(from, to);
//    ArrayList<SalesAndPurchasesList> purchasesListArrayList = new ArrayList<>();
//
//    for (Operation operation : purchasesArrayList) {
//      SalesAndPurchasesList item = new SalesAndPurchasesList(operation);
//      purchasesListArrayList.add(item);
//    }
//    ObservableList<SalesAndPurchasesList> list = FXCollections.observableArrayList(purchasesListArrayList);
//    dateTimeColumn.setCellValueFactory(new PropertyValueFactory<SalesAndPurchasesList, String>("dateTime"));
//    productColumn.setCellValueFactory(new PropertyValueFactory<SalesAndPurchasesList, String>("product"));
//    supplierColumn.setCellValueFactory(new PropertyValueFactory<SalesAndPurchasesList, String>("supplier"));
//    quantityColumn.setCellValueFactory(new PropertyValueFactory<SalesAndPurchasesList, Integer>("quantity"));
//    ammountColumn.setCellValueFactory(new PropertyValueFactory<SalesAndPurchasesList, Double>("ammount"));
//    tableView.setItems(list);
  }

  // Verifica se data está no padrão dd/mm/aaaa

  public boolean isValidDate(String input) {
    String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
    Pattern pattern = Pattern.compile(regex);
    if (input == null) {
      return false;
    }
    else {
      return pattern.matcher(input).matches();
    }
  }

  // Recebe as datas do usuário, chama método que verifica se são válidas, realiza a formatação das datas
  // formata, chama o método que popula a tableview e informa ao usuário datas inválidas.

  @FXML
  public void issueReport(ActionEvent event) {
    Date formattedStartDate;
    Date formattedEndDate;
    try {
      String startDate = startDateInput.getText();
      String endDate = endDateInput.getText();
      if (isValidDate(startDate)) {
        invalidStartDateLabel.setVisible(false);
        if (isValidDate(endDate)) {
          invalidEndDateLabel.setVisible(false);
          formattedStartDate = formato.parse(startDate + " 00:00:00");
          formattedEndDate = formato.parse(endDate + " 23:59:59");
          fillObservableList(formattedStartDate,formattedEndDate);
        }
        else {
          invalidEndDateLabel.setVisible(true);
        }
      }
      else {
        invalidStartDateLabel.setVisible(true);
        if (!isValidDate(endDate)) {
          invalidEndDateLabel.setVisible(true);
        }
        else {
          invalidEndDateLabel.setVisible(false);
        }
      }
    }
    catch (ParseException e) {
      e.printStackTrace();
    }
  }

  //Limpa datas e tableview na interface

  @FXML
  public void clearDates(ActionEvent event) {
    startDateInput.setText("");
    endDateInput.setText("");
    invalidEndDateLabel.setVisible(false);
    invalidStartDateLabel.setVisible(false);
    tableView.setItems(null);
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

  @FXML
  public void backToMenu(ActionEvent event) throws IOException {
    controller.setScreen(JavaFxApplication.homeScreenId);
  }
}
