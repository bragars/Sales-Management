package com.application.projectjavafx;


import com.application.projectjavafx.screenControllers.ScreenController;
import com.application.projectjavafx.screenControllers.SignInController;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplication extends javafx.application.Application {
  private ConfigurableApplicationContext applicationContext;

  public static String signInScreen   = "sign-in.fxml";
  public static String signInScreenId = "sign-in";
  public static String homeScreen     = "home.fxml";
  public static String homeScreenId   = "home";

  public static String clientScreen     = "register/registerClients.fxml";
  public static String clientScreenId   = "register/registerClients";
  public static String supplierScreen     = "register/registerSuppliers.fxml";
  public static String supplierScreenId   = "register/registerSuppliers";
  public static String productScreen     = "register/registerProducts.fxml";
  public static String productScreenId   = "register/registerProducts";
  public static String employeeScreen     = "register/registerEmployees.fxml";
  public static String employeeScreenId   = "register/registerEmployees";
  public static String managerScreen     = "register/registerManagers.fxml";
  public static String managerScreenId   = "register/registerManagers";

  public static String purchasesTimeFrame     = "reports/purchasesTimeFrame.fxml";
  public static String purchasesTimeFrameId   = "reports/purchasesTimeFrame";
  public static String salesTimeFrame     = "reports/salesTimeFrame.fxml";
  public static String salesTimeFrameId   = "reports/salesTimeFrame";

  public static String customersHighVolume     = "reports/customersHighVolume.fxml";
  public static String customersHighVolumeId   = "reports/customersHighVolume";
  public static String customersInactiveTimeframe     = "reports/customersInactiveTimeframe.fxml";
  public static String customersInactiveTimeframeId   = "reports/customersInactiveTimeframe";

  public static String productsLowStock     = "reports/productsLowStock.fxml";
  public static String productsLowStockId   = "reports/productsLowStock";
  public static String productsNotSoldTimeframe     = "reports/productsNotSoldTimeframe.fxml";
  public static String productsNotSoldTimeframeId   = "reports/productsNotSoldTimeframe";

  public static String sellersHighPerformance     = "reports/sellersHighPerformance.fxml";
  public static String sellersHighPerformanceId   = "reports/sellersHighPerformance";
  public static String sellersLowPerformance     = "reports/sellersLowPerformance.fxml";
  public static String sellersLowPerformanceId   = "reports/sellersLowPerformance";
  public static String suppliersHighVolume     = "reports/suppliersHighVolume.fxml";
  public static String suppliersHighVolumeId   = "reports/suppliersHighVolume";
  public static String suppliersLowVolume     = "reports/suppliersLowVolume.fxml";
  public static String suppliersLowVolumeId   = "reports/suppliersLowVolume";
  public static String buyOperation     = "reports/buyOperation.fxml";
  public static String buyOperationId   = "reports/buyOperation";

  public static String sellOperation     = "reports/sellOperation.fxml";
  public static String sellOperationId   = "reports/sellOperation";

  @Override
  public void init() {
    String[] args = getParameters().getRaw().toArray(new String[0]);

    this.applicationContext = new SpringApplicationBuilder()
            .sources(SignInController.class)
            .run(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    ScreenController mainScreenController = new ScreenController();
    mainScreenController.loadScreen(signInScreenId, signInScreen);
    mainScreenController.loadScreen(homeScreenId, homeScreen);

    mainScreenController.loadScreen(clientScreenId, clientScreen);
    mainScreenController.loadScreen(supplierScreenId, supplierScreen);
    mainScreenController.loadScreen(productScreenId, productScreen);
    mainScreenController.loadScreen(employeeScreenId, employeeScreen);
    mainScreenController.loadScreen(managerScreenId, managerScreen);

    mainScreenController.loadScreen(buyOperationId, buyOperation);
    mainScreenController.loadScreen(sellOperationId, sellOperation);

    mainScreenController.loadScreen(purchasesTimeFrameId, purchasesTimeFrame);
    mainScreenController.loadScreen(salesTimeFrameId, salesTimeFrame);
    mainScreenController.loadScreen(customersHighVolumeId, customersHighVolume);
    mainScreenController.loadScreen(customersInactiveTimeframeId, customersInactiveTimeframe);
    mainScreenController.loadScreen(productsLowStockId, productsLowStock);
    mainScreenController.loadScreen(productsNotSoldTimeframeId, productsNotSoldTimeframe);
    mainScreenController.loadScreen(sellersHighPerformanceId, sellersHighPerformance);
    mainScreenController.loadScreen(sellersLowPerformanceId, sellersLowPerformance);
    mainScreenController.loadScreen(suppliersHighVolumeId, suppliersHighVolume);
    mainScreenController.loadScreen(suppliersLowVolumeId, suppliersLowVolume);

    mainScreenController.setScreen(signInScreenId);

    Group root = new Group();
    root.getChildren().addAll(mainScreenController);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() {
    this.applicationContext.close();
    Platform.exit();
  }
}
