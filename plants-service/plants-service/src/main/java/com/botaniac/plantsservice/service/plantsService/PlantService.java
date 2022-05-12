package com.botaniac.plantsservice.service.plantsService;

import com.botaniac.plantsservice.DTO.CreatePlantDTO;
import com.botaniac.plantsservice.DTO.PlantPageDTO;
import com.botaniac.plantsservice.DTO.ViewPlantDTO;
import com.botaniac.plantsservice.fileManagers.readers.CSVPlantReader;
import com.botaniac.plantsservice.fileManagers.writers.PlantTxtGenerator;
import com.botaniac.plantsservice.model.entity.plants.Plant;
import com.botaniac.plantsservice.repo.plantsRepo.PlantRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {
    @Autowired
    private PlantRepo plantRepo;
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();
    private final int MAX_PLANTS=20;
    public List<CreatePlantDTO> parsePlants(MultipartFile file) throws IOException{
        CSVPlantReader reader=new CSVPlantReader();
        return reader.readFile(file.getInputStream());
    }
    public File generateTxt(PlantPageDTO plant){
        return plant.generateWriter().generateFile(plant);
    }
    public void addPlants(List<CreatePlantDTO> plants) {
        List<Plant> converted=plants.stream().map(p->
            Plant.builder().commonName(p.getCommonName()).scientificName(p.getScientificName())
                    .nativeContinent(p.getNativeContinent()).description(p.getDescription()).type(p.getType()).build()
        ).collect(Collectors.toList());
        plantRepo.saveAll(converted);
    }
    public void addPlant(CreatePlantDTO plant){
        plantRepo.save(Plant.builder().commonName(plant.getCommonName()).scientificName(plant.getScientificName())
                .nativeContinent(plant.getNativeContinent()).description(plant.getDescription()).type(plant.getType()).build());
    }
    public Page<ViewPlantDTO> browsePlants(int offset){
        Page<Plant> entities = plantRepo.findAll(PageRequest.of(offset,MAX_PLANTS));
        Page<ViewPlantDTO> dtoPage = entities.map(obj -> {
            return modelMapper.map(obj,ViewPlantDTO.class);
        });
        return dtoPage;
    }
    public Plant getPlant(String id){
        return plantRepo.findById(id).get();
    }
}
