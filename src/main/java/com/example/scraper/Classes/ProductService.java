package com.example.scraper.Classes;

import com.example.scraper.DAL.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public void AddUser(Product product){
        productRepository.save(product);
    }
}
