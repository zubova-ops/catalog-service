package C.Users._2.Desktop.catalog_service.controller;

import C.Users._2.Desktop.catalog_service.dto.ProductDTO;
import C.Users._2.Desktop.catalog_service.dto.ProductSaveRequest;
import C.Users._2.Desktop.catalog_service.mapper.ProductMapper;
import C.Users._2.Desktop.catalog_service.model.Product;
import C.Users._2.Desktop.catalog_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void save(@RequestBody @Valid ProductSaveRequest productSaveRequest) {
        productService.create(productSaveRequest);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id) {
        return productService.getOne(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, ProductDTO productDTO) {
        productService.update(ProductMapper.INSTANCE.productDTOToProduct(productDTO), id);
    }

    @PatchMapping("{id}/price")
    public void updatePrice(@PathVariable int id, int newPrice) {
        productService.updatePrice(id, newPrice);
    }

    @PatchMapping("{id}/deactivate")
    public void updateActive(@PathVariable int id) {
        productService.deActiveProduct(id);
    }


}

