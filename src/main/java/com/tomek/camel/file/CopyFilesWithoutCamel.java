package com.tomek.camel.file;

import java.io.*;

public class CopyFilesWithoutCamel {

    public static void main(String[] args) throws IOException {

        //Create a file Object to read the directories
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        //Read the files from the directory and iterate the files
        File[] files = inputDirectory.listFiles();

        //Read the files
        for (File file : files) {
            System.out.println(file);
            if (file.isFile()) {
                File dest = new File(
                        outputDirectory.getPath()
                                + File.separator
                                + file.getName());

                //Create the Output Stream to write the files
                OutputStream outputStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) file.length()];

                FileInputStream inputStream = new FileInputStream(file);
                inputStream.read(buffer);
                try {
                    outputStream.write(buffer);
                } finally {
                    outputStream.close();
                    inputStream.close();
                }
            }
        }
    }
}
