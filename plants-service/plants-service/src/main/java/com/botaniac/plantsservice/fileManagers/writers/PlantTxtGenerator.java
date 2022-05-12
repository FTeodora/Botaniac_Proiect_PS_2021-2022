package com.botaniac.plantsservice.fileManagers.writers;

import com.botaniac.plantsservice.DTO.PlantPageDTO;
import com.botaniac.plantsservice.model.entity.plants.Plant;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class PlantTxtGenerator implements FileGenerator<PlantPageDTO>{
    @Override
    public File generateFile(PlantPageDTO object) {

        try{
            File file = new File("./src/main/resources/"+object.getCommonName()+".txt");
            System.out.println(file.getPath());
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
            return file;
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }

    }
}
