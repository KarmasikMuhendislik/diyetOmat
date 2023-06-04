package controller.OtherControllers;

import service.MoneyService;
import service.serviceImpl.MoneyServiceImpl;

public class MoneyController {

    private final MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }
    public double addMoney(int moneyAmount){
        return moneyService.addMoney(moneyAmount);
    }
    public double getMoney(){
        return moneyService.getMoney();
    }

    public double cashOut(int moneyAmount){
        return moneyService.cashOut(moneyAmount);
    }
}
