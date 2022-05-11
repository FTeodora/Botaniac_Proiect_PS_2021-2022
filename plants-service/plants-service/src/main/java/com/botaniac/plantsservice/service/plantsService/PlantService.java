package com.botaniac.plantsservice.service.plantsService;

import com.botaniac.plantsservice.DTO.CreatePlantDTO;
import com.botaniac.plantsservice.DTO.ViewPlantDTO;
import com.botaniac.plantsservice.fileManagers.readers.CSVPlantReader;
import com.botaniac.plantsservice.model.entity.plants.Plant;
import com.botaniac.plantsservice.repo.plantsRepo.PlantRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Plant> parsePlants(MultipartFile file) throws IOException{
        CSVPlantReader reader=new CSVPlantReader();
        return reader.readFile(file.getInputStream());
    }
    public void addPlants(List<Plant> plants) {
        plantRepo.saveAll(plants);
    }
    public void addPlant(CreatePlantDTO plant){
        plantRepo.save(modelMapper.map(plant,Plant.class));
    }
    public List<ViewPlantDTO> browsePlants(int offset){
        Page<Plant> entities = plantRepo.findAll(PageRequest.of(offset,MAX_PLANTS));
        return entities.getContent().stream().map(x->modelMapper.map(x,ViewPlantDTO.class)).collect(Collectors.toList());
    }
}
