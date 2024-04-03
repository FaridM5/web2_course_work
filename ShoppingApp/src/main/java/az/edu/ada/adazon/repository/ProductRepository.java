package az.edu.ada.adazon.repository;

import az.edu.ada.adazon.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
