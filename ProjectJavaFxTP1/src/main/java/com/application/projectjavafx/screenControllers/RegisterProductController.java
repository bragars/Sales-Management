package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.models.Supplier;
import com.application.projectjavafx.models.Product;
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

import static com.application.projectjavafx.controllers.Products.products;
import static com.application.projectjavafx.controllers.Suppliers.suppliers;

@Component
@FxmlView("registerProducts.fxml")
public class RegisterProductController implements ControlledScreen, Initializable {
  ScreenController controller;

  @FXML
  public TableView<Product> tableView;

  @FXML
  public TableColumn<Product, String> nameColumn;

  @FXML
  public TableColumn<Product, String> descriptionColumn;

  @FXML
  public TableColumn<Product, String> minPriceColumn;

  @FXML
  public TableColumn<Product, String> sugestedPriceColumn;

  @FXML
  public TableColumn<Product, String> stockQuantityColumn;

  @FXML
  public TableColumn<Product, String> supplierColumn;

  @FXML
  public TextField name;

  @FXML
  private TextField description;

  @FXML
  private TextField minPrice;

  @FXML
  private TextField sugestedPrice;

  @FXML
  private TextField stockQuantity;

  @FXML
  private ChoiceBox<Supplier> choiceBox;

  private ObservableList<Product> observableListProducts;
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
  protected Product selectedProduct() {
    return tableView.getSelectionModel().getSelectedItem();
  }

  @FXML
  protected void setTableView() {
    observableListProducts = FXCollections.observableArrayList(products);
    tableView.setItems(observableListProducts);
  }

  private void setSuppliers() {
    observableListSuppliers = FXCollections.observableArrayList(suppliers);
    choiceBox.getItems().setAll(observableListSuppliers);

    if (observableListSuppliers.size() != 0) {
      choiceBox.setConverter(new StringConverter<>() {
        @Override
        public String toString(Supplier product) {
          if (product != null)
            return product.getName();
          else return "";
        }
        @Override
        public Supplier fromString(String s) {
          return null ;
        }
      });
    }
  }

  @FXML
  protected void refreshTableView() {
    observableListProducts = FXCollections.observableArrayList(products);
    tableView.setItems(observableListProducts);
    tableView.refresh();
  }

  @FXML
  protected void cleanFields() {
    name.setText("");
    description.setText("");
    minPrice.setText("");
    sugestedPrice.setText("");
    stockQuantity.setText("");
  }

  @FXML
  protected void newProduct() {
    cleanFields();
  }

  protected Product search(String name) {
    boolean exist = false;
    Product product = null;
    for(int index = 0; index < products.size(); index++){
      if(products.get(index).getName().equals(name)) {
        exist = true;
        product = products.get(index);
      }
    }
    if (exist)
      return product;
    else
      return null;
  }

  @FXML
  protected void searchProduct() {
    Product product = search(name.getText());

    if (product != null) {
      System.out.println(product.getName());
      ArrayList<Product> searchAbleProduct = new ArrayList<>();
      searchAbleProduct.add(product);
      observableListProducts = FXCollections.observableArrayList(searchAbleProduct);
      tableView.setItems(observableListProducts);
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

  public Product editFields(Product product) {
    product.setName(name.getText());
    product.setDescription(description.getText());
    product.setMinPrice(Double.parseDouble(minPrice.getText()));
    product.setSuggestedPrice(Double.parseDouble(sugestedPrice.getText()));
    product.setStock(Integer.parseInt(stockQuantity.getText()));

    return product;
  }

  @FXML
  protected void editProduct() {
    Product product = selectedProduct();
    product = editFields(product);
    int index = products.indexOf(product);
    products.set(index, product);

    refreshTableView();
  }

  @FXML
  protected void removeProduct() {
    Product product = selectedProduct();
    tableView.getItems().remove(product);
    products.remove(product);

//    Image image = new Image("ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);
    Notifications notifications = Notifications.create();
    notifications.title("Operação efetuada com sucesso !");
    notifications.text("Cliente removido \" + product.getName()");
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
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    minPriceColumn.setCellValueFactory(new PropertyValueFactory<>("minPrice"));
    sugestedPriceColumn.setCellValueFactory(new PropertyValueFactory<>("suggestedPrice"));
    stockQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
    supplierColumn.setCellValueFactory(
            cellData -> {
              SimpleObjectProperty property = new SimpleObjectProperty();
              property.setValue(cellData.getValue().getSupplier().getName());
              return property;
            }
    );

    Product product = new Product(
            0,
            description.getText(),
            name.getText(),
            Double.parseDouble(minPrice.getText()),
            Double.parseDouble(sugestedPrice.getText()),
            choiceBox.getValue(),
            Integer.parseInt(stockQuantity.getText())
    );
    products.add(product);

    observableListProducts = FXCollections.observableArrayList(products);
    tableView.setItems(observableListProducts);

    setSuppliers();

//    Image image = new Image("C:\\Users\\pedro\\IdeaProjects\\ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);
    Notifications notifications = Notifications.create();
    notifications.title("Cliente criado com sucesso");
    notifications.text("Cliente" + " " + name.getText() + " " + "adicionado");
    notifications.hideAfter(Duration.seconds(2));
//    notifications.graphic(new ImageView(image));
    notifications.show();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setSuppliers();
    setTableView();
  }
}
