package com.botaniac.plantsservice.fileManagers.readers;

import com.botaniac.plantsservice.model.entity.plants.Plant;
import com.botaniac.plantsservice.model.enums.PlantType;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CSVPlantReader implements FileReader<List<Plant>> {
    public static String TYPE = "text/csv";
    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public List<Plant> readFile(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
           return csvParser.getRecords().stream().map(x->  Plant.builder().commonName(x.get(0)).
                        scientificName(x.get(3))
                        .description(x.get(1)).nativeContinent(x.get(2))
                        .type(PlantType.valueOf(x.get(4).toUpperCase(Locale.ROOT))).build()
            ).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
