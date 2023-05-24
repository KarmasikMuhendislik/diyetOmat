package service.serviceImpl;

import entity.Product;
import entity.ProductType;
import org.modelmapper.ModelMapper;
import repository.HungerLevelRepository;
import repository.ProductFeaturesRepository;
import repository.ProductRepository;
import repository.ProductTypeRepository;
import repository.repositoryImpl.HungerLevelRepositoryImpl;
import repository.repositoryImpl.ProductFeaturesRepositoryImpl;
import repository.repositoryImpl.ProductRepositoryImpl;
import repository.repositoryImpl.ProductTypeRepositoryImpl;
import service.ManuelDiyetService;

import java.util.ArrayList;
import java.util.List;

public class ManuelDiyetServiceImpl implements ManuelDiyetService {
    private final ModelMapper modelMapper;
    private final HungerLevelRepository hungerLevelRepository;
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductFeaturesRepository productFeaturesRepository;
    public ManuelDiyetServiceImpl( ) {
        this.productRepository = new ProductRepositoryImpl();
        this.modelMapper = new ModelMapper();
        this.hungerLevelRepository = new HungerLevelRepositoryImpl();
        this.productTypeRepository = new ProductTypeRepositoryImpl();
        this.productFeaturesRepository = new ProductFeaturesRepositoryImpl();    }


