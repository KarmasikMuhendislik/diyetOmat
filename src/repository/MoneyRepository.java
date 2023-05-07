package repository;

public interface MoneyRepository {
    int addMoney(int moneyAmount);

    int getMoney();

    int cashOut(int moneyAmount);
}
