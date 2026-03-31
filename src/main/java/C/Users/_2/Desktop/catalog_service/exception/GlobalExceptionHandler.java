package C.Users._2.Desktop.catalog_service.exception;

import C.Users._2.Desktop.catalog_service.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleProductNotFoundStock(ProductNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiErrorResponse.builder()
                        .code("PRODUCT_NOT_FOUND")
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(CategoryNotCreatedException.class)
    public ResponseEntity<ApiErrorResponse> handleCategoryNotCreated(CategoryNotCreatedException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiErrorResponse.builder()
                        .code("CATEGORY_NOT_CREATED")
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCategoryNotFound(CategoryNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiErrorResponse.builder()
                        .code("CATEGORY_NOT_FOUND")
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler(ProductNotCreatedException.class)
    public ResponseEntity<ApiErrorResponse> handleProductNotCreated(ProductNotCreatedException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiErrorResponse.builder()
                        .code("PRODUCT_NOT_CREATED")
                        .message(exception.getMessage())
                        .build());
    }

}