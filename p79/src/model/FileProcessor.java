/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author NguyenDucAnh
 */
public class FileProcessor {

    private File filepathSource;

    public FileProcessor(String path) {
        this.filepathSource = new File(path);
    }

    public void zipFile(String zipFileName) {
        try (
                FileOutputStream fos = new FileOutputStream(zipFileName); ZipOutputStream zipOut = new ZipOutputStream(fos); FileInputStream fis = new FileInputStream(filepathSource)) {
            ZipEntry zipEntry = new ZipEntry(filepathSource.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            System.out.println("Zip file succeed!");
        } catch (IOException e) {
            System.err.println("Zip Fail!");
        }
    }

    public void unzipFile(String desDir) {
        byte[] buffer = new byte[1024];

        try (
                ZipInputStream zis = new ZipInputStream(new FileInputStream(filepathSource))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = new File(desDir, zipEntry.getName());

                // Tạo thư mục nếu cần
                new File(newFile.getParent()).mkdirs();

                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }

                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            System.out.println("Unzip succeed!");
        } catch (IOException e) {
            System.err.println("Unzip Fail!");

        }
    }

    public File getFilepathSource() {
        return filepathSource;
    }

    public void setFilepathSource(File filepathSource) {
        this.filepathSource = filepathSource;
    }

}
