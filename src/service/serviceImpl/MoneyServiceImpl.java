package service.serviceImpl;

import repository.MoneyRepository;
import repository.repositoryImpl.MoneyRepositoryImpl;
import service.MoneyService;

public class MoneyServiceImpl implements MoneyService {
    private final MoneyRepository moneyRepository;

    public MoneyServiceImpl(MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }
    @Override
    public double addMoney(double moneyAmount) {
        return moneyRepository.addMoney(moneyAmount);
    }
    @Override
    public double getMoney() {
        return moneyRepository.getMoney();
    }
    @Override
    public double cashOut(double moneyAmount) {
        return moneyRepository.cashOut(moneyAmount);
    }

    @Override
    public double cashBack(double cashBackMoney) {
        return  cashBackMoney ;
    }
}
