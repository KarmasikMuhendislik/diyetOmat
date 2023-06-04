package controller.OtherControllers;

import dto.response.ProductResponse;
import dto.request.ProductRequest;
import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import entity.Product;
import service.ProductService;
import service.ProductTypeService;
import service.serviceImpl.ProductServiceImpl;
import service.serviceImpl.ProductTypeServiceImpl;

import java.sql.SQLException;

public class AdminController {
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    public AdminController(ProductService productService, ProductTypeService productTypeService) {
        //Burada ayar lazım Admin Controller içerisine hangisi giderse onun başlaması lazım.
        this.productTypeService = productTypeService;
        System.out.println("Oluşturuluyor");
        this.productService =  productService;
    }

}
