package com.aditya.DesignPattern.lld.fileStoreSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStoreSystem {

    public static void saveResponseToFile(String apiUrl, String response) {
        String directoryPath = "responses/";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();  // Create the directory if it does not exist
        }


        String outputFilePath = "responses/" + apiUrl.replaceAll("[^a-zA-Z0-9]", "_") + "_response.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            writer.write("API: " + apiUrl + "\n");
            writer.write("Response: " + response + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
