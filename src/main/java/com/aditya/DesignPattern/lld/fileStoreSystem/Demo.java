package com.aditya.DesignPattern.lld.fileStoreSystem;

import java.io.*;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("abc.txt");

        boolean flag = true;

        while(flag) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            if (s.equals("!")) {
                flag = false;
                break;
            }

            try (FileWriter fileWriter = new FileWriter(file.getPath(), true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write(s);
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.parseFile(file);
    }
}
