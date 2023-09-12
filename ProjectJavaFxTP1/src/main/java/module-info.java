module com.application.projectjavafx {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  requires com.dlsc.formsfx;
  requires validatorfx;
  requires spring.boot;
  requires spring.boot.autoconfigure;
  requires spring.beans;
  requires spring.context;
  requires spring.core;
  requires net.rgielen.fxweaver.core;
  requires javafx.weaver.spring.boot.starter;
  requires org.controlsfx.controls;
  requires java.desktop;

  opens com.application.projectjavafx to javafx.fxml;
  exports com.application.projectjavafx;
  exports com.application.projectjavafx.controllers;
  exports com.application.projectjavafx.models;
  exports com.application.projectjavafx.screenControllers;
  opens com.application.projectjavafx.screenControllers to javafx.fxml;
  exports com.application.projectjavafx.events;
  opens com.application.projectjavafx.events to javafx.fxml;
}
