package C.Users._2.Desktop.catalog_service.service;

import C.Users._2.Desktop.catalog_service.dto.CategoryResponse;
import C.Users._2.Desktop.catalog_service.dto.CategorySaveRequest;
import C.Users._2.Desktop.catalog_service.dto.CategoryUpdateRequest;
import C.Users._2.Desktop.catalog_service.model.Category;
import C.Users._2.Desktop.catalog_service.repository.CategoryRepository;
import C.Users._2.Desktop.catalog_service.exception.CategoryNotCreatedException;
import C.Users._2.Desktop.catalog_service.exception.CategoryNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryResponse create(CategorySaveRequest categoryRequest) {
        if (categoryRequest == null) {
            throw new CategoryNotCreatedException("Категория должна присутствовать");
        }
        Category entity = new Category();
        entity.setName(categoryRequest.getName());
        entity.setDescription(categoryRequest.getDescription());
        Category save = categoryRepository.save(entity);
        return new CategoryResponse(save.getId(), save.getName(),
                save.getDescription(), save.isActive());
    }

    @Cacheable(value = "categories")
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category getOne(int id) {
        Optional<Category> foundCategory = categoryRepository.findById(id);
        return foundCategory.orElseThrow();
    }

    @Transactional
    @CacheEvict(value = "categories")
    public void update(@Valid CategoryUpdateRequest updatedCategory, int id) {
        notNull(updatedCategory, "category must not be null");
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("Category " + id + " not exist");
        }
        Category category = new Category();
        category.setName(updatedCategory.getName());
        category.setDescription(updatedCategory.getDescription());
        category.setActive(updatedCategory.isActive());
        categoryRepository.save(category);
    }
}
