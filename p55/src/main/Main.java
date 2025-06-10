/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.DoctorController;
import java.util.Scanner;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private DoctorController controller = new DoctorController();

    private void run() {
        controller.generateDB();
        while (true) {
            controller.displayDoctorMenu();
            int choice = controller.getChoice(1, 6);
//            if (controller.isDBEmpty() && (choice == 2 || choice == 3 || choice == 4)) {
//                System.err.println("Database is empty. Operation not allowed.");
//                continue;
//            }
            if (controller.isDBEmpty() && (choice != 1)) {
                System.err.println("Database is empty. Operation not allowed.");
                continue;
            }

            switch (choice) {
                case 1:
                    controller.addTask();
                    break;
                case 2:
                    controller.updateTask();
                    break;
                case 3:
                    controller.deleteDoctor();
                    break;
                case 4:
                    controller.searchTask();
                    break;
                case 5:
                    System.out.println("Exiting..");
                    return;
                case 6:
                    controller.displayList();
                    break;
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
