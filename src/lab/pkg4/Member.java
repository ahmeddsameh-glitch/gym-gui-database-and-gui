/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.pkg4;

/**
 *
 * @author amr
 */
public class Member {

    private String memberID, name, membershipType, email, phoneNumber, status;

    public Member(String memberId, String name, String membershipType, String email, String phoneNumber, String status) {
        this.memberID = memberID;
        this.name = name;
        this.membershipType = membershipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String lineRepresentation() {
        String data = memberID + ", " + name + ", " + membershipType + ", " + email + ", " + phoneNumber + ", " + status;
        return data;
    }

    public String getSearchKey() {
        return memberID;
    }

}
