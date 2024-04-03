package az.edu.ada.adazon.repository;


import az.edu.ada.adazon.entity.Product;
import az.edu.ada.adazon.product.PurchaseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import az.edu.ada.adazon.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.*;


public interface PurchaseRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new az.edu.ada.adazon.product.PurchaseDTO(u.id, u.username, u.email, p.name, p.description, p.price, p.id) " +
            "FROM User u JOIN u.products p")
    List<PurchaseDTO> findAllPurchases();

}