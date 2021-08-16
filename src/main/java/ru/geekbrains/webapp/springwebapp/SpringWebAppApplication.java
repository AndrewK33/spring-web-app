package ru.geekbrains.webapp.springwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebAppApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product(9, "Banana", 230);

        Product byId = productDate.findById(3);
        List<Product> all = productDate.findAll();
        productDate.deleteById(2);
        productDate.insert(product);
        productDate.update(product);

    }
}
