package az.edu.ada.adazon.service;

import az.edu.ada.adazon.entity.Product;
import az.edu.ada.adazon.entity.User;
import az.edu.ada.adazon.product.PurchaseDTO;
import az.edu.ada.adazon.repository.ProductRepository;
import az.edu.ada.adazon.repository.PurchaseRepository;
import az.edu.ada.adazon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<PurchaseDTO> findAllPurchases() {
        return purchaseRepository.findAllPurchases();
    }

    public void createPurchase(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        user.getProducts().add(product);
        userRepository.save(user);
    }

    public void deletePurchase(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + productId));

        user.getProducts().remove(product);
        userRepository.save(user);
    }
}