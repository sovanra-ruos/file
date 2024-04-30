package com.example.ecommerceapi.feature.product;

import com.example.ecommerceapi.domain.Brand;
import com.example.ecommerceapi.domain.Category;
import com.example.ecommerceapi.domain.Product;
import com.example.ecommerceapi.feature.brand.BrandRepository;
import com.example.ecommerceapi.feature.category.CategoryRepository;
import com.example.ecommerceapi.feature.product.dto.ProductRequest;
import com.example.ecommerceapi.feature.product.dto.ProductResponse;
import com.example.ecommerceapi.feature.product.dto.ProductUpdateRequest;
import com.example.ecommerceapi.mapper.ProductMapper;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toProductResponse).toList();
    }

    @Override
    public ProductResponse getProductByName(String name) {
        Product product = productRepository.findProductByName(name)
                .orElseThrow(()-> new NoSuchElementException("Product not found"));
        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        Category category = categoryRepository.findById(productRequest.categoryId())
                .orElseThrow(()-> new NoSuchElementException("Category not found"));
        Brand brand = brandRepository.findById(productRequest.brandId())
                .orElseThrow(()-> new NoSuchElementException("Brand not found"));
        product.setCategory(category);
        product.setBrand(brand);
        product.setImages(productRequest.images());
        productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Product not found"));
        Category category = categoryRepository.findById(productRequest.categoryId())
                .orElseThrow(()-> new NoSuchElementException("Category not found"));
        Brand brand = brandRepository.findById(productRequest.brandId())
                .orElseThrow(()-> new NoSuchElementException("Brand not found"));
        product.setCategory(category);
        product.setBrand(brand);
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());
        product.setImages(productRequest.images());
        productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
        product.setIsDeleted(true);
        productRepository.save(product);
    }

    @Override
    public ProductResponse updateProductImage(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Product not found"));
        product.setImages(request.images());
        productRepository.save(product);
        return productMapper.toProductResponse(product);
    }
}
