package controller;

import dto.request.UserRequest;
import dto.response.HungerLevelResponse;
import dto.response.ProductTypeResponse;
import entity.Product;
import entity.ProductType;
import service.HungerLevelService;
import service.OtoDiyetService;
import service.ProductTypeService;
import service.UserService;
import service.serviceImpl.HungerLevelServiceImpl;
import service.serviceImpl.OtoDiyetServiceImpl;
import service.serviceImpl.ProductTypeServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.util.List;

public class OtoDiyetController{
    private final HungerLevelService hungerLevelService;
    private final OtoDiyetService otoDiyetService;
    private final ProductTypeService productTypeService;
    public OtoDiyetController() {
        this.hungerLevelService = new HungerLevelServiceImpl();
        this.otoDiyetService =  new OtoDiyetServiceImpl();
        this.productTypeService = new ProductTypeServiceImpl();
    }
    public double totalEnergy(UserRequest userRequest){
        return otoDiyetService.totalEnergy(userRequest);
    }
    public List<HungerLevelResponse> getAllHungerLevelResponse(){
        return hungerLevelService.getAllHungerLevel();
    }
    public HungerLevelResponse getHungerLevel(int id){
        return hungerLevelService.getHungerLevel(id);
    }
    public double requiredCalories(double totalEnergy, int id){
        return otoDiyetService.requiredCalories(totalEnergy,id);
    }
    public List<ProductTypeResponse> getAllProductType(){
        return productTypeService.getAll();
    }
    public ProductTypeResponse getByIdProductType(int id){
        return productTypeService.getProductType(id);
    }
    public List<Product> optionCalorieAndProduct(double userCalories, List<Integer> productPrimaryId){
        return otoDiyetService.getAvaliableProduct(userCalories,productPrimaryId);
    }
}
