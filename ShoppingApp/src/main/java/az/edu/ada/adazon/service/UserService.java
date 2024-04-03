package az.edu.ada.adazon.service;

import az.edu.ada.adazon.entity.User;
import az.edu.ada.adazon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public Page<User> listUser(int page, int size, String sortField, String sortDir){
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageable);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> findByCriteria(Long id, String username, String name, String surname, String email, String phone, LocalDate dateOfBirth) {
        return userRepository.findAll((Specification<User>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (id != null) predicates.add(cb.equal(root.get("id"), id));
            if (username != null) predicates.add(cb.like(root.get("username"), "%" + username + "%"));
            if (name != null) predicates.add(cb.like(root.get("name"), "%" + name + "%"));
            if (surname != null) predicates.add(cb.like(root.get("surname"), "%" + surname + "%"));
            if (email != null) predicates.add(cb.like(root.get("email"), "%" + email + "%"));
            if (phone != null) predicates.add(cb.like(root.get("phone"), "%" + phone + "%"));
            if (dateOfBirth != null) predicates.add(cb.equal(root.get("dateOfBirth"), dateOfBirth));

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

    public List<User> findUsersByProductName(String productName) {
        return userRepository.findUsersByProductName(productName);
    }


}