package C.Users._2.Desktop.catalog_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponse {
    private int id;
    private String name;
    private String description;
    private boolean isActive;
}
