package C.Users._2.Desktop.catalog_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorResponse {
    private String code;
    private String message;
}
