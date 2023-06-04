import controller.DirectDiyetController;
import controller.ManuelDiyetController;
import controller.OtherControllers.ProductTypeController;
import controller.OtoDiyetController;
import controller.PurchasingController;
import entity.Money;
import entity.Product;
import entity.ProductFeatures;
import entity.ProductType;
import org.hibernate.type.ManyToOneType;
import org.modelmapper.ModelMapper;
import repository.*;
import repository.repositoryImpl.*;
import service.*;
import service.serviceImpl.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main  {
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

        ////////////////////////////////////////////

        //Yukarıda yapılan işlemler Injection işlemidir. Esneklik ve geliştirilebilirlik için bu yapı kullanılmıştır.

    }
}