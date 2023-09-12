package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.controllers.Customers;
import com.application.projectjavafx.models.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.Notifications;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@FxmlView("registerClients.fxml")
public class RegisterClientController implements ControlledScreen {
  ScreenController controller;

  @FXML
  public TableView<Customer> tableView;

  @FXML
  public TableColumn<Customer, String> nameColumn;

  @FXML
  public TableColumn<Customer, String> identificationColumn;

  @FXML
  public TableColumn<Customer, String> typeColumn;

  @FXML
  public TableColumn<Customer, String> registerDateColumn;

  @FXML
  public TextField name;

  @FXML
  private TextField identificationNumber;

  @FXML
  private DatePicker registerDate;

  @FXML
  private RadioButton CPF;

  private Customers customers = new Customers();
  private ObservableList<Customer> observableListCustomers;
  boolean selectedCPF;

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

  @FXML
  protected void clickLinkSair() {
    controller.setScreen(JavaFxApplication.signInScreenId);
  }

  @FXML
  protected void clickLinkVoltar() {
    controller.setScreen(JavaFxApplication.homeScreenId);
  }

  @FXML
  protected Customer selectedCustomer() {
    return tableView.getSelectionModel().getSelectedItem();
  }

  @FXML
  protected void refreshTableView() {
    observableListCustomers = FXCollections.observableArrayList(customers.customers);
    tableView.setItems(observableListCustomers);
    tableView.refresh();
  }

  @FXML
  protected void cleanFields() {
    name.setText("");
    identificationNumber.setText("");
    registerDate.setValue(null);
//    identificationType.setText("");
  }

  @FXML
  protected void setCNPJ() {
    selectedCPF = false;
  }

  @FXML
  protected void setCPF() {
    selectedCPF = true;
  }

  @FXML
  protected void newCustomer() {
    cleanFields();
  }

  @FXML
  protected void searchCustomer() {
    Customer customer = customers.searchCustomer(name.getText());

    if (customer != null) {
      System.out.println(customer.getName());
      ArrayList <Customer> searchAbleCustomer = new ArrayList<>();
      searchAbleCustomer.add(customer);
      observableListCustomers = FXCollections.observableArrayList(searchAbleCustomer);
      tableView.setItems(observableListCustomers);
      tableView.refresh();
    }
    else {
//      Image image = new Image("ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\error-image.png",  70, 70, false, false);
      Notifications notifications = Notifications.create();
      notifications.title("Operação não efetuada !");
      notifications.text("Cliente não encontrado");
      notifications.hideAfter(Duration.seconds(2));
//      notifications.graphic(new ImageView(image));
      notifications.show();
    }
  }

  public Customer editFields(Customer customer) {
    customer.setName(name.getText());
    customer.setSignUpDate(registerDate.getValue());
    customer.setIdentifierNumber(identificationNumber.getText());
    if (CPF.isSelected())
      customer.setIdentifierType("CPF");
    else
      customer.setIdentifierType("CNPJ");
    return customer;
  }

  @FXML
  protected void editCustomer() {
    Customer customer = selectedCustomer();
    customer = editFields(customer);
    int index = customers.customers.indexOf(customer);
    customers.customers.set(index, customer);

    refreshTableView();
  }

  @FXML
  protected void removeCustomer() {
    Customer customer = selectedCustomer();
    tableView.getItems().remove(customer);
    customers.remove(customer);
//    Image image = new Image("ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);
    Notifications notifications = Notifications.create();
    notifications.title("Operação efetuada com sucesso !");
    notifications.text("Cliente removido \" + customer.getName()");
    notifications.hideAfter(Duration.seconds(2));
//    notifications.graphic(new ImageView(image));
    notifications.show();
  }

  @FXML
  protected void clearSearch() {
    cleanFields();
    refreshTableView();
  }

  @FXML
  protected void clickLinkSalvar() {
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    identificationColumn.setCellValueFactory(new PropertyValueFactory<>("identifierNumber"));
    typeColumn.setCellValueFactory(new PropertyValueFactory<>("identifierType"));
    registerDateColumn.setCellValueFactory(new PropertyValueFactory<>("signUpDate"));

    Customer customer;
    if (CPF.isSelected())
      customer = new Customer(0, registerDate.getValue(), name.getText(), identificationNumber.getText(), "CPF");
    else
      customer = new Customer(0, registerDate.getValue(), name.getText(), identificationNumber.getText(), "CNPJ");

    customers.addCustomer(customer);

    observableListCustomers = FXCollections.observableArrayList(customers.customers);
    tableView.setItems(observableListCustomers);

//    Image image = new Image("ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);
    Notifications notifications = Notifications.create();
    notifications.title("Cliente criado com sucesso");
    notifications.text("Cliente" + " " + name.getText() + " " + "adicionado");
    notifications.hideAfter(Duration.seconds(2));
//    notifications.graphic(new ImageView(image));
    notifications.show();
  }
}
