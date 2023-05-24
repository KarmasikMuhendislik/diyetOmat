package controller;

import dto.response.ProductResponse;
import service.ProductService;
import service.serviceImpl.ProductServiceImpl;

import java.util.List;

public class DirectDiyetController {
    private ProductService productService;
    public DirectDiyetController() {
      this.productService = new ProductServiceImpl();
    }
    public List<ProductResponse> getProductList(){
        return productService.getAllProduct();
    }
    public ProductResponse getProduct(int id){
        return productService.getProduct(id);
    }
}
