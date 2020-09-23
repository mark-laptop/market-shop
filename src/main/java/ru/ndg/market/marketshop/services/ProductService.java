package ru.ndg.market.marketshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ndg.market.marketshop.model.Product;
import ru.ndg.market.marketshop.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepositories;

    @Autowired
    public void setProductRepositories(ProductRepository productRepositories) {
        this.productRepositories = productRepositories;
    }

    public List<Product> findAll() {
        return productRepositories.findAll();
    }

    public void update(Product product) {
        productRepositories.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> byId = productRepositories.findById(id);
        return byId.orElseGet(Product::new);
    }

    public void saveProduct(Product product) {
        productRepositories.save(product);
    }

    public void deleteProductById(Long id) {
        productRepositories.deleteById(id);
    }
}
