package C.Users._2.Desktop.catalog_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    @Column(name = "description")
    @NotEmpty
    @Size(min = 2, max = 128)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> products;

    @Column(name = "active")
    @NotEmpty
    private boolean isActive;

    @Column(name = "created_at")
    @NotEmpty
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @NotEmpty
    private LocalDateTime updatedAt;

    public Category() {
        new Category();
    }

    public Category(String name, String description, List<Product> products, boolean isActive,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.description = description;
        this.products = products;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
