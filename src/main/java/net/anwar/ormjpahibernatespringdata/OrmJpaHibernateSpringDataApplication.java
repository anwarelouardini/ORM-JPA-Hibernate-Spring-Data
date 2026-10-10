package net.anwar.ormjpahibernatespringdata;

import net.anwar.ormjpahibernatespringdata.entities.Product;
import net.anwar.ormjpahibernatespringdata.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmJpaHibernateSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product(null, "Laptop", 8500, 10));
            productRepository.save(new Product(null, "Phone", 5500, 10));
            productRepository.save(new Product(null, "Earbuds", 2500, 10));

            List<Product> products = productRepository.findAll();
            products.forEach(System.out::println);

            System.out.println("**********************");
            Product product = productRepository.findById(1L).get();
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQuantity());
            System.out.println("**********************");

        };
    }

}
