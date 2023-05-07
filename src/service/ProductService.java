package service;

import dto.request.ProductTypeRequest;
import dto.response.ProductResponse;
import dto.request.ProductRequest;
import dto.response.ProductTypeResponse;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);

    Boolean deleteProduct(int id);

    ProductResponse getProduct(int id);

    List<ProductResponse> getAllProduct();
}
