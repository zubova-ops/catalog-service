package C.Users._2.Desktop.catalog_service.repository;

import C.Users._2.Desktop.catalog_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
