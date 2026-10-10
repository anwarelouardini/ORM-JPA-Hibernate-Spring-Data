package net.anwar.ormjpahibernatespringdata.repository;

import net.anwar.ormjpahibernatespringdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContains(String name);

    @Query("select p from Product p where p.name like :mc")
    List<Product> search(@Param("mc") String mc);
}
