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
        fileController.importCSV();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main().run();
    }

}
