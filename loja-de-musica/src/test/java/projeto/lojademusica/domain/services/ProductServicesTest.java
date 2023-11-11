package projeto.lojademusica.domain.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import projeto.lojademusica.domain.entities.Product;
import projeto.lojademusica.domain.repositories.ProductRepository;
import projeto.lojademusica.domain.services.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PropertyPermission;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductServicesTest {

    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductServices services;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @DisplayName("Should return product who have the id")
    @Test
    void findProductById() {

        Product tv = new Product(1L, "TV", 2000.0, 10);
        when(repository.findById(1L)).thenReturn(Optional.of(tv));

        Product resultado = services.findProductById(1L);
        assertEquals(tv,resultado);
    }
    @DisplayName("Should return an ProductNotFoundException")
    @Test
    void dontFindProductById() {
        Product tv = new Product(1L, "TV", 2000.0, 10);

        Long idNaoExistente = 999L;
        when(repository.findById(idNaoExistente)).thenReturn(Optional.empty());

        Exception excecaoLancada = assertThrows(ProductNotFoundException.class, () -> services.findProductById(idNaoExistente));
        assertEquals("Produto não encontrado", excecaoLancada.getMessage());
    }

    @DisplayName("should find all products and return false for list is empty")
    @Test
    void findAll() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1L, "Celular", 1500.0, 34));
        list.add(new Product(1L, "Computador", 5000.0, 5));

        when(repository.findAll()).thenReturn(list);

        List<Product> resultado = services.findAll();

        assertEquals(list, resultado);
        assertFalse(resultado.isEmpty());
    }
    @DisplayName("List should be empty")
    @Test
    void listEmpty() {
        List<Product> list = new ArrayList<>();

        when(repository.findAll()).thenReturn(list);

        List<Product> resultado = services.findAll();

        assertEquals(list, resultado);
        assertTrue(resultado.isEmpty());
    }


    @DisplayName("Should save product")
    @Test
    void save() {
        Product produto = new Product(1L, "celular", 2000.0, 10);

        when(repository.save(any(Product.class))).thenReturn(produto);

        Product produtoEsperado = services.save(produto);

        verify(repository).save(produto);
        assertEquals(produto,produtoEsperado);
    }

    @DisplayName("Should delete product")
    @Test
    void delete() {
        Long idParaExcluir = 1L;
        Mockito.doNothing().when(repository).deleteById(idParaExcluir);

        services.delete(idParaExcluir);

        Mockito.verify(repository).deleteById(idParaExcluir);

    }
}