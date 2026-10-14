package net.anwar.ormjpahibernatespringdata.web;

import net.anwar.ormjpahibernatespringdata.entities.Product;
import net.anwar.ormjpahibernatespringdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product productById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }


}
