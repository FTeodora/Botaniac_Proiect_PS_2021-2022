package com.botaniac.plantsservice.fileManagers.readers;

import com.botaniac.plantsservice.DTO.CreatePlantDTO;
import com.botaniac.plantsservice.model.enums.PlantType;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class CSVReader<A> implements FileReader<List<A>>{
    public static String TYPE = "text/csv";
    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public List<A> readFile(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            return csvParser.getRecords().stream().map(x->
                        recordToObject(x)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
    public abstract A recordToObject(CSVRecord x);
}
