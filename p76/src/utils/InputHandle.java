/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {

    private Scanner scanner = new Scanner(System.in);

    private boolean checkRegex(String regex, String value) {
        return Pattern.matches(regex, value);
    }

    public String validateFilePath(String msg) {
        while (true) {
            System.out.print(msg);
            String regexFile = "^(?:[\\w]\\:|\\/)(\\/[a-z_\\-\\s0-9\\.]+)+\\.(txt|gif|pdf|doc|docx|xls|xlsx|js)$";
            String regexDirectory = "^(?<ParentPath>(?:[a-zA-Z]\\:|\\\\\\\\[\\w\\s\\.]+\\\\[\\w\\s\\.$]+)\\\\(?:[\\w\\s\\.]+\\\\)*)(?<BaseName>[\\w\\s\\.]*?)$";
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            if (checkRegex(regexFile, value) || checkRegex(regexDirectory, value)) {
                return value;
            } else {
                System.err.println("Invalid format for path!");
            }

        }
    }

    public int getUserLimit(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);
                if (number < 0) {
                    System.err.println("number must be > 0!");
                }

                if (number < min || number > max) {
                    System.err.println(String.format("Please input between %d and %d",
                            min, max));
                } else {
                    return number;
                }

            } catch (NumberFormatException e) {
                System.err.println("Invalid Value! must be integer!");
            }
        }
    }
}
