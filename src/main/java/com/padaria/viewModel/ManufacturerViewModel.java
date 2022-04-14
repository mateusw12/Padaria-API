package com.padaria.viewModel;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

@Data()
public class ManufacturerViewModel implements Serializable {

    @NotBlank(message = "Código está inválido!")
    private Integer id;

    @NotBlank(message = "Nome esá inválido!")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
