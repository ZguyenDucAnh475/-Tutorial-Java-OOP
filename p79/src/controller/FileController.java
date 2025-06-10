/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.ProgramView;
import model.FileProcessor;

/**
 *
 * @author NguyenDucAnh
 */
public class FileController {

    private ProgramView view = new ProgramView();
    private FileProcessor fileProcessor;

    public void getMenu() {
        view.printMenu();
    }

    public void zipTask() {
        String sourceFile = "F:\\demo76\\j97.txt";
        fileProcessor = new FileProcessor(sourceFile);
        String zipFileName = "F:\\demo76\\j97.zip";
        fileProcessor.zipFile(zipFileName);
    }

    public void unzipTask() {
        String pathZipFile = "F:\\demo76\\j97.zip"; // file zip
        fileProcessor = new FileProcessor(pathZipFile);
        String pathExtract = "F:\\demo76\\j97New"; // folder
        fileProcessor.unzipFile(pathExtract);
    }
}
