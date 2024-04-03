package az.edu.ada.adazon.repository;

import az.edu.ada.adazon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query(value = "SELECT u.* FROM users u INNER JOIN user_product up ON u.id = up.user_id INNER JOIN products p ON p.id = up.product_id WHERE p.name = :productName", nativeQuery = true)
    List<User> findUsersByProductName(@Param("productName") String productName);
}
