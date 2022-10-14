package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Data {
    private static final String PATH = String.format(".%ssrc%s", File.separator, File.separator);
    private final File file;

    public Data(String fileName) {
        this.file = new File(PATH + fileName);
    }

    public Data(File fileName) {
        this.file = fileName;
    }

    public void saveFile(String text) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        } catch (IOException e) {
            System.out.println("failed to write file");
            System.out.println(e.getMessage());
        }
    }

    public String loadFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(String.valueOf(file))));
        } catch (IOException e) {
            return "";
        }
    }
}
