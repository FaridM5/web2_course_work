package az.edu.ada.adazon.controller;

import az.edu.ada.adazon.entity.Product;
import az.edu.ada.adazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Value("${app.uploaded.images.path}")
    private String uploadedImagesPath;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addUser(){
        return "addproduct";
    }


    @PostMapping("/create")
    public String createProduct(String name, double price, String description, MultipartFile image) {
        try {
            Product product = new Product(name, price, description);
            product = productService.saveProduct(product);

            if (!image.isEmpty()) {
                Path path = Paths.get(uploadedImagesPath + product.getId() + ".png");
                Files.createDirectories(path.getParent());
                Files.copy(image.getInputStream(), path);
            }

            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/product/add";
        }
    }
}
