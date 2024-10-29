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
public class TrainerDatabase extends Database<Trainer> {

    

    public TrainerDatabase(String fileName) {
        super(fileName);
    }

  
    @Override
    public Trainer createRecordFrom(String line) {
        String[] data = line.split(",");
        Trainer t = new Trainer(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
        return t;
    }

    

}
