/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Value;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class programController {

    private ProgramView view = new ProgramView();
    private Value valueString = new Value();

    // ------------------------------------------- VIEW -------------------------------------------
    public void getMenuView() {
        view.printMenu();
    }

    // ------------------------------------------- INPUT -------------------------------------------
    public int getUserLimitChoice(String msg, int min, int max) {
        return 0;
    }

    private String getValue(String msg) {
        return "";
    }

    // ------------------------------------------- SUPPORT -------------------------------------------
    private String checkTypeString(String in) {
        if (in == null || in.isEmpty()) {
            return "UNKNOWN";
        }

        in = in.trim();

        // Check for binary (only contains 0 and 1)
        if (in.matches("[01]+")) {
            return "BINARY";
        }

        // Check for hexadecimal with 0x prefix
        if (in.matches("(?i)0x[0-9a-f]+")) {
            return "HEXADECIMAL";
        }

        // Check for hexadecimal without prefix (must contain at least one A-F)
        if (in.matches("(?i)[0-9a-f]+") && in.matches(".*(?i)[a-f].*")) {
            return "HEXADECIMAL";
        }

        // Check for decimal (only digits)
        if (in.matches("\\d+")) {
            try {
                int number = Integer.parseInt(in);
                if (number >= 0) {
                    return "DECIMAL";
                }
            } catch (NumberFormatException e) {
                return "UNKNOWN";
            }
        }

        return "UNKNOWN";
    }
    
    private void calculate(String in){
        if(in.equalsIgnoreCase("binary")){
            // bin -> dec
            // bin -> hex
        }
        if(in.equalsIgnoreCase("decimal")){
            // dec -> bin
            // dec -> hex
        }
        if(in.equalsIgnoreCase("hexadecimal")){
            // hex -> bin
            // hex -> dec
        }
    }
    
    // ------------------------------------------- DISPLAY RESULT -------------------------------------------

    public void display() {
        System.out.println(String.format("This value is %s", checkTypeString(valueString.getValueInput())));
    }

}
