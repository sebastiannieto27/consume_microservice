package com.example.consume.service;

import com.example.consume.dto.Consume;
import com.example.consume.dto.ProductsDTO;
import com.example.consume.feing.ProductsRest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConsumeService {

    private ProductsRest productsRest;


    public List<Consume> findAll() {
        return productsRest.getAll().stream().map(p -> new Consume(p, 1)).collect(Collectors.toList());
    }

    public Consume findById(Long id, Integer quantity) {
        return new Consume(productsRest.getById(id), quantity);
    }

    public ProductsDTO save(ProductsDTO productsDTO) {
        return productsRest.save(productsDTO);
    }

    public ProductsDTO update(ProductsDTO productsDTO, Long id) {
        return productsRest.update(productsDTO, id);
    }

    public void delete(Long id) {
        productsRest.delete(id);
    }

}
