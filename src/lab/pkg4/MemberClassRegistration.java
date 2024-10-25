/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

/**
 *
 * @author amr
 */
public class MemberClassRegistration {

    private String memberID, classID, status;
    private LocalDate date;

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate date) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.date = date;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return date;
    }

    public String getSearchKey() {
        return memberID + classID;
    }

    public String lineRepresentation() {
        String data = memberID + ", " + classID + ", " + date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + ", " + status;
        return data;
    }

}
