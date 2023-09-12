package com.application.projectjavafx.controllers;

import com.application.projectjavafx.models.User;
import java.util.ArrayList;

public class Users {
  public static ArrayList<User> users = new ArrayList<>();

  public static ArrayList<User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    users.add(user);
  }
}
