package com.botaniac.plantsservice.fileManagers.readers;

import com.botaniac.plantsservice.DTO.CreatePlantDTO;
import com.botaniac.plantsservice.model.enums.PlantType;

import org.apache.commons.csv.CSVRecord;

import java.util.Locale;


public class CSVPlantReader extends CSVReader<CreatePlantDTO> {
    @Override
    public CreatePlantDTO recordToObject(CSVRecord x) {
        CreatePlantDTO p=new CreatePlantDTO();
        p.setCommonName(x.get(0));
        p.setScientificName(x.get(3));
        p.setDescription(x.get(1));
        p.setNativeContinent(x.get(2));
        p.setType(PlantType.valueOf(x.get(4).toUpperCase(Locale.ROOT)));
        return p;
    }
}
