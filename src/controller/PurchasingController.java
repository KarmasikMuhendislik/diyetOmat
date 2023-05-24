package controller;

import service.PurchasigService;
import service.serviceImpl.PurchasingServiceImpl;

public class PurchasingController {
    private  final PurchasigService purchasigService;

    public PurchasingController( ) {
        this.purchasigService = new PurchasingServiceImpl();
    }

    public Boolean buyProduct(int id,int amount){
        return purchasigService.productToBuy(id,amount);
    }
}
