/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class ProgramView {

    private String s1 = " ----------------- ";
    private String s2 = " ================= ";

    public void printTitle(String in) {
        System.out.println(s1 + in + s1);
    }

    private void printMenuTitle(String in) {
        System.out.println(s2 + in + s2);
    }

    public void printMenu() {
        printMenuTitle("Ziper program");
        String[] menu = {"Compression", "Extraction",
            "Exit"};
        int menuSize = menu.length;

        for (int i = 0; i < menuSize; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }
}
