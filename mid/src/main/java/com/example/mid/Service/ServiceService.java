package com.example.mid.Service;

import com.example.mid.model.Service;
import com.example.mid.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository productRepository;

    public List<Service> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Service> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public void createProduct(Service product ) {

        Service newProduct = new Service();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());


        productRepository.saveAndFlush(newProduct);

    }

    public void updateProduct(Long id, Service product ) {
        Service productDb = productRepository.findById(id).orElse(null);

        if (productDb != null) {
            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());
            productRepository.saveAndFlush(productDb);
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}















