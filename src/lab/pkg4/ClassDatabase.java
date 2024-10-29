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
public class ClassDatabase extends Database<Class>{

  

  public ClassDatabase(String fileName) {
        super(fileName); 
    }

    @Override
    public Class createRecordFrom(String line) {
        String[] data = line.split(",");
        Class c = new Class(data[0].trim(), data[1].trim(), data[2].trim(), Integer.parseInt(data[3].trim()), Integer.parseInt(data[4].trim()));
        return c;
    }
    
    



}
