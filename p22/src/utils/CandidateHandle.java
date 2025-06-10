/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NguyenDucAnh
 */
public class CandidateHandle {

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

    public static String candidateID(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "CD \\d+";
            String value = scanner.nextLine().trim();
            if (checkRegex(regex, value)) {
                return value;
            } else {
                System.err.println("Invalid format! e.g. CD 123!");
            }
        }
    }

    public static String getStringName(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "[a-zA-Z ]+";
            String value = scanner.nextLine().trim();
            if (checkRegex(regex, value)) {
                return value;
            } else {
                System.err.println("Invalid format! string for name!");
            }

        }
    }

    public static String getPhone(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "\\d{10}+";
            String value = scanner.nextLine().trim();

            if ((value.length() != 10)) {
                System.err.println("Phone length must 10 digit!");
                continue;
            }

            if (checkRegex(regex, value)) {
                return value;
            } else {
                System.err.println("Invalid format! phone number!");
            }

        }
    }

    public static String getAddress(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "[a-zA-Z ]+";
            String value = scanner.nextLine().trim();
            if (checkRegex(regex, value)) {
                return value;
            } else {
                System.err.println("Invalid format! address!");
            }

        }
    }

    public static Year getBirthDate(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {

                Year yearParse = Year.parse(value);
                Year curYear = Year.now();
                Year min = Year.of(1900);
                if (yearParse.isBefore(min)) {
                    System.err.println(String.format("your year must >= %s", min));
                    continue;
                }

                if (yearParse.isAfter(curYear)) {
                    System.err.println(String.format("your year must <= %s", curYear));
                    continue;
                }
                return yearParse;

            } catch (DateTimeParseException e) {
                System.err.println("Your value input is invalid!");
            }

        }

    }

}
