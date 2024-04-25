package com.viplav.utils.spring.codegenerator.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileCreator {

    public void createZipFile(String zipFileName, String[] filesToZip) {
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (String file : filesToZip) {
                File fileToZip = new File(file);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zos.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zos.write(bytes, 0, length);
                }

                fis.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZipFileCreator zipFileCreator = new ZipFileCreator();
        String[] filesToZip = {"/Users/viplavfauzdar/tmp/Screen Shot 2024-02-17 at 6.05.41 PM.png"};//"file1.txt", "file2.txt", "file3.txt"};
        zipFileCreator.createZipFile("/Users/viplavfauzdar/tmp/myZipFile.zip", filesToZip);
    }
    
}
