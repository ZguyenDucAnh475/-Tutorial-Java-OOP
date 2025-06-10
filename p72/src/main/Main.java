/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.ProgramController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private ProgramController controller = new ProgramController();

    private void run() {
        controller.generateDB();
        //controller.display();
        controller.loginTask();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main().run();
    }

}
