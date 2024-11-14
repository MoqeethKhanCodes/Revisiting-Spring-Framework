package org.moqeeth.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    public static final String BASE_DIR = "C:\\Developer\\FileReads";

    //Constructor
    public FileService() {
        File directory = new File(BASE_DIR);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    //create a file
    public String createFile(String fileName) throws IOException {
        Path filePath = Paths.get(BASE_DIR, fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
            return "File created successfully!";
        }
        return "File already exists!";
    }

    //read a file
    public String readFile(String fileName) throws IOException {
        Path filePath = Paths.get(BASE_DIR, fileName);
        if (Files.exists(filePath)) {
            return Files.readString(filePath);
        }
        return "File does not exist!";
    }

    //write a file
    public String writeFile(String fileName, String content) throws IOException {
        Path filePath = Paths.get(BASE_DIR, fileName);
        if (Files.exists(filePath)) {
            Files.writeString(filePath, content);
            return "Content written successfully!";
        }
        return "File does not exist!";
    }

    //rename a file
    public String renameFile(String oldFileName, String newFileName) throws IOException {
        Path oldPath = Paths.get(BASE_DIR, oldFileName);
        Path newPath = Paths.get(BASE_DIR, newFileName);
        if (Files.exists(oldPath)) {
            boolean renamed = oldPath.toFile().renameTo(newPath.toFile());
            return "File renamed " + (renamed ? "successfully!" : "failed!");

        }
        return "File does not exist!";

    }

    //delete a file
    public String deleteFile(String fileName) throws IOException {

        Path filePath = Paths.get(BASE_DIR, fileName);
        if (Files.exists(filePath)) {
            boolean deleted = filePath.toFile().delete();
            return "File deleted " + (deleted ? "successfully!" : "failed!");
        }
        return "File do not exist";
    }
}
