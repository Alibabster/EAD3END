package com.example.mid.controller;
import com.example.mid.Service.ServiceService;
import com.example.mid.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService productService;

    @GetMapping
    public List<Service> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Service> getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PostMapping
    public void createProduct(@RequestBody Service product){
        productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Service product){
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
