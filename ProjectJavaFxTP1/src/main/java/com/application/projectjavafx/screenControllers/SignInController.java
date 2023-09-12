package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.JavaFxApplication;
import com.application.projectjavafx.events.UserEvent;
import com.application.projectjavafx.models.User;
import com.application.projectjavafx.controllers.Users;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.springframework.stereotype.Component;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.Notifications;
import java.io.IOException;

@Component
@FxmlView("sign-in.fxml")
public class SignInController implements ControlledScreen {
  ScreenController controller;

  @FXML
  public TextField cpf;
  @FXML
  private TextField password;

  @Override
  public void setScreenParent(ScreenController screenParent) {
    controller = screenParent;
  }

  @FXML
  protected void SignIn() throws IOException {
    User user = Users.getUsers().get(0);
    if (user.getIdentifierNumber().equals(cpf.getText()) && user.getPassword().equals(password.getText())) {
      UserEvent event = new UserEvent(UserEvent.LOGIN_SUCCEEDED);
//      Image image = new Image("ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\ok-image.png",  70, 70, false, false);

      Notifications notifications = Notifications.create();
      notifications.title("Acesso Authorizado");
      notifications.text("Sucesso no Login");
      notifications.hideAfter(Duration.seconds(2));
//      notifications.graphic(new ImageView(image));
      notifications.show();

      controller.setScreen(JavaFxApplication.homeScreenId);
    }
    else {
      UserEvent event = new UserEvent(UserEvent.LOGIN_FAILED);
      controller.getScreen(JavaFxApplication.signInScreenId).fireEvent(event);

//      Image image = new Image("ProjectJavaFx\\src\\main\\java\\com\\application\\projectjavafx\\images\\error-image.png",  70, 70, false, false);

      Notifications notifications = Notifications.create();
      notifications.title("Acesso Não Authorizado");
      notifications.text("Tente Novamente");
      notifications.hideAfter(Duration.seconds(2));
//      notifications.graphic(new ImageView(image));
      notifications.show();
    }
  }
}
