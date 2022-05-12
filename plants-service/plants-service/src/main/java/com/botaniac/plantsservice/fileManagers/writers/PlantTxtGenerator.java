package com.botaniac.plantsservice.fileManagers.writers;

import com.botaniac.plantsservice.DTO.PlantPageDTO;
import com.botaniac.plantsservice.model.entity.plants.Plant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlantTxtGenerator implements FileGenerator<PlantPageDTO>{
    @Override
    public File generateFile(PlantPageDTO object) {
        File file = new File(object.getCommonName()+".txt");
        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(object.getCommonName());
            bufferedWriter.newLine();
            bufferedWriter.write("Scientific name: "+object.getScientificName());
            bufferedWriter.newLine();
            bufferedWriter.write("Native continent: "+object.getNativeContinent());
            bufferedWriter.newLine();
            bufferedWriter.write(object.getDescription());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return file;
    }
}
