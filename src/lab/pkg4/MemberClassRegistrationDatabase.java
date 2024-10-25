/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.io.*;

import java.util.*;

/**
 *
 * @author amr
 */
public class MemberClassRegistrationDatabase {

    private String fileName;
    private List<MemberClassRegistration> memberClassRegistrations = new ArrayList<>();

    public MemberClassRegistrationDatabase(String fileName) {
        this.fileName = fileName;
    }

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

    public MemberClassRegistration createRecordForm(String line) {
        String[] data = line.split(",");
        String[] formatedDate = data[2].split("-");
        LocalDate d = new LocalDate(Integer.parseInt(formatedDate[0].trim()), Integer.parseInt(formatedDate[1].trim()), Integer.parseInt(formatedDate[2].trim()));
        MemberClassRegistration mCR = new MemberClassRegistration(data[0].trim(), data[1].trim(), data[3].trim(), d);
        return mCR;
    }

    public List<MemberClassRegistration> returnAllRecords() {
        return memberClassRegistrations;
    }

    public Boolean contains(String key) {
        for (MemberClassRegistration mCR : memberClassRegistrations) {
            if (mCR.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public MemberClassRegistration getRecord(String key) {
        for (MemberClassRegistration mCR : memberClassRegistrations) {
            if (mCR.getSearchKey().equals(key)) {
                return mCR;
            }
        }
        return null;
    }

    public void insertRecord(MemberClassRegistration record) {

        if (!contains(record.getSearchKey())) {
            memberClassRegistrations.add(record);
        } else {
            System.out.println("Class already exists");
        }

    }

    public void deleteRecord(String key) {

        for (MemberClassRegistration mCR : memberClassRegistrations) {
            if (mCR.getSearchKey().equals(key)) {
                memberClassRegistrations.remove(mCR);
            } else {
                System.out.println("No class match this Id");
            }
        }

    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (MemberClassRegistration mCR : memberClassRegistrations) {
                writer.write(mCR.lineRepresentation() + "\n");
            }
            writer.close();
            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

}
