/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.io.*;
import java.time.LocalDate;

import java.util.*;

/**
 *
 * @author amr
 */
public class MemberClassRegistrationDatabase extends Database<MemberClassRegistration> {

    public MemberClassRegistrationDatabase(String fileName) {
        super(fileName);
    }



    @Override
    public MemberClassRegistration createRecordFrom(String line) {
        String[] data = line.split(",");
        String[] formatedDate = data[2].split("-");
        LocalDate d = LocalDate.parse(data[2].trim());
//        LocalDate d = LocalDate.of(Integer.parseInt(formatedDate[0].trim()), Integer.parseInt(formatedDate[1].trim()), Integer.parseInt(formatedDate[2].trim()));
        MemberClassRegistration mCR = new MemberClassRegistration(data[0].trim(), data[1].trim(), data[3].trim(), d);
        return mCR;
    }
    
    @Override
   public Boolean contains(String key) {

        for (MemberClassRegistration record : records) {
            if (record.getSearchKey().equals(key) && record.getStatus().equals("active")) {
                return true;
            }
        }
        return false;

    }
    @Override
     public MemberClassRegistration getRecord(String key) {
        for (MemberClassRegistration record : records) {
            if (record.getSearchKey().equals(key) && record.getStatus().equals("active")) {
                return record;
            }
        }
        return null;
    }
    

   
}
