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

    private String symbol_01 = " ------------------------ ";
    private String symbol_02 = " ======================== ";

    private void printMenuTitle(String title) {
        System.out.println(symbol_02 + title + symbol_02);
    }

    public void printMenuView() {
        printMenuTitle("File processing");
        String menu[] = {"Check Path", "Get file name with type java",
            "Get file with size greater than input", "Write more content to file",
            "Read file and count characters", "Exit"};

        int menuSize = menu.length;

        for (int i = 0; i < menuSize; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }

    public void printViewTitle(String in) {
        System.out.println(String.format(symbol_01 + "%s" + symbol_01, in));
    }

    public void printResult(String type, String format, Object... in) {
        if (type.equals("out")) {
            System.out.println(String.format(format, in));
        }
        
        if (type.equals("err")) {
            System.err.println(String.format(format, in));
        }
    }

}
