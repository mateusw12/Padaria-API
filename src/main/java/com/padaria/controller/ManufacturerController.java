package com.padaria.controller;

import com.padaria.mapper.ViewModelToModel;
import com.padaria.model.ManufacturerModel;
import com.padaria.service.ManufacturerService;
import com.padaria.viewModel.ManufacturerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/cadastro/fabricante")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ViewModelToModel viewModelToModel;

   @GetMapping(value = "/{id}")
    public ResponseEntity<ManufacturerModel> findById(@PathVariable Long id){
       ManufacturerModel manufacturerModel = manufacturerService.findById(id);
       return ResponseEntity.ok().body(manufacturerModel);
   }

    @GetMapping()
    public ResponseEntity<List<ManufacturerModel>> findAll(){
        List<ManufacturerModel> manufacturersModel = (List<ManufacturerModel>) manufacturerService.findALl();
        return new ResponseEntity<List<ManufacturerModel>>(manufacturersModel, HttpStatus.OK);
    }

    @PostMapping
    public ManufacturerModel create(@RequestBody ManufacturerViewModel manufacturerViewModel){
        ManufacturerModel manufacturerModel = viewModelToModel.toManufacturer(manufacturerViewModel);
        return manufacturerService.create(manufacturerModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ManufacturerModel> delete(@PathVariable("id") ManufacturerModel manufacturerModel){
        return manufacturerService.delete(manufacturerModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerModel> update(@PathVariable("id") ManufacturerModel empresaAntigo,
                                               @RequestBody ManufacturerModel empresaAtualizado){

        return new ResponseEntity<ManufacturerModel>(empresaAntigo, HttpStatus.OK);
    }

}
