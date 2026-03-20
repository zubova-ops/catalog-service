package C.Users._2.Desktop.catalog_service.dto;

import C.Users._2.Desktop.catalog_service.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Currency;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;

    private String name;

    private String description;

    private String sku;

    private Category categoryId;

    private int price;

    private Currency currency;

    private boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private int version;
}
