package service;

import dto.request.ProductTypeRequest;
import dto.response.ProductResponse;
import dto.request.ProductRequest;
import dto.response.ProductTypeResponse;

import java.sql.SQLException;

public interface ProductService {

    ProductResponse productAdd(ProductRequest productRequest);

    ProductTypeResponse productTypeAdd(ProductTypeRequest productTypeRequest) throws SQLException;
}
