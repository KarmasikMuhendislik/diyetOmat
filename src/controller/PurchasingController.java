package controller;

import service.PurchasigService;
import service.serviceImpl.PurchasingServiceImpl;

public class PurchasingController {
    private  final PurchasigService purchasigService;

    public PurchasingController( PurchasigService purchasigService) {
        this.purchasigService = purchasigService;
    }


    public Double buyProduct(int id, int money){
        return purchasigService.buyProduct(id,money);
    }
}
