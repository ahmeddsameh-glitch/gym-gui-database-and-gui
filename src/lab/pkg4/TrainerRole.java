/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author amr
 */
public class TrainerRole {
    
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;
    
    public TrainerRole() {
        memberDatabase = new MemberDatabase("Members.txt");
        memberDatabase.ReadFromFile();
        classDatabase = new ClassDatabase("Class.txt");
        classDatabase.ReadFromFile();
        registrationDatabase = new MemberClassRegistrationDatabase("Registration.txt");
        registrationDatabase.ReadFromFile();
    }
    
    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        
        Member m = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(m);
        
    }
    
    public List<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }
    
    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class c = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(c);
    }
    
    public List<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }
    
    public Boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        int seats = classDatabase.getRecord(classID).getAvailableSeats();
        if (seats > 0) {
            MemberClassRegistration mCR = new MemberClassRegistration(memberID, classID, "active", registrationDate);
//            memberDatabase.getRecord(memberID).setStatus("active");
            registrationDatabase.insertRecord(mCR);
            classDatabase.getRecord(classID).setAvailableSeats(seats - 1);
            return true;
        }
        return false;
        
    }
    
    public Boolean cancelRegistration(String memberID, String classID) {
        int seats = classDatabase.getRecord(classID).getAvailableSeats();
        MemberClassRegistration mCR = registrationDatabase.getRecord(memberID + classID);
        
        if (true) {
            LocalDate d = mCR.getRegistrationDate();
            long daysDifference = ChronoUnit.DAYS.between(d, LocalDate.now());
            
            if (daysDifference <= 3) {
                
                mCR.setStatus("cancelled");  
//                registrationDatabase.deleteRecord(memberID + classID);
                classDatabase.getRecord(classID).setAvailableSeats(seats + 1);
            }
            return true;
        }
        return false;
        
    }
    
    public List<MemberClassRegistration> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }
    
    public void logout() {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
        System.out.println("Data updated Successfully");
        
    }
}
