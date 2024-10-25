/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.*;

/**
 *
 * @author amr
 */
public class AdminRole {

    private TrainerDatabase database;

    public void addTrainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        Trainer t = new Trainer(trainerId, name, email, speciality, phoneNumber);
        database.insertRecord(t);
    }

    public List<Trainer> getListOfTrainers() {
        return database.returnAllRecords();
    }

    public void removeTrainer(String key) {
        database.deleteRecord(key);
    }

    public void logout() {
        database.saveToFile();
    }

}
