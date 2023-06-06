package controller;

import dto.request.UserRequest;
import dto.response.HungerLevelResponse;
import dto.response.ProductResponse;
import entity.Product;
import service.*;

import java.util.List;

public class OtoDiyetController{
    private  HungerLevelService hungerLevelService;
    private  OtoDiyetService otoDiyetService;
    private  ProductTypeService productTypeService;

    private PurchasigService purchasigService;
    public OtoDiyetController(HungerLevelService hungerLevelService,
                              OtoDiyetService otoDiyetService,
                              ProductTypeService productTypeService,
                              PurchasigService purchasigService) {
        this.hungerLevelService = hungerLevelService;
        this.otoDiyetService = otoDiyetService ;
        this.productTypeService = productTypeService;
        this.purchasigService = purchasigService;
    }

    // Otomatik diyette sırasıyla cinsiyet, kilo, boy ve yaş isteniyor.
    // Bu değerler mifflin denkleminde yerine yazılarak bir sonuç elde edilir.
    // Çıkan sonuç 1.2 sabitiyle çarpılarak total enerji bulunur. Daha sonra kullannıcıdan açlık düzeyi istenir.
    // Bu açlık düzeyiyle /örneğin %5) total enerji çarpılarak o an tüketilmesi gereken kalori miktarı bulunur.
    // Sonrasında kullanıcıya öncelikleri sorulur; yağ, karbonhidrat ve protein.
    // Gerekli kalori miktarına ve önceliğe göre de tabloda denk gelen bölgedeki ürünler kullanıcıya sunulur.
    // Kullanıcı bu ürünler arasından tercihini tuşlar, parasını öder ve ürünü alır.





    //Kullanıcıdan bilgiler istendi ve Çıkan sonuç 1.2 sabitiyle çarpılarak total enerji bulunur.
    public double totalEnergy(UserRequest userRequest){
        return otoDiyetService.totalEnergy(userRequest);
    }

    //Daha sonra kullannıcıdan açlık düzeyi istenir.
    public List<HungerLevelResponse> getAllHungerLevelResponse(){
        return hungerLevelService.getAllHungerLevel();
    }
    public HungerLevelResponse getHungerLevel(int id){
        return hungerLevelService.getHungerLevel(id);
    }

    public List<String> getAllProductPrimaryName(){
        //Öncelik Varmı Menüsü
        return productTypeService.getProductPrimaryName();
    }

    // Bu açlık düzeyiyle /örneğin %5) total enerji çarpılarak o an tüketilmesi gereken kalori miktarı bulunur.
    public double requiredCalories(double totalEnergy, int id){
        return otoDiyetService.requiredCalories(totalEnergy,id);
    }

    // Gerekli kalori miktarına ve önceliğe göre de tabloda denk gelen bölgedeki ürünler kullanıcıya sunulur.

    public List<ProductResponse> optionCalorieAndProduct(double userCalories, List<Integer> productPrimaryId){
        return otoDiyetService.getAvaliableProduct(userCalories,productPrimaryId);
    }

    //id ve parayı aldı ve gönderdi.
    public Double toPurchasing(int id, int money){
        return purchasigService.buyProduct(id,money);
    }

}
