/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class TaskProgramView {

    private String addView = "Add Task";
    private String delView = "Delete Task";
    private String displayView = "Display Task";
    private String s1 = " -------------------- ";
    private String s2 = " ==================== ";

    public void printTitle(String title) {
        System.out.println(s1 + title + s1);
    }

    public void printTitleMenu(String title) {
        System.out.println(s2 + title + s2);
    }

    public void printMenu() {
        printTitleMenu("Task Program");
        String menu[] = {addView, delView, displayView, "Exit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }

    public void printView() {
        System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer"));
    }

}
