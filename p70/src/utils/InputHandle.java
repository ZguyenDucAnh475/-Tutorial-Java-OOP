/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {
   private Scanner scanner = new Scanner(System.in);
   
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
