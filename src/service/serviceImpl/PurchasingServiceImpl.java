package service.serviceImpl;

import entity.Product;
import org.modelmapper.ModelMapper;
import service.MoneyService;
import service.ProductService;
import service.PurchasigService;

public class PurchasingServiceImpl implements PurchasigService {
    private final ProductService productService;
    private final MoneyService moneyService;
    private ModelMapper modelMapper;
    public PurchasingServiceImpl(ModelMapper modelMapper,
                                 MoneyService moneyService,
                                 ProductService productService) {
        this.productService = productService;
        this.moneyService = moneyService;
        this.modelMapper =  modelMapper;
    }


    @Override
    public Double buyProduct(int id, int money) {
        Product product = modelMapper.map(productService.getProduct(id),Product.class);
        Double cashBackMoney = 0.0;
        moneyService.addMoney(moneyService.getMoney()+money);
        Boolean isItSold = (product.getProductFee()<=money)? true: false;
        if(isItSold == true){
            double finalAmount = Math.abs(product.getProductFee() - money);
            moneyService.addMoney(moneyService.getMoney()-finalAmount);
            if(finalAmount>0){
                moneyService.cashBack(finalAmount);
                cashBackMoney=finalAmount;
            }
            else{
                moneyService.cashBack(finalAmount);
                cashBackMoney=finalAmount;

            }
            return cashBackMoney;
        }
        else {
            moneyService.addMoney(moneyService.getMoney()-money);
            cashBackMoney=moneyService.cashBack(money);
            return cashBackMoney;

        }
    }
}
