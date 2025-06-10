/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.UserController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private UserController userController = new UserController();

    private void run() {
        while (true) {
            userController.getMenuView();
            int choice = userController.getChoice("> Choose: ", 1, 3);
            if (userController.isListEmpty() && (choice != 1) && (choice != 3)) {
                System.err.println("Your list is empty!");
                continue;
            }
            switch (choice) {
                case 1: // create
                    userController.createTask();
                    break;
                case 2: // login
                    userController.loginTask();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main().run();
    }

}
