/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.FileController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private FileController fileController = new FileController();

    private void run() {
        while (true) {
            fileController.getMenu();
            int choice = fileController.getChoice("Please choice one option: ",
                    1, 6);
            switch (choice) {
                case 1:
                    fileController.checkPath();
                    break;
                case 2:
                    fileController.getFileNameWithTypeJava();
                    break;
                case 3:
                    fileController.getFileWithSizeThanInput();
                    break;
                case 4:
                    fileController.writeMoreContentToFile();
                    break;
                case 5:
                    fileController.readFileAndCountCharacters();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().run();
    }

}
