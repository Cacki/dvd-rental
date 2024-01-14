package org.dvdrental.operations;

import org.dvdrental.converters.Converter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Operations {

    public static List<List<String>> readFromCSV(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(Converter.convertToListElement(line));
            }
        } catch (IOException e) {
            String fileNotExist = "File doesn't exist";
            System.out.println(fileNotExist);
        }
        return records;
    }

    public static void writeToCSV(List<List<String>> listToWrite, String fileName) {
        File csvOutputFile = new File(fileName);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            listToWrite.stream().map(Converter::convertToCSV).forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
