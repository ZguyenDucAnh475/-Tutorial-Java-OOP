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

    private String symbol_01 = " ========== ";
    private String symbol_02 = " ---------- ";

    private void printTitleMenuView(String format, Object... in) {
        System.out.println(String.format(symbol_01 + format + symbol_01,
                in));
    }

    public void printTitleView(String format, Object... in) {
        System.out.println(String.format(symbol_02 + format + symbol_02,
                in));
    }

    public void printMenuView() {
        printTitleMenuView("%s", "File Processing");
        String[] menu = {"Find person info", "Copy Text to new file",
            "Exit"};

        int menuLength = menu.length;

        for (int i = 0; i < menuLength; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }

    public void printResult() {
        printTitleView("%s", "Result");
        System.out.println(String.format("%-15s%-15s%-15s",
                "Name", "Address", "Money"));
    }
}
