package C.Users._2.Desktop.catalog_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Products")
public class Product {
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

    @Column(name = "sku")
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category categoryId;

    @Column(name = "price")
    @NotEmpty
    private int price;

    @Column(name = "currency")
    @NotEmpty
    private Currency currency;

    @Column(name = "active")
    @NotEmpty
    private boolean isActive;

    @Column(name = "created_at")
    @NotEmpty
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @NotEmpty
    private LocalDateTime updatedAt;

    @Column(name = "version")
    @NotEmpty
    private int version;

    public Product(String name, String description, String sku, Category categoryId, int price, Currency currency,
                   boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, int version) {
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.categoryId = categoryId;
        this.price = price;
        this.currency = currency;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.version = version;
    }
}
