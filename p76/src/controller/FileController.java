/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import utils.InputHandle;
import view.HandleFileView;

/**
 *
 * @author NguyenDucAnh
 */
public class FileController {

    private HandleFileView view = new HandleFileView();
    private InputHandle inputHandle = new InputHandle();
    private String csvString = "";

    // --------------------------------------- VIEW ---------------------------------------
    public void getMenu() {
        view.printMenuView();
    }

    // --------------------------------------- IMPORT FILE ---------------------------------------
    public void importCSV() {
        String pathName = getPath("Enter Path: ");
        File file = new File(pathName);

        if (!file.getAbsolutePath().endsWith(".csv")) {
            System.err.println("This is not a CSV file! Please choose a CSV file.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("Import: Done");
            String line;
            while ((line = br.readLine()) != null) {
                // Mỗi dòng CSV -> tách bằng dấu phẩy
                String[] values = line.split(",");
                System.out.println(Arrays.toString(values));
            }
        } catch (IOException e) {
            System.err.println("Can't read content: " + e.getMessage());
        }
    }

    // --------------------------------------- FORMAT FILE --------------------------------------- 
    public void formatAddress() {

    }

    public void formatName() {

    }

    // --------------------------------------- EXPORT FILE ---------------------------------------
    public void exportCSV() {

    }
    // --------------------------------------- SUPPORT FUNCTION ---------------------------------------

    // --------------------------------------- INPUT ---------------------------------------
    public int getChoice(String msg, int min, int max) {
        return inputHandle.getUserLimit(msg, min, max);
    }

    private String getPath(String msg) {
        return inputHandle.validateFilePath(msg);
    }
}