    @Override
    public List<Product> getAvaliableProduct(double userCalories, List<Integer> productPrimaryId) {
        List<Product> productsList = new ArrayList();
        if (0 < userCalories && userCalories < 51) {
            //A1,A2 ve A3 dönecek
            //Burada direk A1dönecek
            for(Integer key : productPrimaryId){
                productRepository.getAllProductTypeId(key);
            }
        }
        else if (50<userCalories && userCalories<101){

            for(Integer key :productPrimaryId ) {
                ProductType productType= productTypeRepository.getProductType(key);
                if(productType.getProductPrimaryName().equals("YAĞ")){
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("B").getId());
                    //Burada sadece B -13
                    productsList = products;
                } else if (productType.getProductPrimaryName().equals("KARBONHİDRAT")) {
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("A2").getId());
                    products.addAll(productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("A3").getId()));
                    productsList = products;
                } else if (productType.getProductPrimaryName().equals("PROTEİN")) {
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("A2").getId());
                    products.addAll(productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("A3").getId()));                        productsList = products;
                    //A2A3-11-12
                } else if (productType.getProductPrimaryName().equals("HİÇBİRİ")) {
                    List<Product> products = productRepository.getAllProductTypeId(productType.getId());
                    productsList.addAll(products);
                    //A2A3B

                }
                else {
                    System.out.println("Ürün Bulunamadı.");
                }
                for (Product product : productsList){
                    System.out.println(product.getProductName());
                }
                return productsList;
            }

        }
        else if(100<userCalories && userCalories<201){
            for(Integer key :productPrimaryId ) {
                ProductType productType= productTypeRepository.getProductType(key);
                if(productType.getProductPrimaryName().equals("YAĞ")){
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("A3").getId());
                    products.addAll(productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("B").getId()));
                    //A3+B
                    productsList = products;
                } else if (productType.getProductPrimaryName().equals("KARBONHİDRAT")) {
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("C").getId());
                    for (Product product : products){
                        if((productFeaturesRepository.getProductFeatures(product.getProductFeatures()).getProductEnergy())<201){
                            productsList.add(product);
                        }
                    }
                    //C(31 Hariç)

                } else if (productType.getProductPrimaryName().equals("PROTEİN")) {
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("D").getId());
                    productsList = products;
                    //D
                } else if (productType.getProductPrimaryName().equals("HİÇBİRİ")) {
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("A3").getId());
                    products.addAll(productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("B").getId()
                    ));
                    products.addAll(productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("C").getId()
                    ));
                    products.addAll(productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("D").getId()
                    ));
                    for (Product product : products){
                        if((productFeaturesRepository.getProductFeatures(product.getProductFeatures()).getProductEnergy())<201){
                            productsList.add(product);
                        }
                    }
                }
                else {
                    System.out.println("Ürün Bulunamadı.");
                }
                for (Product product : productsList){
                    System.out.println(product.getProductName());
                }
                return productsList;
            }
        }
        else if(200<userCalories && userCalories<301){
            for(Integer key :productPrimaryId ) {
                ProductType productType= productTypeRepository.getProductType(key);
                if(productType.getProductPrimaryName().equals("YAĞ")){
                    List<Product> products =
                            productRepository.getAllProductTypeId(
                                    productTypeRepository.getProductTypeName("B").getId());
                    products.addAll(
                            productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("D").getId())
                    );
                    //B+D
                    productsList = products;
                } else if (productType.getProductPrimaryName().equals("KARBONHİDRAT")) {
                    List<Product> products = productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("C").getId());
                    for (Product product : products){
                        if((productFeaturesRepository.getProductFeatures(product.getProductFeatures()).getProductEnergy())>200){
                            productsList.add(product);
                        }
                    }

                } else if (productType.getProductPrimaryName().equals("PROTEİN")) {
                    List<Product> products = productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("A3").getId());
                    products.addAll(
                            productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("D").getId())
                    );
                    productsList = products;
                    //A3+D
                } else if (productType.getProductPrimaryName().equals("HİÇBİRİ")) {
                    List<Product> products = productRepository.getAllProductTypeId(
                            productTypeRepository.getProductTypeName("A3").getId());
                    products.addAll(productRepository.getAllProductTypeId(productTypeRepository.getProductTypeName("D").getId()));
                    products.addAll(productRepository.getAllProductTypeId(productTypeRepository.getProductTypeName("B").getId()));
                    products.addAll(productRepository.getAllProductTypeId(productTypeRepository.getProductTypeName("C").getId()));

                    for (Product product : products){
                        if((productFeaturesRepository.getProductFeatures(product.getProductFeatures()).getProductEnergy())<201){
                            productsList.add(product);
                        }
                    }
                }//A3+D, B+D,31
                else {
                    System.out.println("Ürün Bulunamadı.");
                }
                for (Product product : productsList){
                    System.out.println(product.getProductName());
                }
                return productsList;
            }

        }
        else if(301<userCalories && userCalories<401){
            for(Integer key :productPrimaryId ) {
                ProductType productType= productTypeRepository.getProductType(key);
                if(productType.getProductPrimaryName().equals("YAĞ")){
                    List<Product> products =
                            productRepository.getAllProductTypeId(
                                    productTypeRepository.getProductTypeName("C").getId());
                    products.addAll(
                            productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("D").getId())
                    );
                    //C+D
                    productsList = products;
                } else if (productType.getProductPrimaryName().equals("KARBONHİDRAT")) {
                    List<Product> products =
                            productRepository.getAllProductTypeId(
                                    productTypeRepository.getProductTypeName("C").getId());
                    products.addAll(
                            productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("D").getId())
                    );

                    productsList = products;


                } else if (productType.getProductPrimaryName().equals("PROTEİN")) {
                    List<Product> products =
                            productRepository.getAllProductTypeId(
                                    productTypeRepository.getProductTypeName("C").getId());
                    products.addAll(
                            productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("D").getId())
                    );

                    productsList = products;
                } else if (productType.getProductPrimaryName().equals("HİÇBİRİ")) {
                    List<Product> products =
                            productRepository.getAllProductTypeId(
                                    productTypeRepository.getProductTypeName("C").getId());
                    products.addAll(
                            productRepository.getAllProductTypeId( productTypeRepository.getProductTypeName("D").getId())
                    );

                    productsList = products;
                }//A3+D, B+D,31
                else {
                    System.out.println("Ürün Bulunamadı.");
                }
                for (Product product : productsList){
                    System.out.println(product.getProductName());
                }
                return productsList;
            }

        }

        return null;
    }
}
