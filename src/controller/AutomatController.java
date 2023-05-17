package controller;
import service.ProductService;
import service.serviceImpl.ProductServiceImpl;
import service.PurchasigService;
import service.serviceImpl.PurchasingServiceImpl;

public class AutomatController {
    //Burada üç tana api olacak manuelEntry, autoEntry ve directEntry
    private final PurchasigService purchasigService;
    private final ProductService productService;
    public AutomatController() {
        this.purchasigService = new PurchasingServiceImpl();
        this.productService = new ProductServiceImpl();
    }
    public Boolean productToBuy(int productId, int amount){
        return purchasigService.productToBuy(productId, amount);
    }
    public void exitService(){
    }
    //Buraya ödeme ekranı iptal ekranı olacak sonra hesaplama ekranları gelecek.

}
