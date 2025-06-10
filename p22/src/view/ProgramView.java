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

    private String s1 = " ===================== ";

    public void printView(String title) {
        System.out.println(s1 + title + s1);
    }

    public void printMenu() {
        printView("candidate management system".toUpperCase());
        String menu[] = {"Experince", "Fresher", "Internship",
            "Searching", "Exit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }

    public void printFullName(String firstName, String lastName) {
        String full = firstName + " " + lastName;
        System.out.println(full);
    }

    public void printResult(String format, Object... in) {
        System.out.println(String.format(format, in));
    }
}
