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

    public int getUserLimitChoice(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);

                if (number <= 0) {
                    System.err.println("This number must > 0!");
                    continue;
                }

                if (number < min || number > max) {
                    System.err.println(String.format("Please input between %d and %d",
                            min, max));
                    continue;
                }

                return number;

            } catch (NumberFormatException e) {
                System.err.println("This value must integer number");
            }
        }
    }

    public boolean checkYN(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            if (value.equalsIgnoreCase("y")) {
                return true;
            }

            if (value.equalsIgnoreCase("n")) {
                return false;
            }

            System.err.println("Invalid Value! Please input Yes[Y] or No[N]:");
        }
    }

    public boolean checkUD(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            if (value.equalsIgnoreCase("u")) {
                return true;
            }

            if (value.equalsIgnoreCase("d")) {
                return false;
            }

            System.err.println("Invalid Value! Please input Update[U] or Delete[D]:");
        }
    }

    public String StudentIDValidate(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "S \\d+";
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
                System.err.println("Invalid Format! re-input (ex: S 1): ");
            }
        }
    }

    public String getNameValue(String msg) {
        while (true) {
            System.out.print(msg);
            String valueString = scanner.nextLine().trim();

            if (valueString.isEmpty()) {
                System.err.println("This content cannot be empty!");
                continue;
            } else {
                return valueString;
            }

        }
    }

}
