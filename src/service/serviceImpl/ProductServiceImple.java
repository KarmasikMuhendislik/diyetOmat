package service.serviceImpl;

import dto.request.ProductTypeRequest;
import dto.response.ProductResponse;
import dto.request.ProductRequest;
import dto.response.ProductTypeResponse;
import repository.ProductRepository;
import repository.repositoryImpl.ProductRepositoryImpl;
import service.ProductService;

import java.sql.SQLException;

public class ProductServiceImple implements ProductService {

    private final ProductRepository productRepository ;

    public ProductServiceImple( ) {
        this.productRepository = new ProductRepositoryImpl();
    }

    @Override
    public ProductResponse productAdd(ProductRequest productRequest) {
        return productRepository.productAdd(productRequest);

    }

    @Override
    public ProductTypeResponse productTypeAdd(ProductTypeRequest productTypeRequest) throws SQLException {
        return productRepository.productTypeAdd(productTypeRequest);
    }
}
