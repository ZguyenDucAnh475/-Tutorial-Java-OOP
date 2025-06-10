/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class HandleFileView {

    private String symbol_01 = " --------- ";
    private String symbol_02 = " ========= ";

    public void printView(String format, Object... in) {
        System.out.println(String.format(symbol_01 + format + symbol_01,
                in));
    }

    private void printTitleMenu(String format, Object... in) {
        System.out.println(String.format(symbol_02 + format + symbol_02,
                in));
    }

    public void printMenuView() {
        printTitleMenu("%s", "Format CSV Program");
        String menu[] = {"Import CSV", "Format Address",
            "Format Name", "Export CSV", "Exit"};

        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }

}
