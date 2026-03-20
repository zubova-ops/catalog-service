package C.Users._2.Desktop.catalog_service.repository;

import C.Users._2.Desktop.catalog_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :id")
    void updatePriceById(@Param("id") int id, @Param("price") int newPrice);

    @Modifying
    @Query("UPDATE Product p SET p.isActive = :false WHERE p.id = :id")
    void updateActiveById(@Param("id") int id);
}
