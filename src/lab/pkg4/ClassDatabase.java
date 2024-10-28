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
public class ClassDatabase extends Database<Class>{

  

  public ClassDatabase(String fileName) {
        super(fileName); 
    }


    @Override
    public void readFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                Class c = createRecordFrom(scanner.nextLine());
                records.add(c);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }
    }

    @Override
    public Class createRecordFrom(String line) {
        String[] data = line.split(",");
        Class c = new Class(data[0].trim(), data[1].trim(), data[2].trim(), Integer.parseInt(data[3].trim()), Integer.parseInt(data[4].trim()));
        return c;
    }

    @Override
    public List<Class> returnAllRecords() {
        return records;
    }

    @Override
    public Boolean contains(String key) {
        for (Class c : records) {
            if (c.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Class getRecord(String key) {
        for (Class c : records) {
            if (c.getSearchKey().equals(key)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void insertRecord(Class record) {

        if (!contains(record.getSearchKey())) {
            records.add(record);
        } else {
            System.out.println("Class already exists");
        }

    }

    @Override
    public void deleteRecord(String key) {

        boolean found = false;
        Iterator<Class> iterator = records.iterator();

        while (iterator.hasNext()) {
            Class c = iterator.next();
            if (c.getSearchKey().equals(key)) {
                iterator.remove();
                found = true;
                System.out.println("Record deleted successfully.");
                return;
            }
        }

        if (!found) {
            System.out.println("No class matches this Id");
        }

    }

    @Override
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Class c : records) {
                writer.write(c.lineRepresentation() + "\n");
            }
            writer.close();
//            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

}
