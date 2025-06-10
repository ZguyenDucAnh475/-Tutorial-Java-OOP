/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NguyenDucAnh
 */
public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public String getDirectoryPath() {
        System.out.print("Enter directory path: ");
        return scanner.nextLine();
    }

    public String getKeyword() {
        System.out.print("Enter keyword to search: ");
        return scanner.nextLine();
    }

    public void displayWordCount(String fileName, int count) {
        System.out.println(fileName + " has " + count + " words.");
    }

    public void displayFilesWithKeyword(String keyword, List<String> fileNames) {
        System.out.println("Files containing '" + keyword + "':");
        if (fileNames.isEmpty()) {
            System.out.println("No files found.");
        } else {
            for (String name : fileNames) {
                System.out.println("- " + name);
            }
        }
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
