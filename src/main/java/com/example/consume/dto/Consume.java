package com.example.consume.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consume {

    private ProductsDTO productsDTO;
    private Integer quantity;

    public Double getTotal(){
        return productsDTO.getPrice()*quantity.doubleValue();
    }

}
