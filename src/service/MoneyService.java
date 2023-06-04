package service;

public interface MoneyService {
    double addMoney(double moneyAmount);

    double getMoney();

    double cashOut(double moneyAmount);

    double cashBack(double cashBackMoney);
}
