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
public class TrainerDatabase extends Database<Trainer> {

    

    public TrainerDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public void readFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                Trainer t = createRecordFrom(scanner.nextLine());
                records.add(t);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] data = line.split(",");
        Trainer t = new Trainer(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
        return t;
    }

    @Override
    public List<Trainer> returnAllRecords() {
        return records;
    }

    @Override
    public Boolean contains(String key) {
        for (Trainer t : records) {
            if (t.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Trainer getRecord(String key) {
        for (Trainer t : records) {
            if (t.getSearchKey().equals(key)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void insertRecord(Trainer record) {
    
        if (!contains(record.getSearchKey())) {
            records.add(record);
        } else {
            System.out.println("Trainer already exists");
        }

    }

    @Override
    public void deleteRecord(String key) {

        boolean found = false;
        Iterator<Trainer> iterator = records.iterator();

        while (iterator.hasNext()) {
            Trainer t = iterator.next();
            if (t.getSearchKey().equals(key)) {
                iterator.remove();
                found = true;
                System.out.println("Trainer deleted successfully.");
                return;
            }
        }

        if (!found) {
            System.out.println("No trainer matches this Id");
        }

    }

    @Override
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Trainer t : records) {
                writer.write(t.lineRepresentation() + "\n");
            }
            writer.close();
            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

}
