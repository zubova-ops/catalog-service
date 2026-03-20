package C.Users._2.Desktop.catalog_service.mapper;

import C.Users._2.Desktop.catalog_service.dto.ProductDTO;
import C.Users._2.Desktop.catalog_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product productDTOToProduct(ProductDTO productDTO);
}
