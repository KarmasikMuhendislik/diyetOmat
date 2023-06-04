package controller;

import dto.response.ProductResponse;
import entity.Product;
import service.ProductService;
import service.PurchasigService;
import service.serviceImpl.ProductServiceImpl;

import java.util.List;

public class DirectDiyetController {
    private ProductService productService;
    private PurchasigService purchasigService;
    public DirectDiyetController(ProductService productService, PurchasigService purchasigService) {
      this.productService = productService;
      this.purchasigService = purchasigService;
    }
    //Direkt giriş normal otomatlar gibidir. Tercihini yapar, paranı öder, ürününü alırsın.

    public List<ProductResponse> getProductList(){
        return productService.getAllProduct();
    }
    public ProductResponse getProduct(int id){
        return productService.getProduct(id);
    }
    public Double ProductToBuy(int id, int money){
        return  purchasigService.buyProduct(id, money);
    }

}
