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
 * @param <D>
 */
public abstract class Database<D extends Identifiables> {

    protected String fileName;
    protected List<D> records = new ArrayList<>();

    public Database(String fileName) {
        this.fileName = fileName;
    }

    public void readFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                D record = createRecordFrom(scanner.nextLine());
                records.add(record);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }

    }


    public abstract D createRecordFrom(String line);

    public List<D> returnAllRecords() {
        return records;
    }

    public Boolean contains(String key) {

        for (D record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;

    }

    public D getRecord(String key) {
        for (D record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public void insertRecord(D record) {
        if (!contains(record.getSearchKey())) {
            records.add(record);
        } else {
            System.out.println("Record already exists");
        }
    }

    public void deleteRecord(String key) {
        boolean found = false;
        Iterator<D> iterator = records.iterator();

        while (iterator.hasNext()) {
            D record = iterator.next();
            if (record.getSearchKey().equals(key)) {
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

    public void saveToFile() {

        try {
            FileWriter writer = new FileWriter(fileName);
            for (D record : records) {
                writer.write(record.lineRepresentation() + "\n");
            }
            writer.close();
//            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }
    }

}
