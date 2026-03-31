package C.Users._2.Desktop.catalog_service.controller;

import C.Users._2.Desktop.catalog_service.dto.CategorySaveRequest;
import C.Users._2.Desktop.catalog_service.dto.CategoryResponse;
import C.Users._2.Desktop.catalog_service.dto.CategoryUpdateRequest;
import C.Users._2.Desktop.catalog_service.model.Category;
import C.Users._2.Desktop.catalog_service.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse save(@RequestBody @Valid CategorySaveRequest categoryRequest) {
        return categoryService.create(categoryRequest);
    }
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.getOne(id);
    }

    @PutMapping("/categories/{id}")
    public void update(@RequestBody @Valid CategoryUpdateRequest categoryUpdateRequest, @PathVariable int id) {
        categoryService.update(categoryUpdateRequest, id);
    }

}
