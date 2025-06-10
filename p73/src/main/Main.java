/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.ExpenseController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private ExpenseController controller = new ExpenseController();

    private void run() {
        controller.generateDB();
        while(true){
            controller.getMenu();
            int choice = controller.getChoice("Your choice: ", 1, 4);
            switch (choice) {
                case 1: // Add an expense
                    controller.addTask();
                    break;
                case 2: // Display all expenses
                    controller.displayAllExpenses();
                    break;
                case 3: // Delete an expense 
                    controller.deleteExpense("Enter ID:");
                    break;
                case 4:
                    System.out.println("Exit..");
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
