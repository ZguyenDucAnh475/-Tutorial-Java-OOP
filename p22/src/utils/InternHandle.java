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
public class InternHandle {

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

    public static String getMajors(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "[a-zA-Z ]+";
            String value = scanner.nextLine().trim();

            if (checkRegex(regex, value)) {
                return value;
            } else {
                System.err.println("Invalid format! string for majors!");
            }

        }
    }

    public static String getUniversityName(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "[a-zA-Z ]+";
            String value = scanner.nextLine().trim();

            if (checkRegex(regex, value)) {
                return value;
            } else {
                System.err.println("Invalid format! string for university name!");
            }

        }
    }
}
