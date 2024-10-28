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
    public void readFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                MemberClassRegistration mCR = createRecordFrom(scanner.nextLine());
                records.add(mCR);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }
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
    public List<MemberClassRegistration> returnAllRecords() {
        return records;
    }

    @Override
    public Boolean contains(String key) {
        for (MemberClassRegistration mCR : records) {
            if (mCR.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MemberClassRegistration getRecord(String key) {
        for (MemberClassRegistration mCR : records) {
            if (mCR.getSearchKey().equals(key)) {
                return mCR;
            }
        }
        return null;
    }

    @Override
    public void insertRecord(MemberClassRegistration record) {

        if (!contains(record.getSearchKey())) {
            records.add(record);
        } else {
            System.out.println("Class already exists");
        }

    }

    @Override
    public void deleteRecord(String key) {

        boolean found = false;
        Iterator<MemberClassRegistration> iterator = records.iterator();

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
            for (MemberClassRegistration mCR : records) {
                writer.write(mCR.lineRepresentation() + "\n");
            }
            writer.close();
//            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

   
}
