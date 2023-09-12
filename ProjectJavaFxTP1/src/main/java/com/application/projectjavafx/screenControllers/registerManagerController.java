package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.controllers.Managers;
import com.application.projectjavafx.models.Employee;
import com.application.projectjavafx.models.Manager;
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
@FxmlView("registerManagers.fxml")
public class registerManagerController implements ControlledScreen {
  ScreenController controller;

  @FXML
  public TableView<Manager> tableView;

  @FXML
  public TableColumn<Manager, String> nameColumn;

  @FXML
  public TableColumn<Manager, String> identificationColumn;

  @FXML
  public TableColumn<Manager, String> typeColumn;

  @FXML
  public TableColumn<Manager, String> typeOfIdentifierColumn;

  @FXML
  public TableColumn<Manager, String> registerDateColumn;

  @FXML
  public TableColumn<Manager, String> seniorityColumn;

  @FXML
  public TextField name;

  @FXML
  public RadioButton CPF;

  @FXML
  private TextField identificationNumber;

  @FXML
  private DatePicker registerDate;

  @FXML
  private TextField email;

  @FXML
  private TextField password;

  @FXML
  private TextField type;

  @FXML

  private Managers managers = new Managers();
  private ObservableList<Manager> observableListManagers;
  private ObservableList<Employee> observableListEmployees;

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
  protected Manager selectedManager() {
    return tableView.getSelectionModel().getSelectedItem();
  }

  @FXML
  protected void refreshTableView() {
    observableListManagers = FXCollections.observableArrayList(managers.managers);
    tableView.setItems(observableListManagers);
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
  protected void setTableView() {

  }

  @FXML
  protected void newManager() {
    cleanFields();
  }

  @FXML
  protected void searchManager() {
    Manager employee = managers.searchManager(name.getText());

    if (employee != null) {
      System.out.println(employee.getName());
      ArrayList<Manager> searchAbleManager = new ArrayList<>();
      searchAbleManager.add(employee);
      observableListManagers = FXCollections.observableArrayList(searchAbleManager);
      tableView.setItems(observableListManagers);
      tableView.refresh();
    }
    else {
//      Image image = new Image("C:\\Users\\pedro\\IdeaProjects\\ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\error-image.png",  70, 70, false, false);
      Notifications notifications = Notifications.create();
      notifications.title("Operação não efetuada !");
      notifications.text("Cliente não encontrado");
      notifications.hideAfter(Duration.seconds(2));
//      notifications.graphic(new ImageView(image));
      notifications.show();
    }
  }

  public Manager editFields(Manager manager) {
    manager.setName(name.getText());
    manager.setSignUpDate(registerDate.getValue());
    manager.setIdentifierNumber(identificationNumber.getText());
    if (CPF.isSelected())
      manager.setIdentifierType("CPF");
    else
      manager.setIdentifierType("CNPJ");
    return manager;
  }

  @FXML
  protected void editManager() {
    Manager employee = selectedManager();
    employee = editFields(employee);
    int index = managers.managers.indexOf(employee);
    managers.managers.set(index, employee);

    refreshTableView();
  }

  @FXML
  protected void removeManager() {
    Manager employee = selectedManager();
    tableView.getItems().remove(employee);
    managers.remove(employee);

//    Image image = new Image("C:\\Users\\pedro\\IdeaProjects\\ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);
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
    typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
    typeOfIdentifierColumn.setCellValueFactory(new PropertyValueFactory<>("identifierType"));
    registerDateColumn.setCellValueFactory(new PropertyValueFactory<>("signUpDate"));

    Manager manager;
    if (CPF.isSelected())
      manager = new Manager(0, "CPF", identificationNumber.getText(), registerDate.getValue(), email.getText(), name.getText(), password.getText(), type.getText());
    else
      manager = new Manager(0, "CNPJ", identificationNumber.getText(), registerDate.getValue(), email.getText(), name.getText(), password.getText(), type.getText());

    managers.addManager(manager);

    observableListManagers = FXCollections.observableArrayList(managers.managers);
    tableView.setItems(observableListManagers);

//    setEmployees();

//    Image image = new Image("C:\\Users\\pedro\\IdeaProjects\\ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);
    Notifications notifications = Notifications.create();
    notifications.title("Cliente criado com sucesso");
    notifications.text("Cliente" + " " + name.getText() + " " + "adicionado");
    notifications.hideAfter(Duration.seconds(2));
//    notifications.graphic(new ImageView(image));
    notifications.show();
  }
}
