package az.edu.ada.adazon.product;

import az.edu.ada.adazon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class StartupService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InitialProductCountHolder initialProductCountHolder;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        int count = (int) productRepository.count();
        initialProductCountHolder.setInitialProductCount(count);
    }
}
