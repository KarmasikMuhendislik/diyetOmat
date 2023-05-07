package service;

public interface MoneyService {
    int addMoney(int moneyAmount);

    int getMoney();

    int cashOut(int moneyAmount);

    int cashBack(int cashBackMoney);
}
