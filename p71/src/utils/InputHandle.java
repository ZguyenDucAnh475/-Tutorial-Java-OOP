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

    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String regex = "[a-zA-Z ]+";
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);

            if (matcher.matches()) {
                return value;
            } else {
                System.err.println("Invalid Format! please input string!");
            }

        }
    }

    public double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {
                double number = Double.parseDouble(value);

                if (number <= 0) {
                    System.err.println("This number must > 0!");
                    continue;
                }

                if (number < min || number > max) {
                    System.err.println(String.format("Please input between %.2f and %.2f",
                            min, max));
                    continue;
                }

                return number;

            } catch (NumberFormatException e) {
                System.err.println("This value must double/integer number");
            }
        }
    }

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

    public Date getDate(String msg) {
        final Year currentYear = Year.now();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {
                Date date = dateFormat.parse(value);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                String year = String.valueOf(calendar.get(Calendar.YEAR));
                Year getYear = Year.parse(year);

                if (getYear.isAfter(currentYear)) {
                    System.err.println(String.format("Must be %s or less than!", currentYear));
                    continue;
                }

                return date;
            } catch (ParseException e) {
                System.err.println("Invalid Format! please input again(dd-MM-yyyy):");
            }
        }
    }

    public int getInt(String msg) {
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

                if (number > Integer.MAX_VALUE) {
                    System.err.println("Please input in limit of integer!");
                    continue;
                }

                if (number > 0 && number < Integer.MAX_VALUE) {
                    return number;
                }

            } catch (NumberFormatException e) {
                System.err.println("This value must be integer!");
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

}
