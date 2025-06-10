/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author NguyenDucAnh
 */
public class MD5validate {

    private Scanner scanner = new Scanner(System.in);

    public String validateHashMD5(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(value.getBytes());
                byte[] bs = md.digest();

                StringBuilder sb = new StringBuilder();
                for (byte b : bs) {
                    sb.append(String.format("%02x", b));
                }

                return sb.toString();

            } catch (NoSuchAlgorithmException e) {
                System.err.println("Cant use this algorithms [MD5]!");
            }
        }
    }

    public String changeValueToMD5(String value) {
        while (true) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(value.getBytes());
                byte[] bs = md.digest();

                StringBuilder sb = new StringBuilder();
                for (byte b : bs) {
                    sb.append(String.format("%02x", b));
                }

                return sb.toString();

            } catch (NoSuchAlgorithmException e) {
                System.err.println("Cant use this algorithms [MD5]!");
            }
        }
    }

}
