package C.Users._2.Desktop.catalog_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryUpdateRequest {

    private String name;
    private String description;
    private boolean isActive;



}
