package controller.OtherControllers;

import dto.request.ProductRequest;
import dto.response.ProductResponse;
import entity.Product;
import service.ProductService;
import service.serviceImpl.ProductServiceImpl;

import java.util.List;

public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService ) {
        this.productService = productService;

    }
    public ProductResponse addProduct(ProductRequest productRequest){
        return productService.addProduct(productRequest);
    }

    public Boolean deleteProduct(int id){
        return productService.deleteProduct(id);
    }

    public ProductResponse getProduct(int id){
        return productService.getProduct(id);
    }

    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }

}
