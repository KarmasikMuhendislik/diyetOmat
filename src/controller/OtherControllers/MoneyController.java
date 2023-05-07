package controller.OtherControllers;

import service.MoneyService;
import service.serviceImpl.MoneyServiceImpl;

public class MoneyController {

    private final MoneyService moneyService;

    public MoneyController() {
        this.moneyService = new MoneyServiceImpl();
    }
    public int addMoney(int moneyAmount){
        return moneyService.addMoney(moneyAmount);
    }
    public int getMoney(){
        return moneyService.getMoney();
    }

    public int cashOut(int moneyAmount){
        return moneyService.cashOut(moneyAmount);
    }
}
