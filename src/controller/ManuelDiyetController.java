package controller;

import dto.response.HungerLevelResponse;
import dto.response.ProductTypeResponse;
import entity.Product;
import service.HungerLevelService;
import service.ManuelDiyetService;
import service.OtoDiyetService;
import service.ProductTypeService;
import service.serviceImpl.HungerLevelServiceImpl;
import service.serviceImpl.ManuelDiyetServiceImpl;
import service.serviceImpl.ProductTypeServiceImpl;

import java.util.List;

public class ManuelDiyetController {
    private final HungerLevelService hungerLevelService;
    private final ManuelDiyetService manuelDiyetService;
    private final ProductTypeService productTypeService;

    public ManuelDiyetController() {
        this.hungerLevelService = new HungerLevelServiceImpl();
        this.manuelDiyetService =  new ManuelDiyetServiceImpl();
        this.productTypeService = new ProductTypeServiceImpl();

    }
    //HungerLevel Listesini döner.
    public List<HungerLevelResponse> getAllHungerLevel(){
        return hungerLevelService.getAllHungerLevel();
    }
    public HungerLevelResponse getHungerLevel(int id){
        return hungerLevelService.getHungerLevel(id);
    }

    public List<ProductTypeResponse> getAllProductType(){
        return productTypeService.getAll();
    }

    public ProductTypeResponse getByIdProductType(int id){
        return productTypeService.getProductType(id);
    }
    public List<Product> optionCalorieAndProduct(double userCalories, List<Integer> productPrimaryId){
        return manuelDiyetService.getAvaliableProduct(userCalories,productPrimaryId);
    }




    //öncelik varmı
    //sonrada kalori aralığı verilecek.
}
