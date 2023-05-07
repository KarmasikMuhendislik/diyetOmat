package service.serviceImpl;

import repository.MoneyRepository;
import repository.repositoryImpl.MoneyRepositoryImpl;
import service.MoneyService;

public class MoneyServiceImpl implements MoneyService {
    private final MoneyRepository moneyRepository;

    public MoneyServiceImpl() {
        this.moneyRepository = new MoneyRepositoryImpl();
    }
    @Override
    public int addMoney(int moneyAmount) {
        return moneyRepository.addMoney(moneyAmount);
    }
    @Override
    public int getMoney() {
        return moneyRepository.getMoney();
    }
    @Override
    public int cashOut(int moneyAmount) {
        return moneyRepository.cashOut(moneyAmount);
    }

    @Override
    public int cashBack(int cashBackMoney) {
        return  cashBackMoney ;
    }
}
