package com.exe101work.etherealshops.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_variant")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int inventory;
    BigDecimal selling_price;

    @OneToMany(mappedBy = "product_variant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Image> images;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "color_id")
    Color color;

    @ManyToOne
    @JoinColumn(name = "size_id")
    Size size;
    Instant createdAt;
    Instant updatedAt;
    String createdBy;
    String updatedBy;
}
