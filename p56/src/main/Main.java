/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.WorkerController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private WorkerController workerController = new WorkerController();

    private void run() {
        while (true) {
            workerController.getMenu();
            int choice = workerController.getChoice(1, 5);
            if (workerController.isWorkerListEmpty() && (choice != 1) && (choice != 4)) {
                System.err.println("Your list is EMPTY!");
                continue;
            }
            switch (choice) {
                case 1: // add
                    workerController.addWorkerTask();
                    break;
                case 2: // up/down
                    workerController.editSalaryTask();
                    break;
                case 3: // display info
                    workerController.displayInfoSalary();
                    break;
                case 4:
                    System.out.println("Exiting..");
                    return;
                case 5:
                    workerController.displayWorkerList();
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
