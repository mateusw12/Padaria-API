package com.padaria.mapper;

import com.padaria.model.ManufacturerModel;
import com.padaria.viewModel.ManufacturerViewModel;
import org.modelmapper.ModelMapper;

public class ModelToViewModel {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ManufacturerViewModel toManufacturer (ManufacturerModel manufacturerModel){
        return modelMapper.map(manufacturerModel, ManufacturerViewModel.class);
    }

}
