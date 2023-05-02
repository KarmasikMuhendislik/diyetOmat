package controller;

import dto.response.ProductResponse;
import dto.request.ProductRequest;
import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import service.ProductService;
import service.serviceImpl.ProductServiceImple;

import java.sql.SQLException;

public class AdminController {
    private  final ProductService productService;

    public AdminController() {
        this.productService =  new ProductServiceImple();
    }

    public ProductResponse productAdd(ProductRequest productRequest){
       return productService.productAdd(productRequest);
    }
    public ProductTypeResponse productTypeAdd(ProductTypeRequest productTypeRequest) throws SQLException {
        return productService.productTypeAdd(productTypeRequest);
    }



}
