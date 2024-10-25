/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author amr
 */
public class GymMain {

    static AdminRole admin = new AdminRole();
    static TrainerRole trainer = new TrainerRole();

    public static void main(String[] args) {

        admin.addTrainer("T7", "Amr", "amr@gmail.com", "fitnes", "123456");
        admin.removeTrainer("T4");
        List<Trainer> trainers = admin.getListOfTrainers();
        for (Trainer t : trainers) {
            System.out.println(t.lineRepresentation());
        }
        admin.logout();

        trainer.addMember("M7", "Amr", "Silver", "amr@gmail.com", "123456", "active");
        trainer.addClass("C1", "Zomba", "T1", 2, 30);
        trainer.registerMemberForClass("M1", "C1", LocalDate.now());
        trainer.cancelRegistration("M1", "C1");
        trainer.logout();

    }

}
