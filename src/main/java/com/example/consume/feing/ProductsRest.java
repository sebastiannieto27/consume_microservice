package com.example.consume.feing;

import com.example.consume.dto.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "service-products", url = "localhost:8081/api/products/")
public interface ProductsRest {

    @GetMapping("/getAll")
    public List<ProductsDTO> getAll();

    @GetMapping("/{id}")
    public ProductsDTO getById(@PathVariable Long id);

    @PostMapping("/save")
    public ProductsDTO save(@RequestBody ProductsDTO productsDTO);

    @PutMapping("/update/{id}")
    public ProductsDTO update(@RequestBody ProductsDTO productsDTO, @PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id);

}
