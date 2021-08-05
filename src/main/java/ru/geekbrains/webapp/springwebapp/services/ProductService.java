package ru.geekbrains.webapp.springwebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.webapp.springwebapp.model.Product;
import ru.geekbrains.webapp.springwebapp.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product fundById(Long id) {
        return productRepository.fundById(id);
    }


    public void save (Product product) {
        productRepository.save(product);
    }




    public Product minusCost (Long id) {
        Product product = productRepository.fundById(id);
        product.setCost(product.getCost() - 1);
        return product;
    }

    public Product plusCost (Long id) {
        Product product = productRepository.fundById(id);
        product.setCost(product.getCost() + 1);
        return product;
    }
}
