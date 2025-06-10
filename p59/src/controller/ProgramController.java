/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import model.User;
import utils.InputHandle;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class ProgramController {

    private ProgramView view = new ProgramView();
    private InputHandle inputHandle = new InputHandle();
    private ArrayList<User> userList = new ArrayList<>();
    private User userMoneyInput = new User();

    private double maxValue;
    private double minValue;

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    // ------------------------- VIEW -------------------------
    public void getMenu() {
        view.printMenuView();
    }

    // ------------------------- FIND -------------------------
    public void getPerson() {
        String pathName = getPathName("Enter Path: ");
        File path = new File(pathName);

        if (!path.exists()) {
            System.err.println("This file doesn't exist!");
            return;
        }

        if (!path.isFile()) {
            System.err.println("This is not file!");
            return;
        }

        double money = getMoneyValue("Enter Money: ");
        userMoneyInput.setSalary(money);
        getPersonController(path);
        getMinMax();
    }

    private void getPersonController(File path) {
        readFile(path);
    }

    // ------------------------- COPY -------------------------
    public void copyWordOneTimes() {
        String pathName = getPathName("Enter Source: ");
        File path = new File(pathName);
        if (!path.exists()) {
            System.err.println("This file doesn't exist!");
            return;
        }

        if (!path.isFile()) {
            System.err.println("This is not file!");
            return;
        }

        String newPathName = getPathName("Enter new file name: ");
        copyController(path, newPathName);
        //System.out.println("Copy successfully to: " + newPathName);
    }

    private void copyController(File source, String newPath) {
        writeToFile(source, newPath);
    }

    // ------------------------- SUPPORT -------------------------
    // Read file
    private void readFile(File path) {
        try {
            Scanner myReader = new Scanner(path);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                getSplit(data, userList);
                //System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println("An error occurred.");
        }
    }

    // Write file
    private void writeToFile(File source, String newPath) {
        try (Scanner scanner = new Scanner(source); FileOutputStream output = new FileOutputStream(newPath)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.write((line + System.lineSeparator()).getBytes());
            }
            System.out.println("Copy done ...");

        } catch (Exception e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    // Split value
    private void getSplit(String value, ArrayList<User> userList) {
        String[] s = value.split(";");
        double getValue = Double.parseDouble(s[2]);
        User user = new User(s[0], s[1], getValue);
        if (getValue >= userMoneyInput.getSalary()) {
            userList.add(user);
        }

    }

    // get min max
    private void getMinMax() {
        if (userList.isEmpty()) {
            System.err.println("No data to process.");
            return;
        }

        // Sắp xếp giảm dần theo lương
        userList.sort(Comparator.comparing(User::getSalary).reversed());

        // Lương cao nhất là phần tử đầu, thấp nhất là cuối
        User maxUser = userList.get(0);
        User minUser = userList.get(userList.size() - 1);

        setMaxValue(maxUser.getSalary());
        setMinValue(minUser.getSalary());
    }

    // ------------------------- DISPLAY -------------------------
    public void displayinfo() {
        if (!userList.isEmpty()) {
            view.printResult();
            for (User o : userList) {
                System.out.println(o.toString());
            }
            
            System.out.println("");
            System.out.println(String.format("Max: %.1f", getMaxValue()));
            System.out.println(String.format("Min: %.1f", getMinValue()));
        }
    }

    // ------------------------- INPUT -------------------------
    private String getPathName(String msg) {
        return inputHandle.validateFilePath(msg);
    }

    private double getMoneyValue(String msg) {
        return inputHandle.getMoney(msg);
    }

    public int getChoice(String msg, int min, int max) {
        return inputHandle.getUserLimit(msg, min, max);
    }
}
