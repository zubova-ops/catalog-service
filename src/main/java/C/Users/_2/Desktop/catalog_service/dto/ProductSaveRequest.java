package C.Users._2.Desktop.catalog_service.dto;

import C.Users._2.Desktop.catalog_service.model.Category;
import lombok.*;

import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductSaveRequest {
    private String name;
    private String description;
    private String sku;
    private Category categoryId;
    private int price;
    private Currency currency;
    private boolean isActive;
}
