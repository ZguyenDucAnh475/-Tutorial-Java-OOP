/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.StudentController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private StudentController studentController = new StudentController();

    private void run() {
        studentController.generateDB();
        while (true) {
            studentController.getMenu();
            int choice = studentController.getUserChoiceLimit("Your choice: ", 1, 5);
            if (studentController.isDBEmpty() && (choice != 1) && (choice != 5)) {
                System.err.printf("Your student db is empty! Cannot choose option %d!\n",choice);
                continue;
            }
            switch (choice) {
                case 1:
                    studentController.createTask();
                    break;
                case 2:
                    studentController.findStudentByNameTask();
                    break;
                case 3:
                    studentController.updateORdeleteTask();
                    break;
                case 4:
                    studentController.reportTask();
                    break;
                case 5:
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
