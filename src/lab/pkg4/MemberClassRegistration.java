/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.time.LocalDate;

/**
 *
 * @author amr
 */
public class MemberClassRegistration implements Identifiables {

    private String memberID, classID, status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate date) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String getSearchKey() {
        return memberID + "-" + classID;
    }

    @Override
    public String lineRepresentation() {
        String data = memberID + ", " + classID + ", " + registrationDate + ", " + status;
        return data;
    }

}
