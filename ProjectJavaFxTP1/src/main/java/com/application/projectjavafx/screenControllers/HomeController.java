package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;
import net.rgielen.fxweaver.core.FxmlView;

import static com.application.projectjavafx.JavaFxApplication.managerScreen;
import static com.application.projectjavafx.JavaFxApplication.managerScreenId;

@Component
@FxmlView("home.fxml")
public class HomeController implements ControlledScreen {
  ScreenController controller;

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

  @FXML
  public void clickLinkCadastrosClientes() {
    System.out.println("click");
    controller.setScreen(JavaFxApplication.clientScreenId);
  }

  @FXML
  protected void clickLinkSair() {
    System.out.println("clickIconeSair");
    controller.setScreen(JavaFxApplication.signInScreenId);
  }

  @FXML
  protected void clickLinkRelatoriosVendedoresDestacados() {
    controller.setScreen(JavaFxApplication.sellersHighPerformanceId);
  }

  @FXML
  protected void clickLinkRelatoriosVendedoresImprodutivos() {
    controller.setScreen(JavaFxApplication.sellersLowPerformanceId);
  }

  @FXML
  protected void clickLinkRelatoriosProdutosSemSaidas() {
    controller.setScreen(JavaFxApplication.productsNotSoldTimeframeId);
  }

  @FXML
  protected void clickLinkRelatoriosEstoquesCriticos() {
    controller.setScreen(JavaFxApplication.productsLowStockId);
  }

  @FXML
  protected void clickLinkRelatoriosFornecedoresSemSaidas() {
    controller.setScreen(JavaFxApplication.suppliersLowVolumeId);
  }

  @FXML
  protected void clickLinkRelatoriosFornecedoresDestacados() {
    controller.setScreen(JavaFxApplication.suppliersHighVolumeId);
  }

  @FXML
  protected void clickLinkRelatoriosClientesInativos() {
    controller.setScreen(JavaFxApplication.customersInactiveTimeframeId);
  }

  @FXML
  protected void clickLinkRelatoriosClientesPreferenciais() {
    controller.setScreen(JavaFxApplication.customersHighVolumeId);
  }

  @FXML
  protected void clickLinkRelatoriosVendasPeriodo() {
    System.out.println("VendasPeriodo");
    controller.setScreen(JavaFxApplication.salesTimeFrameId);
  }

  @FXML
  protected void clickLinkRelatoriosComprasPeriodo() {
    System.out.println("ComprasPeriodo");
    controller.setScreen(JavaFxApplication.purchasesTimeFrameId);
  }

  @FXML
  protected void  clickLinkOperacoesVender() {
    System.out.println("clickLinkOperacoesVender");
    controller.setScreen(JavaFxApplication.sellOperationId);
  }

  @FXML
  protected void clickLinkOperacoesComprar() {
    System.out.println("clickLinkOperacoesComprar");
    controller.setScreen(JavaFxApplication.buyOperationId);
  }

  @FXML
  protected void clickLinkCadastrosGerentes() throws Exception {
//    controller.loadScreen(managerScreenId, managerScreen);
    controller.setScreen(managerScreenId);
  }

  @FXML
  protected void clickLinkCadastrosFuncionarios() throws Exception {
    controller.loadScreen(JavaFxApplication.employeeScreenId, JavaFxApplication.employeeScreen); // executes initialize method in registerEmployeeController
    controller.setScreen(JavaFxApplication.employeeScreenId);
  }

  @FXML
  protected void clickLinkCadastrosProdutos() throws Exception {
    controller.loadScreen(JavaFxApplication.productScreenId, JavaFxApplication.productScreen); // executes initialize method in registerEmployeeController
    controller.setScreen(JavaFxApplication.productScreenId);
  }

  @FXML
  protected void clickLinkCadastrosFornecedores() {
    controller.setScreen(JavaFxApplication.supplierScreenId);
  }
}
