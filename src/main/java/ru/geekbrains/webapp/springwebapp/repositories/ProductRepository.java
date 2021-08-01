package ru.geekbrains.webapp.springwebapp.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.webapp.springwebapp.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 80),
                new Product(2L, "Bread", 90),
                new Product(3L, "Meat", 100),
                new Product(4L, "Soda", 70)
        ));
    }


    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product fundById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void save(Product product) {
        products.add(product);
    }




}
