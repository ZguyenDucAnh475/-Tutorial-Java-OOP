/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class ExpenseView {

    private String title = "Handy Expense Program";
    private String addView = "Add an expense";
    private String displayView = "Display all expenses";
    private String delView = "Delete an expense";
    private String symbol01 = " ------------- ";
    private String symbol02 = " ========== ";

    public String getTitle() {
        return title;
    }

    public String getAddView() {
        return addView;
    }

    public String getDisplayView() {
        return displayView;
    }

    public String getDelView() {
        return delView;
    }

    public String getSymbol01() {
        return symbol01;
    }

    public String getSymbol02() {
        return symbol02;
    }

    public void printMenu() {
        System.out.println(symbol02 + title + symbol02);
        String menu[] = {addView, displayView, delView, "Quit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }

    public void printResult() {
        System.out.println(symbol01 + displayView + symbol01);
        System.out.println(String.format("%-5s%-20s%-15s%-15s",
                "ID","Date","Amount","Content"));
    }
}
