package controller;

import dto.response.HungerLevelResponse;
import dto.response.ProductResponse;
import dto.response.ProductTypeResponse;
import entity.HungerLevel;
import entity.Product;
import service.*;
import service.serviceImpl.HungerLevelServiceImpl;
import service.serviceImpl.ManuelDiyetServiceImpl;
import service.serviceImpl.ProductTypeServiceImpl;

import java.util.List;

public class ManuelDiyetController {
    private  HungerLevelService hungerLevelService ;
    private final ManuelDiyetService manuelDiyetService;
    private final ProductTypeService productTypeService;

    private final PurchasigService purchasigService;

    public ManuelDiyetController(HungerLevelService hungerLevelService,
                                 ManuelDiyetService manuelDiyetService,
                                 ProductTypeService productTypeService,
                                 PurchasigService purchasigService) {
        this.hungerLevelService = hungerLevelService;
        this.manuelDiyetService = manuelDiyetService;
        this.productTypeService = productTypeService;
        this.purchasigService = purchasigService;

    }
    // Manuel diyette denklem yoktur.
    // Gerekli kalori için tabloda verilen 5 farklı kalori aralığından biri tercih edilir.(Burası Front End Olabilir.)

    // Sonrasında otomatik diyetteki gibi öncelik sorulur: yağ, karbonhidrat ve protein.
    // Kalori aralığı ve önceliğe göre tabloda denk gelen bölgedeki ürünler kullanıcıya sunulur.
    // Kullanıcı bu ürünler arasından tercihini tuşlar, parasını öder ve ürünü alır.


    public List<String> getAllProductPrimaryName(){
        //Öncelik Varmı Menüsü
        return productTypeService.getProductPrimaryName();
    }

    //Primary name üzerinden dönen name ile bize onun id veya idlerini verir.
    public List<Integer> getAllProductPrimaryId(String name){
        return  productTypeService.getByPrimaryName(name);
    }

    //Kullanıcıdan alınan kalori aralığı değeri ve getProduct PrimaryId Listesi buraya verilir.
    //Burası ProductResponse olacak.
    public List<ProductResponse> optionCalorieAndProduct(double userCalories, List<Integer> productPrimaryId){
        return manuelDiyetService.getAvaliableProduct(userCalories,productPrimaryId);
    }
    //Yukarıda dönen ürünler geldi ve seçtin id sini gönderdin.

    //id ve parayı aldı ve gönderdi.
    public Double toPurchasing(int id, int money){
        return purchasigService.buyProduct(id,money);
    }
}
