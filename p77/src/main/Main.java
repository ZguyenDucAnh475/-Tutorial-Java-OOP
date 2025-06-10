/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.FileController;
import view.ConsoleView;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        FileController controller = new FileController(view);
        controller.run();
    }
}
