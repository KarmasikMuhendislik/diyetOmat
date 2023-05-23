package controller;

import dto.request.UserRequest;
import entity.Product;
import service.HungerLevelService;
import service.OtoDiyetService;
import service.UserService;
import service.serviceImpl.HungerLevelServiceImpl;
import service.serviceImpl.OtoDiyetServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.util.List;

public class OtoDiyetController{
    private final UserService userService;
    private final HungerLevelService hungerLevelService;
    private final OtoDiyetService otoDiyetService;
    public OtoDiyetController() {
        this.userService = new UserServiceImpl();
        this.hungerLevelService = new HungerLevelServiceImpl();
        this.otoDiyetService =  new OtoDiyetServiceImpl();
    }
    public double totalEnergy(UserRequest userRequest){
        return otoDiyetService.totalEnergy(userRequest);
    }
    public double requiredCalories(double totalEnergy, int id){
        return otoDiyetService.requiredCalories(totalEnergy,id);
    }

    public List<Product> optionCaloriAndProduct(double userCalories, List<Integer> productPrimaryId){
        return otoDiyetService.getAvaliableProduct(userCalories,productPrimaryId);
    }
}
