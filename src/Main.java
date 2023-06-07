import View.Entries.DirectEntry;
import View.Entries.ManuelEntry;
import View.Entries.OtomaticEntry;
import View.Entry;
import controller.DirectDiyetController;
import controller.ManuelDiyetController;
import controller.OtherControllers.HungerLevelController;
import controller.OtherControllers.ProductController;
import controller.OtherControllers.ProductTypeController;
import controller.OtoDiyetController;
import controller.PurchasingController;

import org.modelmapper.ModelMapper;
import repository.*;
import repository.repositoryImpl.*;
import service.*;
import service.serviceImpl.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {

    public static void call(Entry entry){
        entry.run();
    }
    public static void main(String[] args) throws SQLException {
        ProductRepository productRepository = new ProductRepositoryImpl();
        MoneyRepository moneyRepository = new MoneyRepositoryImpl();
        ProductTypeRepository productTypeRepository = new ProductTypeRepositoryImpl();
        ProductFeaturesRepository productFeaturesRepository = new ProductFeaturesRepositoryImpl();
        HungerLevelRepository hungerLevelRepository = new HungerLevelRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();
        ModelMapper modelMapper = new ModelMapper();
        ////////////////////////////////////////////
        ProductService productService = new ProductServiceImpl(productRepository, productTypeRepository,productFeaturesRepository, modelMapper);
        HungerLevelService hungerLevelService = new HungerLevelServiceImpl(modelMapper, hungerLevelRepository);
        ManuelDiyetService manuelDiyetService = new ManuelDiyetServiceImpl(modelMapper,hungerLevelRepository,productRepository,productTypeRepository,productFeaturesRepository);
        MoneyService moneyService  = new MoneyServiceImpl(moneyRepository);
        OtoDiyetService otoDiyetService = new OtoDiyetServiceImpl(modelMapper,hungerLevelRepository,productRepository, productTypeRepository,productFeaturesRepository);
        ProductFeaturesService productFeaturesService = new ProductFeaturesServiceImpl(productFeaturesRepository,modelMapper);
        ProductTypeService productTypeService = new ProductTypeServiceImpl(productTypeRepository, modelMapper );
        PurchasigService purchasigService = new PurchasingServiceImpl(modelMapper, moneyService, productService);
        UserService userService = new UserServiceImpl(modelMapper,userRepository);

        ///////////////////////////////////////////
        DirectDiyetController directDiyetController = new DirectDiyetController(productService, purchasigService);
        OtoDiyetController otoDiyetController = new OtoDiyetController(hungerLevelService,otoDiyetService,productTypeService, purchasigService);
        ManuelDiyetController manuelDiyetController = new ManuelDiyetController(hungerLevelService,manuelDiyetService,productTypeService, purchasigService);
        PurchasingController purchasingController = new PurchasingController(purchasigService);
        HungerLevelController  hungerController = new HungerLevelController(hungerLevelService);
        ProductController productController = new ProductController(productService);
        ProductTypeController productTypeController = new ProductTypeController(productTypeService);

        ////////////////////////////////////////////

        //Yukarıda yapılan işlemler Injection işlemidir. Esneklik ve geliştirilebilirlik için bu yapı kullanılmıştır.

        boolean out =false;
        while (true){
            System.out.println("Diyet türünüzü belirtiniz: 1 direk, 2 oto diyet, 3 manuel diyet, çıkış için herhangi bir tuşa basın");
            Scanner sc = new Scanner(System.in);
            int c   = sc.nextInt();
            switch (c){
                case 1:
                    call(new DirectEntry(directDiyetController,productController,productTypeController));
                    break;
                case 2:
                    call(new OtomaticEntry(otoDiyetController,hungerController,productController,productTypeController));
                    break;
                case 3:
                    call(new ManuelEntry(manuelDiyetController,hungerController,productController,productTypeController));
                    break;
                default:
                    out=true;
            }
            if (out==true){
                break;
            }
        }


    }
}