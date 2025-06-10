/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.ProgramController;
import java.io.File;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private ProgramController controller = new ProgramController();

    private void run() {
        //String path = "E:\\demo59\\docu.txt";
        while (true) {
            controller.getMenu();
            int choice = controller.getChoice("Your choice: ", 1, 3);
            switch (choice) {
                case 1: // Find person info
                    controller.getPerson();
                    controller.displayinfo();
                    break;
                case 2: // Copy Text to new file
                    controller.copyWordOneTimes();
                    break;
                case 3:
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
