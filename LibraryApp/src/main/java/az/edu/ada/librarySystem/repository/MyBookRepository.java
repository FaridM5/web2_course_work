package az.edu.ada.librarySystem.repository;

import az.edu.ada.librarySystem.entity.myBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<myBook,Integer> {

}