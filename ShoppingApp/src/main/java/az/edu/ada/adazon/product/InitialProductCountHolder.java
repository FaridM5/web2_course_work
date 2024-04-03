package az.edu.ada.adazon.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class InitialProductCountHolder {
    private int initialProductCount;
}