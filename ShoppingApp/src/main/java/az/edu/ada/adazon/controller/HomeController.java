package az.edu.ada.adazon.controller;

import az.edu.ada.adazon.product.InitialProductCountHolder;
import az.edu.ada.adazon.product.PurchaseDTO;
import az.edu.ada.adazon.service.ProductService;
import az.edu.ada.adazon.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    private final PurchaseService purchaseService;

    @Autowired
    public HomeController(ProductService productService, PurchaseService purchaseService) {
        this.productService = productService;
        this.purchaseService = purchaseService;
    }

    @Autowired
    private InitialProductCountHolder initialProductCountHolder;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("initialProductCount", initialProductCountHolder.getInitialProductCount());
        System.out.println(initialProductCountHolder.getInitialProductCount());
        model.addAttribute("products", productService.findAllProducts());
        return "index";
    }


    @PostMapping("/purchase")
    public String handlePurchase(@RequestParam Long userId, @RequestParam Long productId) {
        purchaseService.createPurchase(userId, productId);
        return "redirect:/purchases";
    }

    @GetMapping("/deletePurchase")
    public String deletePurchase(@RequestParam Long userId, @RequestParam Long productId) {
        purchaseService.deletePurchase(userId, productId);
        return "redirect:/purchases";
    }


    @GetMapping("/purchases")
    public String showPurchases(Model model) {
        List<PurchaseDTO> purchases = purchaseService.findAllPurchases();
        model.addAttribute("purchases", purchases);
        return "purchases";
    }
}








