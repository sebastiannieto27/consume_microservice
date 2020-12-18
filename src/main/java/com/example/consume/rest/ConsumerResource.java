package com.example.consume.rest;

import com.example.consume.dto.Consume;
import com.example.consume.dto.ProductsDTO;
import com.example.consume.service.ConsumeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(ConsumerResource.URI_PREFIX)
@AllArgsConstructor
public class ConsumerResource {

    static final String URI_PREFIX = "/api/consume/";

    private ConsumeService consumeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Consume>> getAll() {
        List<Consume> consume = consumeService.findAll();
        return ResponseEntity.ok().body(consume);
    }

    @GetMapping("/{id}/quantity/{quantity}")
    public ResponseEntity<Consume> getById(@PathVariable Long id, @PathVariable Integer quantity) {
        Consume consume = consumeService.findById(id, quantity);
        return ResponseEntity.ok().body(consume);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductsDTO> save(@RequestBody ProductsDTO productsDTO) {
        ProductsDTO products = consumeService.save(productsDTO);
        return ResponseEntity.created(URI.create(URI_PREFIX + products.getId()))
                .body(products);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductsDTO> update(@RequestBody ProductsDTO productsDTO, @PathVariable Long id) {
        ProductsDTO products = consumeService.update(productsDTO, id);
        return ResponseEntity.created(URI.create(URI_PREFIX + products.getId()))
                .body(products);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        consumeService.delete(id);
    }
}
