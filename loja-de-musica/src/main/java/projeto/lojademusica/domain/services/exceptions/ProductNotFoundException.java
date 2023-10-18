package projeto.lojademusica.domain.services.exceptions;

public class ProductNotFoundException extends  RuntimeException{

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
