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
public class MemberClassRegistrationDatabase implements Database<MemberClassRegistration>{

    private String fileName;
    private List<MemberClassRegistration> memberClassRegistrations = new ArrayList<>();

    public MemberClassRegistrationDatabase(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void ReadFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                MemberClassRegistration mCR = createRecordForm(scanner.nextLine());
                memberClassRegistrations.add(mCR);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }
    }

    @Override
    public MemberClassRegistration createRecordForm(String line) {
        String[] data = line.split(",");
        String[] formatedDate = data[2].split("-");
        LocalDate d = LocalDate.parse(data[2].trim());
//        LocalDate d = LocalDate.of(Integer.parseInt(formatedDate[0].trim()), Integer.parseInt(formatedDate[1].trim()), Integer.parseInt(formatedDate[2].trim()));
        MemberClassRegistration mCR = new MemberClassRegistration(data[0].trim(), data[1].trim(), data[3].trim(), d);
        return mCR;
    }

    @Override
    public List<MemberClassRegistration> returnAllRecords() {
        return memberClassRegistrations;
    }

    @Override
    public Boolean contains(String key) {
        for (MemberClassRegistration mCR : memberClassRegistrations) {
            if (mCR.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MemberClassRegistration getRecord(String key) {
        for (MemberClassRegistration mCR : memberClassRegistrations) {
            if (mCR.getSearchKey().equals(key)) {
                return mCR;
            }
        }
        return null;
    }

    @Override
    public void insertRecord(MemberClassRegistration record) {

        if (!contains(record.getSearchKey())) {
            memberClassRegistrations.add(record);
        } else {
            System.out.println("Class already exists");
        }

    }

    @Override
    public void deleteRecord(String key) {

       boolean found = false;
    Iterator<MemberClassRegistration> iterator = memberClassRegistrations.iterator();
    
    while (iterator.hasNext()) {
        MemberClassRegistration mCR = iterator.next();
        if (mCR.getSearchKey().equals(key)) {
            iterator.remove(); 
            found = true;
            System.out.println("Class registration deleted successfully.");
            return; 
        }
    }
    
    if (!found) {
        System.out.println("No class matches this Id");
    }

    }

    @Override
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (MemberClassRegistration mCR : memberClassRegistrations) {
                writer.write(mCR.lineRepresentation() + "\n");
            }
            writer.close();
//            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

}
