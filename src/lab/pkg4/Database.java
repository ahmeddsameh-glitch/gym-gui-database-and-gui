/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amr
 * @param <D>
 */
public abstract class Database<D> {

    protected String fileName;
    protected List<D> records = new ArrayList<>();

    public Database(String fileName) {
        this.fileName = fileName;
    }

    public abstract void readFromFile();

    public abstract D createRecordFrom(String line);

    public abstract List<D> returnAllRecords();

    public abstract Boolean contains(String key);

    public abstract D getRecord(String key);

    public abstract void insertRecord(D record);

    public abstract void deleteRecord(String key);

    public abstract void saveToFile();
    
    
}
