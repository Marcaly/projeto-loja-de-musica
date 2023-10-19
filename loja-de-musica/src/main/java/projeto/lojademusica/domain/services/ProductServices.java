package projeto.lojademusica.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lojademusica.domain.entities.Product;
import projeto.lojademusica.domain.entities.ProductDTO;
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

    public Product update(Product product) {
        Product newProduct = findProductById(product.getId());
        UpdateData(newProduct, product);
        return productRepository.save(newProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    private void UpdateData(Product newProduct, Product product) {
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
    }




    public Product FromDTO(ProductDTO productDTO) {
        return new Product(productDTO.getId(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getQuantity());
    }
}
