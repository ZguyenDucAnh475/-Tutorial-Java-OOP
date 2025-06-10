/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class WorkerView {

    private String addView = "Add Worker";
    private String upORdownView = "Up/Down Salary";
    private String displayInfoView = "Display Information Salary";
    private String s1 = " ========= ";
    private String s2 = " --------- ";

    public String getAddView() {
        return addView;
    }

    public String getUpORdownView() {
        return upORdownView;
    }

    public String getDisplayInfoView() {
        return displayInfoView;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public void printTitleMenu(String title) {
        System.out.println(s1 + title + s1);
    }

    public void printTitle(String title) {
        System.out.println(s2 + title + s2);
    }

    public void printMenu() {
        String menu[] = {addView, upORdownView, displayInfoView, "Exit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, menu[i]));
        }
    }
    
    public void displayInfoSalary(){
        System.out.println(String.format("%-15s%-15s%-15s%-15s",
                "Code","Salary","Status","Date"));
    }
}
