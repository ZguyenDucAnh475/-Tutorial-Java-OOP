/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import model.User;
import utils.InputHandle;
import view.UserView;

/**
 *
 * @author NguyenDucAnh
 */
public class UserController {

    private UserView view = new UserView();
    private InputHandle inputHandle = new InputHandle();

    private List<User> userList = new ArrayList<>();

    // --------------------------------------- VIEW ---------------------------------------
    public void getMenuView() {
        view.printMenuView();
    }

    // --------------------------------------- CREAT ---------------------------------------
    public void createTask() {
        String username = getUsername("Enter Username: ");
        while (isDuplicatedUsername(username)) {
            System.err.println("your username is duplicated!");
            username = getUsername("Enter Username: ");
        }
        String password = getPassword("Enter Password: ");

        User user = new User(username, password);
        createUserController(user);
    }

    private void createUserController(User user) {
        userList.add(user);
        System.out.println("Add successful!");
    }

    // --------------------------------------- LOGIN ---------------------------------------
    public void loginTask() {
        String username = getUsername("Enter Username: ");

        User user = findUserByUsername(username);

        while (user == null) {
            System.err.println(String.format("No user name [%s] was found!",
                    username));
            username = getUsername("Enter Username: ");
            user = findUserByUsername(username);
        }
        String password = getPassword("Enter Password: ");
        loginCotroller(user, password);
    }

    private void loginCotroller(User user, String passwordInput) {
        String oldPassword = user.getPassword();
        if (oldPassword.equals(passwordInput)) {
            System.out.println("Login successful!");
        } else {
            System.err.println("Login fail!");
        }
    }

    // --------------------------------------- SUPPORT FUNCTION ------------------------------
    private User findUserByUsername(String username) {
        for (User o : userList) {
            if (o.getUsername().equals(username)) {
                return o;
            }
        }
        return null;
    }

    private boolean isDuplicatedUsername(String username) {
        for (User o : userList) {
            if (o.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isListEmpty() {
        return userList.isEmpty();
    }

    // --------------------------------------- INPUT ---------------------------------------
    private String getUsername(String msg) {
        return inputHandle.validateUsername(msg);
    }

    private String getPassword(String msg) {
        return inputHandle.validatePassword(msg);
    }

    public int getChoice(String msg, int min, int max) {
        return inputHandle.getLimitInput(msg, min, max);
    }
}
