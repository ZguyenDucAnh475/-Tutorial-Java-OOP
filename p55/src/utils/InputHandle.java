/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {

    private Scanner scanner = new Scanner(System.in);

    // ---------------------------------- INPUT HANDLE ----------------------------------
    public String CodeValidate(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "DOC \\d+";
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be empty!");
                continue;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);

            if (matcher.matches()) {
                return value;
            } else {
                System.err.println("Invalid Format! re-input (ex: DOC 1): ");
            }
        }
    }

    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be empty!");
            } else {
                return value;
            }
        }
    }

    public int getInt(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be empty!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);

                if (number <= 0) {
                    System.err.println("Value must be non-negative");
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.err.println("Input must be an integer!");
            }

        }
    }

    public int getuserLimit(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be empty!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);

                if (number <= 0) {
                    System.err.println("Value must be non-negative");
                    continue;
                }

                if (number < min || number > max) {
                    System.err.println(String.format("Number must from %d to %d",
                            min, max));
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.err.println("Input must be an integer!");
            }

        }
    }

    // ---------------------------------- CHECKING HANDLE ----------------------------------
    public boolean checkYN(String msg){
        while (true) {            
            System.out.print(msg);
            String value = scanner.nextLine().trim();
            
            if(value.isEmpty()){
                System.err.println("This value cannot empty!");
                continue;
            }
            
            if(value.equalsIgnoreCase("y")){
                return true;
            }
            
            if(value.equalsIgnoreCase("n")){
                return false;
            }
            
            System.err.println("Please input 'y' or 'n'! ");
        }
    }
}
