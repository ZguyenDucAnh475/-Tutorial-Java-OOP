/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenDucAnh
 */
public class TextFileProcessor {
    private List<TextFile> files;

    public TextFileProcessor(String directoryPath) {
        files = new ArrayList<>();
        File dir = new File(directoryPath);
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    files.add(new TextFile(f.getAbsolutePath()));
                }
            }
        }
    }

    public List<TextFile> getFiles() {
        return files;
    }
}

