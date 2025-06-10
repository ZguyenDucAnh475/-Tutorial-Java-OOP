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

    private final int USERNAME_LENGTH = 5;
    private final int PASSWORD_LENGTH = 6;

    private boolean checkSpace(String value) {
        boolean isSpace = false;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isWhitespace(value.charAt(i))) {
                isSpace = true;
            }
        }
        return isSpace;
    }

    private boolean checkRegex(String regex, String value) {
        return Pattern.matches(regex, value);
    }

    public String validateUsername(String msg) {
        while (true) {
            System.out.print(msg);

            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            if ((value.length() < USERNAME_LENGTH) || checkSpace(value)) {
                System.err.println("You must enter least at 5 character, and no space!");
            } else {
                return value;
            }

        }
    }

    public String validatePassword(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            if ((value.length() < PASSWORD_LENGTH) || checkSpace(value)) {
                System.err.println("You must enter least at 6 character, and no space!");
            } else {
                return value;
            }
        }
    }

    public int getLimitInput(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This input cannot be EMPTY!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);

                if (number <= 0) {
                    System.err.println("This number > 0");
                }

                if (number < min || number > max) {
                    System.err.println(String.format("This value must between %d and %d", min, max));
                } else {
                    return number;
                }

            } catch (NumberFormatException e) {
                System.err.println("Must be a integer!");
            }
        }
    }
}
