package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.ProductDTO;
import com.pizzeria.MammaMia.Entity.*;
import com.pizzeria.MammaMia.Repository.FlavorRepository;
import com.pizzeria.MammaMia.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FlavorRepository flavorRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setFlavor(productDto.getFlavor());
        product.setQuantity(productDto.getQuantity());
        product.setImageUrl(productDto.getImageUrl());
        product.setStars(productDto.getStars());

        if (productDto.getFlavor() != null) {
            Flavor flavor = flavorRepository.findById(Long.valueOf(productDto.getFlavor().getId()))
                    .orElseThrow(() -> new EntityNotFoundException("Flavor não encontrado"));
            product.setFlavor(flavor);
        }

        return productRepository.save(product);
    }

    public Product updateProductFromDTO(ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepository.findById(Long.valueOf(productDTO.getId()));

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            product.setFlavor(productDTO.getFlavor());
            product.setImageUrl(productDTO.getImageUrl());
            product.setStars(productDTO.getStars());

            if (productDTO.getFlavor() != null) {
                Flavor flavor = flavorRepository.findById(Long.valueOf(productDTO.getFlavor().getId()))
                        .orElseThrow(() -> new EntityNotFoundException("Flavor com o ID " + productDTO.getFlavor().getId() + " não encontrado"));
                product.setFlavor(flavor);
            } else {
                throw new EntityNotFoundException("O ID de Flavor não foi fornecido");
            }

            return productRepository.save(product);
        } else {
            throw new EntityNotFoundException("Product com o ID " + productDTO.getId() + " não encontrado");
        }
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}