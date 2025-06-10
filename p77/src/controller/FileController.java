/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.TextFile;
import model.TextFileProcessor;
import view.ConsoleView;

/**
 *
 * @author NguyenDucAnh
 */
public class FileController {

    private ConsoleView view;

    public FileController(ConsoleView view) {
        this.view = view;
    }

    public void run() {
        String path = view.getDirectoryPath();
        TextFileProcessor processor = new TextFileProcessor(path);

        try {
            for (TextFile file : processor.getFiles()) {
                int wordCount = file.countWords();
                view.displayWordCount(file.getName(), wordCount);
            }

            String keyword = view.getKeyword();
            List<String> matchingFiles = new ArrayList<>();
            for (TextFile file : processor.getFiles()) {
                if (file.contains(keyword)) {
                    matchingFiles.add(file.getName());
                }
            }

            view.displayFilesWithKeyword(keyword, matchingFiles);

        } catch (IOException e) {
            view.showError(e.getMessage());
        }
    }
}
