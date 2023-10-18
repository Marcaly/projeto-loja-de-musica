package projeto.lojademusica.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.lojademusica.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
