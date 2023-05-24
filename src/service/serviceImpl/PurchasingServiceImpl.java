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
    public PurchasingServiceImpl( ) {
        this.productService = new ProductServiceImpl();
        this.moneyService = new MoneyServiceImpl();
        this.modelMapper =  new ModelMapper();
    }
    @Override
    public Boolean productToBuy(int productId, int amount) {
        Product product = modelMapper.map(productService.getProduct(productId),Product.class);
        //Burada kontrol lazım işlemlerin burada olması gerekiyor.
        moneyService.addMoney(amount);
        Boolean isItSold = (product.getProductFee()<=amount)? true: false;
        if(isItSold == true){
            //ürün dönderilecek ve kullanıcıya para geri ödenecek.
            int finalAmount = product.getProductFee() - amount;
            moneyService.addMoney(moneyService.getMoney()-finalAmount);
            if(finalAmount>0){
                moneyService.cashBack(finalAmount);
            }
            else {
                moneyService.cashBack(finalAmount);
            }
            return true;
        }
        else{
            moneyService.addMoney(moneyService.getMoney()-amount);
            moneyService.cashBack(amount);
            return false;
        }
        //true ise ürün döndürmeye değil ise üstünü alma ve para tamamlama kısmına gitmesi gerekir.
        //true ise ürün ve para iade kısmına gideriz.
    }
    

}
