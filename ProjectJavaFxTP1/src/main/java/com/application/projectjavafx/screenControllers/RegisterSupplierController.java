package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.controllers.Suppliers;
import com.application.projectjavafx.models.Manager;
import com.application.projectjavafx.models.Supplier;
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
@FxmlView("registerSuppliers.fxml")
public class RegisterSupplierController implements ControlledScreen {
  ScreenController controller;

  @FXML
  public TableView<Supplier> tableView;

  @FXML
  public TableColumn<Supplier, String> nameColumn;

  @FXML
  public TableColumn<Supplier, String> identificationColumn;

  @FXML
  public TableColumn<Supplier, String> typeColumn;

  @FXML
  public TableColumn<Supplier, String> registerDateColumn;

  @FXML
  public TableColumn<Supplier, String> businessFieldColumn;

  @FXML
  public TableColumn<Supplier, String> businessSizeColumn;

  @FXML
  public TextField name;

  @FXML
  private TextField identificationNumber;

  @FXML
  private DatePicker registerDate;

  @FXML
  private TextField businessField;

  @FXML
  private TextField businessSize;

  @FXML
  private RadioButton CPF;

  private Suppliers suppliers = new Suppliers();
  private ObservableList<Supplier> observableListSuppliers;

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
  protected Supplier selectedSupplier() {
    return tableView.getSelectionModel().getSelectedItem();
  }
  @FXML
  protected void refreshTableView() {
    observableListSuppliers = FXCollections.observableArrayList(suppliers.suppliers);
    tableView.setItems(observableListSuppliers);
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
  protected void newSupplier() {
    cleanFields();
  }

  @FXML
  protected void searchSupplier() {
    Supplier supplier = suppliers.searchCustomer(name.getText());

    if (supplier != null) {
      System.out.println(supplier.getName());
      ArrayList <Supplier> searchAbleSupplier = new ArrayList<>();
      searchAbleSupplier.add(supplier);
      observableListSuppliers = FXCollections.observableArrayList(searchAbleSupplier);
      tableView.setItems(observableListSuppliers);
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

  public Supplier editFields(Supplier customer) {
    customer.setName(name.getText());
    customer.setSignUpDate(registerDate.getValue());
    customer.setIdentifierNumber(identificationNumber.getText());
    customer.setBusinessField(businessField.getText());
    customer.setBusinessSize(businessSize.getText());
    if (CPF.isSelected())
      customer.setIdentifierType("CPF");
    else
      customer.setIdentifierType("CNPJ");
    return customer;
  }

  @FXML
  protected void editSupplier() {
    Supplier supplier = selectedSupplier();
    supplier = editFields(supplier);
    int index = suppliers.suppliers.indexOf(supplier);
    suppliers.suppliers.set(index, supplier);

    refreshTableView();
  }

  @FXML
  protected void removeSupplier() {
    Supplier supplier = selectedSupplier();
    tableView.getItems().remove(supplier);
    suppliers.remove(supplier);

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
    typeColumn.setCellValueFactory(new PropertyValueFactory<>("identifierType"));
    registerDateColumn.setCellValueFactory(new PropertyValueFactory<>("signUpDate"));
    businessFieldColumn.setCellValueFactory(new PropertyValueFactory<>("businessField"));
    businessSizeColumn.setCellValueFactory(new PropertyValueFactory<>("businessSize"));

    Supplier supplier;
    if (CPF.isSelected())
      supplier = new Supplier(0, registerDate.getValue(), name.getText(), identificationNumber.getText(), "CPF", businessField.getText(), businessSize.getText());
    else
      supplier = new Supplier(0, registerDate.getValue(), name.getText(), identificationNumber.getText(), "CNPJ", businessField.getText(), businessSize.getText());

    suppliers.addSupplier(supplier);

    observableListSuppliers = FXCollections.observableArrayList(suppliers.suppliers);
    tableView.setItems(observableListSuppliers);

//    Image image = new Image("C:\\Users\\pedro\\IdeaProjects\\ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png", 70, 70, false, false);
    Notifications notifications = Notifications.create();
    notifications.title("Cliente criado com sucesso");
    notifications.text("Cliente" + " " + name.getText() + " " + "adicionado");
    notifications.hideAfter(Duration.seconds(2));
//    notifications.graphic(new ImageView(image));
    notifications.show();
  }
}
