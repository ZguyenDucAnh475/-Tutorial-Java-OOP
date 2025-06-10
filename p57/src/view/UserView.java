/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class UserView {

    private String symbol_01 = " ============= ";

    public void printView(String format, Object... in) {
        System.out.println(String.format(format, in));
    }

    public void printMenuView() {
        printView(symbol_01 + "%s" + symbol_01, "user management system".toUpperCase());
        String menu[] = {"Create a new account", "Login system", "Exit"};
        int menuLength = menu.length;

        for (int i = 0; i < menuLength; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }
}
