/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {

    private Scanner scanner = new Scanner(System.in);

    public int getUserNumberLimit(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                String value = scanner.nextLine().trim();

                if (value.isEmpty()) {
                    System.err.println("This value cannot be empty!");
                    continue;
                }

                int number = Integer.parseInt(value);

                if (number <= 0) {
                    System.err.println("This value must > 0!");
                    continue;
                }

                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println(String.format("please input from %d to %d", min, max));
                }

            } catch (NumberFormatException e) {
                System.err.println("This value must be a integer!");
            }
        }
    }

    public int getAmountValue(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                String value = scanner.nextLine().trim();

                if (value.isEmpty()) {
                    System.err.println("This amount cannot be empty!");
                    continue;
                }

                int amountNumber = Integer.parseInt(value);

                if (amountNumber < 0) {
                    System.err.println("This value must >= 0!");
                    continue;
                }

                return amountNumber;

            } catch (NumberFormatException e) {
                System.err.println("Invalid! please input integer!");
            }
        }
    }

    public String getContentValue(String msg) {
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

    public Date getDateValue(String msg) {
        String regex = "^\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{4}$";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        dateFormat.setLenient(false);

        while (true) {
            System.out.print(msg);
            String valueString = scanner.nextLine().trim();

            if (valueString.isEmpty()) {
                System.err.println("This date cannot be empty!");
                continue;
            }

            if (!Pattern.matches(regex, valueString)) {
                System.err.println("Date must be in format dd-MMM-yyyy (e.g. 11-Apr-2009)!");
                continue;
            }

            try {
                Date date = dateFormat.parse(valueString);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                String yearOFdate = String.valueOf(calendar.get(Calendar.YEAR));

                Year yearParse = Year.parse(yearOFdate);
                Year currentYear = Year.now();

                if (yearParse.isAfter(currentYear)) {
                    System.err.println(String.format("new year must <= %s", currentYear));
                    continue;
                }

                return date;

            } catch (ParseException e) {
                System.err.println("Invalid date! Please enter a real calendar date");
            } catch (DateTimeParseException e) {
                System.err.println("Your year must be 4 digits [yyyy]!");
            }
        }
    }

}
