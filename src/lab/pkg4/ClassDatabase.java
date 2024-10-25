/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.*;
import java.io.*;

/**
 *
 * @author amr
 */
public class ClassDatabase {

    private String fileName;
    private List<Class> classes = new ArrayList<>();

    public ClassDatabase(String fileName) {
        this.fileName = fileName;
    }

    public void ReadFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                Class c = createRecordForm(scanner.nextLine());
                classes.add(c);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }
    }

    public Class createRecordForm(String line) {
        String[] data = line.split(",");
        Class c = new Class(data[0].trim(), data[1].trim(), data[2].trim(), Integer.parseInt(data[3].trim()), Integer.parseInt(data[4].trim()));
        return c;
    }

    public List<Class> returnAllRecords() {
        return classes;
    }

    public Boolean contains(String key) {
        for (Class c : classes) {
            if (c.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Class getRecord(String key) {
        for (Class c : classes) {
            if (c.getSearchKey().equals(key)) {
                return c;
            }
        }
        return null;
    }

    public void insertRecord(Class record) {

        if (!contains(record.getSearchKey())) {
            classes.add(record);
        } else {
            System.out.println("Class already exists");
        }

    }

    public void deleteRecord(String key) {

        for (Class c : classes) {
            if (c.getSearchKey().equals(key)) {
                classes.remove(c);
            } else {
                System.out.println("No class match this Id");
            }
        }

    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Class c : classes) {
                writer.write(c.lineRepresentation() + "\n");
            }
            writer.close();
            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

}
