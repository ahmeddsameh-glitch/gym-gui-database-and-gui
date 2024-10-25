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
public class TrainerDatabase {

    private String fileName;
    private List<Trainer> trainers = new ArrayList<>();

    public TrainerDatabase(String fileName) {
        this.fileName = fileName;
    }

    public void ReadFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                Trainer t = createRecordForm(scanner.nextLine());
                trainers.add(t);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }
    }

    public Trainer createRecordForm(String line) {
        String[] data = line.split(",");
        Trainer t = new Trainer(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
        return t;
    }

    public List<Trainer> returnAllRecords() {
        return trainers;
    }

    public Boolean contains(String key) {
        for (Trainer t : trainers) {
            if (t.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Trainer getRecord(String key) {
        for (Trainer t : trainers) {
            if (t.getSearchKey().equals(key)) {
                return t;
            }
        }
        return null;
    }

    public void insertRecord(Trainer record) {

        if (!contains(record.getSearchKey())) {
            trainers.add(record);
        } else {
            System.out.println("Trainer already exists");
        }

    }

    public void deleteRecord(String key) {

        for (Trainer t : trainers) {
            if (t.getSearchKey().equals(key)) {
                trainers.remove(t);
            } else {
                System.out.println("No trainer match this Id");
            }
        }

    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Trainer t : trainers) {
                writer.write(t.lineRepresentation() + "\n");
            }
            writer.close();
            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

}
