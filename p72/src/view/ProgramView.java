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

    private String symbol01 = " ---------------------- ";
    private String symbol02 = " ====================== ";
    private String addView = "Add User";
    private String loginView = "Login";

    public void printTitleMenu(String title) {
        System.out.println(symbol02 + title + symbol02);
    }

    public void printTitle(String title) {
        System.out.println(symbol01 + title + symbol01);
    }

    public void menuDisplay() {
        String menu[] = {addView, loginView, "Exit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }

    public void printNotice(String msg) {
        System.out.println(msg);
    }
}
