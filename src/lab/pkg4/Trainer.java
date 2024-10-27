/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg4;

/**
 *
 * @author amr
 */
public class Trainer implements Identifiables{

    private String trainerId, name, email, speciality, phoneNumber;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        String data = trainerId + ", " + name + ", " + email + ", " + speciality + ", " + phoneNumber;
        return data;
    }

    @Override
    public String getSearchKey() {
        return trainerId;
    }


}
