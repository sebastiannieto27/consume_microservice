package com.example.consume.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductsDTO {

    private Long id;
    private String name;
    private Double price;
    private Date createAt;

}
