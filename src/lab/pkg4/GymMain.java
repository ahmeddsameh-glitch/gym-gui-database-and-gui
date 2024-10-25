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
public class GymMain {
    
    static AdminRole admin = new AdminRole(); 
    static TrainerRole trainer = new TrainerRole();
    public static void main(String[] args){
    
//    admin.addTrainer("T5", "Amr", "amr@gmail.com", "fitnes", "123456");
//    admin.removeTrainer("T4");
//    List<Trainer> trainers = admin.getListOfTrainers();
//    for(Trainer t : trainers){
//    System.out.println(t.lineRepresentation());
//    }
//    admin.logout();
    
    trainer.addMember("M6", "Amr", "Silver", "amr@gmail.com", "123456", "active");
    trainer.logout();;


    
    
    
    
    }
    
}
