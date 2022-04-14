package com.padaria.mapper;

import com.padaria.model.ManufacturerModel;
import com.padaria.viewModel.ManufacturerViewModel;
import org.modelmapper.ModelMapper;

public class ViewModelToModel {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ManufacturerModel toManufacturer (ManufacturerViewModel manufacturerViewModel){
        return modelMapper.map(manufacturerViewModel, ManufacturerModel.class);
    }
}


