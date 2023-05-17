package controller;

import dto.request.UserRequest;
import service.HungerLevelService;
import service.OtoDiyetService;
import service.UserService;
import service.serviceImpl.HungerLevelServiceImpl;
import service.serviceImpl.OtoDiyetServiceImpl;
import service.serviceImpl.UserServiceImpl;

public class OtoDiyetController {
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
}
