/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg4;

/**
 *
 * @author amr
 */
public class Member implements Objects {

    private String memberID, name, membershipType, email, phoneNumber, status;

    public Member(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        this.memberID = memberID;
        this.name = name;
        this.membershipType = membershipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }


    @Override
    public String lineRepresentation() {
        String data = memberID + ", " + name + ", " + membershipType + ", " + email + ", " + phoneNumber + ", " + status;
        return data;
    }

    @Override
    public String getSearchKey() {
        return memberID;
    }

}
