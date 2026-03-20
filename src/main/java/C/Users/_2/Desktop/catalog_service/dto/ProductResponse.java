package C.Users._2.Desktop.catalog_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponse {
    private int id;
    private String sku;
    private String name;
    private int price;
    private Currency currency;
    private boolean isActive;
}
