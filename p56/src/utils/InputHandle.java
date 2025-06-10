/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {

    private Scanner scanner = new Scanner(System.in);

    public Date validateDate(String msg) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This date cannot be EMPTY!");
                continue;
            }

            try {
                Date date = dateFormat.parse(value);

                // Trích xuất năm từ Date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                String year = String.valueOf(calendar.get(Calendar.YEAR));
                Year getYear = Year.parse(year);
                Year currentYear = Year.now();

                if (getYear.isAfter(currentYear)) {
                    System.err.println("Year must be 2025 or less!");
                } else {
                    return date;
                }

            } catch (ParseException e) {
                System.err.println("Invalid date format or invalid date. Please enter again (dd/MM/yyyy).");
            }
        }
    }

    public String validateWorkerCode(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "W \\d{1}+";
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This code cannot be EMPTY!");
                continue;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);

            if (matcher.matches()) {
                return value;
            } else {
                System.err.println("Invalid format! re-input:");
            }
        }
    }

    public String getName(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "[a-zA-Z ]+";
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This name cannot be EMPTY!");
                continue;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);

            if (matcher.matches()) {
                return value;
            } else {
                System.err.println("Invalid format! re-input:");
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
