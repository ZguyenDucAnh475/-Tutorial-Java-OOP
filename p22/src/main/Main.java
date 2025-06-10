/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.CandidateController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private CandidateController candidateController = new CandidateController();

    private void run() {
        while (true) {
            candidateController.getMenu();
            int choice = candidateController.getUserChoice("Your choice: ", 1, 5);
            switch (choice) {
                case 1: // Exp
                    candidateController.runCandidateExp();
                    break;
                case 2: // Fres
                    candidateController.runCandidateFres();
                    break;
                case 3: // Intern
                    candidateController.runCandidateIntern();
                    break;
                case 4: // Searching
                    candidateController.searchCandidates();
                    break;
                case 5:
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
