/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4;

import java.util.List;

/**
 *
 * @author amr
 * @param <D>
 */
public interface Database<D> {

    public void ReadFromFile();

    public D createRecordForm(String line);

    public List<D> returnAllRecords();

    public Boolean contains(String key);

    public D getRecord(String key);

    public void insertRecord(D record);

    public void deleteRecord(String key);

    public void saveToFile();

}
