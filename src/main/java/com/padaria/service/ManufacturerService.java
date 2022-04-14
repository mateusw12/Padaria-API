package com.padaria.service;

import com.padaria.exceptions.EntityNotFountException;
import com.padaria.mapper.ViewModelToModel;
import com.padaria.model.ManufacturerModel;
import com.padaria.repository.ManufacturerRepository;
import com.padaria.viewModel.ManufacturerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ViewModelToModel viewModelToModel;

    public ManufacturerModel findById(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(
                () -> new EntityNotFountException("Id not found" + id)
        );
    }

    public ResponseEntity<List<ManufacturerModel>> findALl() {
        List<ManufacturerModel> lista = (List<ManufacturerModel>) manufacturerRepository.findAll();
        return new ResponseEntity<List<ManufacturerModel>>(lista, HttpStatus.OK);
    }

    public ManufacturerModel create(ManufacturerModel manufacturerModel){
        return manufacturerRepository.save(manufacturerModel);
    }

    public ResponseEntity<ManufacturerModel> delete(ManufacturerModel manufacturerModel){
        manufacturerRepository.delete(manufacturerModel);
        return ResponseEntity.ok().build();
    }

    public ManufacturerModel update(ManufacturerViewModel manufacturerViewModel){
         ManufacturerModel manufacturerModel = viewModelToModel.toManufacturer(manufacturerViewModel);
        return manufacturerRepository.save(manufacturerModel);
    }

}
