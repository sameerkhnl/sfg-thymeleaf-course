package guru.springframework.services;

import guru.springframework.domains.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Integer id);
    List<Product> listProducts();
}
