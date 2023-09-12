package com.application.projectjavafx.screenControllers;

import com.application.projectjavafx.Application;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.HashMap;

public class ScreenController extends StackPane {
  private final HashMap<String, Node> screens = new HashMap<>();

  public ScreenController() {
    super();
  }

  public Node getScreen(String name) {
    return screens.get(name);
  }
  public void addScreen(String name, Node screen) {
    screens.put(name, screen);
  }
  public boolean loadScreen(String name, String resource) throws Exception {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(resource));
      Parent loadScreen = (Parent) fxmlLoader.load();
      ControlledScreen controlledScreen = ((ControlledScreen) fxmlLoader.getController());
      controlledScreen.setScreenParent(this);
      addScreen(name, loadScreen);
      return true;
    }
    catch (Exception exception) {
      System.out.println(exception.getMessage());
      return false;
    }
  }
  public boolean setScreen(final String name) {
    if (screens.get(name) != null) {
      final DoubleProperty opacity = opacityProperty();

      if (!getChildren().isEmpty()) {
        Timeline fade = new Timeline(
          new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
          new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              getChildren().remove(0);
              getChildren().add(0, screens.get(name));
              Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(2000), new KeyValue(opacity, 1.0))
              );
              fadeIn.play();
            }
          }
          )
        );
        fade.play();
      }
      else {
        setOpacity(0.0);
        getChildren().add(screens.get(name));
        Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(2000), new KeyValue(opacity, 1.0))
        );
        fadeIn.play();
      }
    }
    return true;
  }
}
