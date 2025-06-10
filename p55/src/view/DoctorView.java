/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class DoctorView {

    private String manageView = "Doctor Management";
    private String addView = "Add Doctor";
    private String updateView = "Update Doctor";
    private String delView = "Delete Doctor";
    private String searchView = "Search Doctor";
    private String resultView = "Result";
    private String symbol01 = " ========= ";
    private String symbol02 = " --------- ";

    public String getAddView() {
        return addView;
    }

    public String getUpdateView() {
        return updateView;
    }

    public String getDelView() {
        return delView;
    }

    public String getSearchView() {
        return searchView;
    }

    public String getSymbol02() {
        return symbol02;
    }

    public void displayDoctorMenu() {
        System.out.println(symbol01 + manageView + symbol01);
        String menu[] = {addView, updateView, delView, searchView, "Exit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s", i + 1, menu[i]));
        }
    }

    public void printResultView(){
        String out = String.format("%-10s%-15s%-20s%-15s","Code","Name",
                "Specialization","Availability");
        System.out.println(out);
    }
    
    public void printTitleView(String title) {
        System.out.println(symbol02 + title + symbol02);
    }
    
    public void printUpdateView(String msg){
        System.out.println(String.format("Update %s successfull!", msg));
    }

}
