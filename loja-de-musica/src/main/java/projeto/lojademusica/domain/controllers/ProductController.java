package projeto.lojademusica.domain.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projeto.lojademusica.domain.entities.Product;
import projeto.lojademusica.domain.entities.ProductDTO;
import projeto.lojademusica.domain.services.ProductServices;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ProductServices productServices;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable @NotNull @Positive Long id) {
        Product product = productServices.findProductById(id);
        return ResponseEntity.ok(new ProductDTO(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = productServices.findAll();
        List<ProductDTO> listDTO = list.stream().map(ProductDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductDTO productDTO) {
        Product product = productServices.FromDTO(productDTO);
        productServices.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody @Valid ProductDTO productDTO, @PathVariable @NotNull @Positive Long id) {
        Product product = productServices.FromDTO(productDTO);
        product.setId(id);
        productServices.update(product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable @NotNull @Positive Long id){
        productServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
