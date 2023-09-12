package com.application.projectjavafx;

import com.application.projectjavafx.controllers.Employees;
import com.application.projectjavafx.controllers.Managers;
import com.application.projectjavafx.models.Employee;
import com.application.projectjavafx.models.Manager;
import com.application.projectjavafx.models.User;
import com.application.projectjavafx.controllers.Users;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    User user = new Employee(0, "CPF", "000.000.000-00", LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())), "user@user.com", "user", "123456789", "junior", "exp");
    Users users = new Users();
    users.addUser(user);
    Employees employees = new Employees();
    employees.addEmployee((Employee) user);

    javafx.application.Application.launch(JavaFxApplication.class, args);
  }
}
