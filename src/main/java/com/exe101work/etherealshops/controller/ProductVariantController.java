package com.exe101work.etherealshops.controller;

import com.exe101work.etherealshops.domain.request.AddProductVariantRequest;
import com.exe101work.etherealshops.domain.response.ApiResponse;
import com.exe101work.etherealshops.service.productVariant.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/productVariants")
@RequiredArgsConstructor
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProductVariants() {
        return ResponseEntity.ok(ApiResponse.builder().data(this.productVariantService.getAllProductVariants())
                        .message("Success")
                        .code(HttpStatus.OK.value())
                .build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse> getProductVariant(@PathVariable Long productId) {
        return ResponseEntity.ok(ApiResponse.builder().data(this.productVariantService.getProductVariantById(productId))
                .message("Success")
                .code(HttpStatus.OK.value())
                .build());
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProductVariant(@RequestBody AddProductVariantRequest productVariant) {
        return ResponseEntity.ok(ApiResponse.builder().data(this.productVariantService.addProductVariant(productVariant))
                .message("Success")
                .code(HttpStatus.CREATED.value())
                .build());
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateProductVariant(@RequestBody AddProductVariantRequest productVariant,
                                                            @PathVariable Long productId) {

    }
}
