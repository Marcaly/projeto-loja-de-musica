package projeto.lojademusica.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lojademusica.domain.entities.Product;
import projeto.lojademusica.domain.repositories.ProductRepository;
import projeto.lojademusica.domain.services.exceptions.ProductNotFoundException;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado"));
    }

    public List<Product> findAll() {
        return  productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }


}
