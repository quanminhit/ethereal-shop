package com.exe101work.etherealshops.domain.request;

import com.exe101work.etherealshops.entity.Category;
import com.exe101work.etherealshops.entity.Image;
import com.exe101work.etherealshops.util.constant.ProductStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductVariantRequest {
    private String name;
    private String brand;
    private BigDecimal base_price;
    private String description;
    private ProductStatusEnum status;
    private Image image;
    private Category category;
    private Instant createdAt;
    private Instant updatedAt;
    private String createdBy;
    private String updatedBy;
}
