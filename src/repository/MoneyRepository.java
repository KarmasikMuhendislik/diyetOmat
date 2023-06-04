package repository;

public interface MoneyRepository {
    double addMoney(double moneyAmount);

    double getMoney();

    double cashOut(double moneyAmount);
}
