package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.Employee;
import com.application.projectjavafx.models.Manager;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.Notifications;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.application.projectjavafx.controllers.Managers.managers;
import static com.application.projectjavafx.controllers.Employees.employees;

@Component
@FxmlView("registerEmployees.fxml")
public class registerEmployeeController implements ControlledScreen, Initializable {
  ScreenController controller;

  @FXML
  public TableView<Employee> tableView;

  @FXML
  public TableColumn<Employee, String> nameColumn;

  @FXML
  public TableColumn<Employee, String> identificationColumn;

  @FXML
  public TableColumn<Employee, String> typeColumn;

  @FXML
  public TableColumn<Employee, String> registerDateColumn;

  @FXML
  public TableColumn<Employee, String> seniorityColumn;

  @FXML
  public TableColumn<Employee, String> managerColumn;

  @FXML
  public TableColumn<Employee, String> typeOfIdentifierColumn;

  @FXML
  public TextField name;

  @FXML
  public RadioButton CPF;

  @FXML
  private TextField identificationType;

  @FXML
  private TextField identificationNumber;

  @FXML
  private DatePicker registerDate;

  @FXML
  private TextField email;

  @FXML
  private TextField password;

  @FXML
  private TextField seniority;

  @FXML
  private TextField type;

  @FXML
  private TextField managerName;

  @FXML
  private ChoiceBox<Manager> choiceBox;

  private ObservableList<Employee> observableListEmployees;
  private ObservableList<Manager> observableListManagers;

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

//  public void setControllerFactory(Callback<java.lang.Class<?>,java.lang.Object> controllerFactory) {
//    val loader = new FXMLLoader();
//    loader.setControllerFactory(new Callback[Class[_],Object] {
//      def call(c: Class[_]): Object = {
//              // your implementation
//      }
//    });
//  }


  @FXML
  protected void clickLinkSair() {
    controller.setScreen(JavaFxApplication.signInScreenId);
  }

  @FXML
  protected void clickLinkVoltar() {
    controller.setScreen(JavaFxApplication.homeScreenId);
  }

  @FXML
  protected Employee selectedEmployee() {
    return tableView.getSelectionModel().getSelectedItem();
  }

  @FXML
  protected void refreshTableView() {
    observableListEmployees = FXCollections.observableArrayList(employees);
    tableView.setItems(observableListEmployees);
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
    observableListEmployees = FXCollections.observableArrayList(employees);
    tableView.setItems(observableListEmployees);
  }

  private void setManagers() {
    observableListManagers = FXCollections.observableArrayList(managers);
    choiceBox.getItems().setAll(observableListManagers);

    if (observableListManagers.size() != 0) {
      choiceBox.setConverter(new StringConverter<>() {
        @Override
        public String toString(Manager manager) {
           if (manager != null)
            return manager.getName();
          else return "";
        }
        @Override
        public Manager fromString(String s) {
          return null ;
        }
      });
    }
  }

  @FXML
  protected void newEmployee() {
    cleanFields();
  }

  @FXML
  protected Employee search(String name) {
      boolean exist = false;
      Employee customer = null;
      for(int index = 0; index < employees.size(); index++){
        if(employees.get(index).getName().equals(name)) {
          exist = true;
          customer = employees.get(index);
        }
      }
      if (exist)
        return customer;
      else
        return null;
  }

  @FXML
  protected void searchEmployee() {
    Employee employee = search(name.getText());

    if (employee != null) {
      System.out.println(employee.getName());
      ArrayList<Employee> searchAbleEmployee = new ArrayList<>();
      searchAbleEmployee.add(employee);
      observableListEmployees = FXCollections.observableArrayList(searchAbleEmployee);
      tableView.setItems(observableListEmployees);
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

  public Employee editFields(Employee employee) {
    employee.setName(name.getText());
    employee.setSignUpDate(registerDate.getValue());
    employee.setIdentifierNumber(identificationNumber.getText());
    employee.setType(type.getText());
    employee.setSeniority(seniority.getText());
    employee.setEmail(email.getText());
    employee.setPassword(password.getText());

    if (CPF.isSelected())
      employee.setIdentifierType("CPF");
    else
      employee.setIdentifierType("CNPJ");
    return employee;
  }

  @FXML
  protected void editEmployee() {
    Employee employee = selectedEmployee();
    employee = editFields(employee);
    int index = employees.indexOf(employee);
    employees.set(index, employee);

    refreshTableView();
  }

  @FXML
  protected void removeEmployee() {
    Employee employee = selectedEmployee();
    tableView.getItems().remove(employee);
    employees.remove(employee);

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
    typeOfIdentifierColumn.setCellValueFactory(new PropertyValueFactory<>("identifierType"));
    identificationColumn.setCellValueFactory(new PropertyValueFactory<>("identifierNumber"));
    typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
    registerDateColumn.setCellValueFactory(new PropertyValueFactory<>("signUpDate"));
    seniorityColumn.setCellValueFactory(new PropertyValueFactory<>("seniority"));
    managerColumn.setCellValueFactory(
            cellData -> {
              SimpleObjectProperty property = new SimpleObjectProperty();
              property.setValue(cellData.getValue().getManager().getName());
              return property;
            }
    );
    Employee employee;
    if (CPF.isSelected())
      employee = new Employee( 0, "CPF", identificationNumber.getText(), registerDate.getValue(), email.getText(), name.getText(), password.getText(), type.getText(), choiceBox.getValue(), seniority.getText());
    else
      employee = new Employee( 0, "CNPJ", identificationNumber.getText(), registerDate.getValue(), email.getText(), name.getText(), password.getText(), type.getText(), choiceBox.getValue(), seniority.getText());
    employees.add(employee);

    observableListEmployees = FXCollections.observableArrayList(employees);
    tableView.setItems(observableListEmployees);

    setManagers();

//    Image image = new Image("C:\\Users\\pedro\\IdeaProjects\\ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);
    Notifications notifications = Notifications.create();
    notifications.title("Cliente criado com sucesso");
    notifications.text("Cliente" + " " + this.name.getText() + " " + "adicionado");
    notifications.hideAfter(Duration.seconds(2));
//    notifications.graphic(new ImageView(image));
    notifications.show();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setManagers();
    setTableView();
  }
}
