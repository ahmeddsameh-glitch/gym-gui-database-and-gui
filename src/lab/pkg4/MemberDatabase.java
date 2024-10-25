/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.*;
import java.io.*;

/**
 *
 * @author amr
 */
public class MemberDatabase implements Database<Member> {

    private String fileName;
    private List<Member> members = new ArrayList<>();

    public MemberDatabase(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void ReadFromFile() {
        try {
            File myFile = new File(fileName);
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                Member m = createRecordForm(scanner.nextLine());
                members.add(m);
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error (File not found)");
        }
    }

    @Override
    public Member createRecordForm(String line) {
        String[] data = line.split(",");
        Member m = new Member(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim());
        return m;
    }

    @Override
    public List<Member> returnAllRecords() {
        return members;
    }

    @Override
    public Boolean contains(String key) {
        for (Member m : members) {
            if (m.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Member getRecord(String key) {
        for (Member m : members) {
            if (m.getSearchKey().equals(key)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void insertRecord(Member record) {

        if (!contains(record.getSearchKey())) {
            members.add(record);
        } else {
            System.out.println("Member already exists");
        }

    }

    @Override
    public void deleteRecord(String key) {

        boolean found = false;
        Iterator<Member> iterator = members.iterator();

        while (iterator.hasNext()) {
            Member m = iterator.next();
            if (m.getSearchKey().equals(key)) {
                iterator.remove();
                found = true;
                System.out.println("Member deleted successfully.");
                return;
            }

        }
    }

    @Override
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Member m : members) {
                writer.write(m.lineRepresentation() + "\n");
            }
            writer.close();
//            System.out.println("Data updated Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");

        }

    }

}
