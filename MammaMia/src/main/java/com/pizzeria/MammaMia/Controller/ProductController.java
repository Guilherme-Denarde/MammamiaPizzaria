package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.ProductDTO;
import com.pizzeria.MammaMia.Entity.Product;
import com.pizzeria.MammaMia.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts()
                .stream()
                .map(product -> new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getFlavor(), product.getQuantity()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getProductById(@RequestParam("id") Long id) {
        return productService.getProductById(id)
                .map(product -> new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getFlavor(), product.getQuantity()))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto) {
        Product product = productService.createProduct(productDto);
        return ResponseEntity.ok(new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getFlavor(), product.getQuantity()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
