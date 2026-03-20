package C.Users._2.Desktop.catalog_service.service;

import C.Users._2.Desktop.catalog_service.dto.ProductResponse;
import C.Users._2.Desktop.catalog_service.dto.ProductSaveRequest;
import C.Users._2.Desktop.catalog_service.model.Product;
import C.Users._2.Desktop.catalog_service.repository.ProductRepository;
import C.Users._2.Desktop.catalog_service.util.ProductNotCreatedException;
import C.Users._2.Desktop.catalog_service.util.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse create(ProductSaveRequest productSaveRequest) {
        if (productSaveRequest == null) {
            throw new ProductNotCreatedException("Продукт должен присутствовать");
        }
        Product entity = new Product();
        entity.setSku(productSaveRequest.getSku());
        entity.setName(productSaveRequest.getName());
        entity.setDescription(productSaveRequest.getDescription());
        entity.setCategoryId(productSaveRequest.getCategoryId());
        entity.setPrice(productSaveRequest.getPrice());
        entity.setCurrency(productSaveRequest.getCurrency());
        entity.setActive(productSaveRequest.isActive());
        Product save = productRepository.save(entity);
        return new ProductResponse(save.getId(), save.getSku(), save.getName(), save.getPrice(),
                save.getCurrency(), save.isActive());
    }

    @Cacheable(value = "products")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getOne(int id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElseThrow();
    }

    @Transactional
    @CacheEvict(value = "products")
    public void update(Product updatedProduct, int id) {
        notNull(updatedProduct, "product must not be null");
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product " + id + " not exist");
        }
        updatedProduct.setId(id);
        productRepository.save(updatedProduct);
    }

    public void updatePrice(int id, int newPrice) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product " + id + " not exist");
        }
        productRepository.updatePriceById(id, newPrice);
    }

    public void deActiveProduct(int id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product " + id + " not exist");
        }
        productRepository.updateActiveById(id);
    }
}
