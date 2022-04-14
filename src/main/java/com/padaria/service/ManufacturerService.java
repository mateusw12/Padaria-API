package com.padaria.service;

import com.padaria.exception.request.EntityNotFountException;
import com.padaria.mapper.ModelToViewModel;
import com.padaria.mapper.ViewModelToModel;
import com.padaria.model.ManufacturerModel;
import com.padaria.repository.ManufacturerRepository;
import com.padaria.viewModel.ManufacturerViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ManufacturerService{

    private ManufacturerRepository manufacturerRepository;

    private ViewModelToModel viewModelToModel;

    private ModelToViewModel modelToViewModel;

    public ManufacturerModel findById(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(
                () -> new EntityNotFountException("Código não encontrado" + id)
        );
    }

    public ResponseEntity<List<ManufacturerModel>> findALl() {
        List<ManufacturerModel> manufacturerModels = (List<ManufacturerModel>) manufacturerRepository.findAll();
        return new ResponseEntity<List<ManufacturerModel>>(manufacturerModels, HttpStatus.OK);
    }

    public ManufacturerModel create(ManufacturerModel manufacturerModel){
        return manufacturerRepository.save(manufacturerModel);
    }

    public ResponseEntity<ManufacturerModel> delete(Long id){
        manufacturerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ManufacturerModel update(ManufacturerModel manufacturerOldModel, ManufacturerModel manufacturerNew){
        ManufacturerViewModel manufacturerOldViewModel = modelToViewModel.toManufacturer(manufacturerOldModel);
        ManufacturerViewModel manufacturerNewViewModel = modelToViewModel.toManufacturer(manufacturerNew);

        manufacturerOldViewModel.setId(manufacturerNewViewModel.getId());
        manufacturerOldViewModel.setName(manufacturerNewViewModel.getName());

        return manufacturerRepository.save(manufacturerOldModel);
    }

}
