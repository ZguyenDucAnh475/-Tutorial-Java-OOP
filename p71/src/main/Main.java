/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.TaskController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private TaskController taskController = new TaskController();

    private void run() {
        while (true) {
            taskController.getMenu();
            int choice = taskController.getChoice(1, 4);
            if (taskController.isDBEmpty() && (choice != 1) && (choice != 4)) {
                System.err.println(String.format("Your DB is empty! Cannot choice %d",
                        choice));
                continue;
            }
            switch (choice) {
                case 1: // add task
                    taskController.addTask();
                    break;
                case 2: // delete task
                    taskController.deleteTask();
                    break;
                case 3: // display task
                    taskController.displayTask();
                    break;
                case 4: // exit
                    System.out.println("Exiting..");
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
