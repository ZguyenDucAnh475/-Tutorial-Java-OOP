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
public class ExperienceHandle {

    private static Scanner scanner = new Scanner(System.in);

    private static boolean checkRegex(String regex, String value) {
        boolean isTrue = false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            isTrue = true;
        } else {
            isTrue = false;
        }

        return isTrue;
    }

    public static int getExpInYear(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);

                if (number < min) {
                    System.err.println(String.format("Your value must >= %d", min));
                    continue;
                }

                if (number > max) {
                    System.err.println(String.format("Your value must <= %d",
                            max));
                    continue;
                }

                return number;

            } catch (NumberFormatException e) {
                System.err.println("This value must a integer!");
            }

        }
    }

    public static String getProSkill(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "[a-zA-Z ]+";
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            if (checkRegex(regex, value)) {
                return value;
            } else {
                System.err.println("Invalid format! string for name!");
            }

        }
    }
}
