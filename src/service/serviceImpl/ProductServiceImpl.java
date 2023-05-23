package service.serviceImpl;

import dto.response.ProductFeaturesResponse;
import dto.response.ProductResponse;
import dto.request.ProductRequest;
import entity.Product;
import entity.ProductFeatures;
import entity.ProductType;
import org.modelmapper.ModelMapper;
import repository.ProductFeaturesRepository;
import repository.ProductRepository;
import repository.ProductTypeRepository;
import repository.repositoryImpl.ProductFeaturesRepositoryImpl;
import repository.repositoryImpl.ProductRepositoryImpl;
import repository.repositoryImpl.ProductTypeRepositoryImpl;
import service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository ;
    private final ProductTypeRepository productTypeRepository;
    private final ProductFeaturesRepository productFeaturesRepository;
    private ModelMapper modelMapper;
    public ProductServiceImpl( ) {
        this.productRepository = new ProductRepositoryImpl();
        this.productTypeRepository = new ProductTypeRepositoryImpl();
        this.productFeaturesRepository = new ProductFeaturesRepositoryImpl();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest,Product.class);
        ProductType productType = productTypeRepository.getProductType(productRequest.getProductTypeId());
        ProductFeatures productFeatures = productFeaturesRepository.getProductFeatures(productRequest.getProductFeaturesId());
        Product entity = productRepository.addProduct(product,productType,productFeatures);
        return modelMapper.map(entity,ProductResponse.class);
    }
    @Override
    public Boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public ProductResponse getProduct(int id) {
        Product product = productRepository.getProduct(id);
        return modelMapper.map(product,ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> productList =  productRepository.getAllProduct();
        List<ProductResponse> productResponseList =
                productList.stream().map(product -> modelMapper.map(product, ProductResponse.class)).collect(Collectors.toList());
        for(ProductResponse productResponse : productResponseList){
            System.out.println(productResponse.getProductName() +", "
                    +productResponse.getProductType()+", "
                    +productResponse.getProductFee()+", "
                    +productResponse.getProductFeatures());
        }
        return productResponseList;
    }

    public List<ProductResponse> getAllProductTypeId(Integer id){
        List<Product> products = productRepository.getAllProductTypeId(id);
        List<ProductResponse> productResponseList =
                products.stream().map(product -> modelMapper.map(product, ProductResponse.class)).collect(Collectors.toList());
        return productResponseList;
    }
}
