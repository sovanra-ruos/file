package com.example.ecommerceapi.feature.product;


import com.example.ecommerceapi.feature.product.dto.ProductRequest;
import com.example.ecommerceapi.feature.product.dto.ProductResponse;
import com.example.ecommerceapi.feature.product.dto.ProductUpdateRequest;
import com.example.ecommerceapi.utils.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products")
    public BaseResponse<List<ProductResponse>> getAllProducts(){
        return BaseResponse.<List<ProductResponse>>ok()
                .setPayload(productService.getAllProducts());
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get product by name")
    public BaseResponse<ProductResponse> getProductByName(String name){
        return BaseResponse.<ProductResponse>ok()
                .setPayload(productService.getProductByName(name));
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public BaseResponse<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest){
        return BaseResponse.<ProductResponse>createSuccess()
                .setPayload(productService.createProduct(productRequest));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product")
    public BaseResponse<ProductResponse> updateProduct(@PathVariable Long id,@Valid @RequestBody ProductRequest productRequest){
        return BaseResponse.<ProductResponse>ok()
                .setPayload(productService.updateProduct(id, productRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product")
    public BaseResponse<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return BaseResponse.<String>ok()
                .setPayload("Product deleted successfully");
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update a product image")
    public BaseResponse<ProductResponse> updateProductImage(@PathVariable Long id, @RequestBody ProductUpdateRequest request){
        return BaseResponse.<ProductResponse>ok()
                .setPayload(productService.updateProductImage(id, request));
    }




}
