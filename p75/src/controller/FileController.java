/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import utils.InputHandle;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class FileController {

    private ProgramView view = new ProgramView();
    private InputHandle inputHandle = new InputHandle();

    // --------------------------------------------------- VIEW ---------------------------------------------------
    public void getMenu() {
        view.printMenuView();
    }

    // --------------------------------------------------- FUNCTION 1 ---------------------------------------------------
    public void checkPath() {
        view.printViewTitle("Check Path");
        String pathName = getPath("Enter Path: ");
        File file = new File(pathName);

        if (file.isDirectory()) {
            view.printResult("out", "%s", "Path to Directory");
        } else if (file.isFile()) {
            view.printResult("out", "%s", "Path to file");
        } else {
            view.printResult("err", "%s", "Path doesn't exist");
        }
    }

    // --------------------------------------------------- FUNCTION 2 ---------------------------------------------------
    public void getFileNameWithTypeJava() {
        view.printViewTitle("Get file name with type java");
        String pathName = getPath("Enter Path: ");
        File dir = new File(pathName);

        int countJavaFile = 0;
        if (isExistedDirectory(dir)) {
            File[] javaFiles = dir.listFiles();

            for (File javaFile : javaFiles) {
                if (acceptJavaFile(javaFile)) {
                    countJavaFile++;
                }
            }
        } else {
            System.err.println("Path doesn't exist");
        }

        view.printResult("out", "Result %s file!", String.valueOf(countJavaFile));

    }

    private boolean acceptJavaFile(File pathName) {
        if (pathName.getAbsolutePath().endsWith(".java")) {
            return true;
        }
        return false;
    }

    // --------------------------------------------------- FUNCTION 3 ---------------------------------------------------
    public void getFileWithSizeThanInput() {
        view.printViewTitle("Get file with size greater than input");
        long sizeInByte = getSizeInByte("Enter Size(kb): ");
        String pathName = getPath("Enter Path: ");

        File dir = new File(pathName);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Path doesn’t exist. Please Try again.");
            return;
        }

        File[] files = dir.listFiles();
        int countFile = 0;

        for (File file : files) {
            if (file.isFile() && file.length() > sizeInByte) {
                view.printResult("out",
                        "%s - %.2f KB",
                        file.getName(), file.length() / 1024.0);

                countFile++;
            }
        }

        view.printResult("out",
                "Result %s files!", String.valueOf(countFile));

    }

    // --------------------------------------------------- FUNCTION 4 ---------------------------------------------------
    public void writeMoreContentToFile() {
        view.printViewTitle("Write more content to file");
        String content = getContent("Enter Content: ");
        String pathName = getPath("Enter Path: ");
        File file = new File(pathName);

        while (!file.isFile()) {
            System.err.println("Path doesn't exist");
            pathName = getPath("Enter Path: ");
            file = new File(pathName);
        }

        writeContentToFile(file, content);

    }

    private void writeContentToFile(File file, String content) {
        try (FileOutputStream fos = new FileOutputStream(file, true)) {

            byte[] contentBytes = content.getBytes();

            fos.write(contentBytes);

            view.printResult("out", "%s",
                    "Data successfully written to the file.");

        } catch (Exception e) {
            view.printResult("err", "%s%s",
                    "An error occured: ", e.getMessage());
        }
    }

    // --------------------------------------------------- FUNCTION 5 ---------------------------------------------------
    public void readFileAndCountCharacters() {
        view.printViewTitle("Read file and count characters");
        String pathName = getPath("Enter Path: ");
        File file = new File(pathName);

        countWord(file);
    }

    private void countWord(File file) {
        int wordCount = 0;

        if (!file.exists() || !file.isFile()) {
            System.err.println("File doesn't exist!");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();

                line = line.replaceAll("[^a-zA-Z0-9\\s]", " ");

                String[] words = line.trim().split("\\s+");

                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            view.printResult("out", "Total: %s", String.valueOf(wordCount));
        } catch (Exception e) {
            System.err.println("File doesn't exist");
        }
    }

    // --------------------------------------------------- SUPPORT FUNCTION ---------------------------------------------------
    private boolean isExistedFile(File file) {
        return file.isFile();
    }

    private boolean isExistedDirectory(File file) {
        return file.isDirectory();
    }

    // --------------------------------------------------- INPUT FUNCTION ---------------------------------------------------
    public int getChoice(String msg, int min, int max) {
        return inputHandle.getUserLimit(msg, min, max);
    }

    private String getPath(String msg) {
        return inputHandle.validateFilePath(msg);
    }

    private long getSizeInByte(String msg) {
        return inputHandle.getNumeric(msg);
    }

    private String getContent(String msg) {
        return inputHandle.getContent(msg);
    }
}
