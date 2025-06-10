/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class LoginView {

    private String symbol_01 = " ---------------- ";
    private String symbol_02 = " ================ ";

    public void printTitle(String format, Object... in) {
        System.out.println(String.format(format, in));
    }

    public void printMenu() {
        printTitle(symbol_02 + "%s" + symbol_02, "Login Program");
        String[] menu = {"Vietnamese", "English", "Exit"};
        int menuSize = menu.length;
        int i;
        for (i = 0; i < menuSize; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }

    }
}
