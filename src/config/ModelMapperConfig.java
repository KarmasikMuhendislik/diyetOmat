package config;

import dto.request.ProductFeaturesRequest;
import dto.request.ProductRequest;
import dto.request.ProductTypeRequest;
import dto.request.UserRequest;
import dto.response.ProductFeaturesResponse;
import dto.response.ProductResponse;
import dto.response.ProductTypeResponse;
import dto.response.UserResponse;
import entity.Product;
import entity.ProductFeatures;
import entity.ProductType;
import entity.User;
import org.mapstruct.BeanMapping;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperConfig {

    private static final Converter<UserRequest, User> USER_REQUEST_USER_CONVERTER = mappingContext -> {
        UserRequest userRequest = mappingContext.getSource();
        User user = new User(
                userRequest.getGender(),
                userRequest.getHeight(),
                userRequest.getWeight(),
                userRequest.getAge()
        );


      return  user;
    };
    private static final Converter<User, UserResponse>USER_USER_RESPONSE_CONVERTER = mappingContext -> {
      User user = mappingContext.getSource();
      UserResponse userResponse = new UserResponse(
              user.getGender(),
              user.getHeight(),
              user.getWeight(),
              user.getAge()
      );
      return userResponse;
    };

    private static final Converter<ProductFeatures, ProductFeaturesResponse> PRODUCT_FEATURES_PRODUCT_FEATURES_RESPONSE_CONVERTER = mappingContext -> {
        ProductFeatures productFeatures = mappingContext.getSource();
        ProductFeaturesResponse productFeaturesResponse = new ProductFeaturesResponse(
                productFeatures.getProductOil(),
                productFeatures.getProductCarbohydrate(),
                productFeatures.getProductEnergy(),
                productFeatures.getProductProtein()
        );
        return productFeaturesResponse;
    };
    private static final Converter<ProductFeaturesRequest, ProductFeatures> PRODUCT_FEATURES_REQUEST_PRODUCT_FEATURES_CONVERTER = mappingContext -> {
        ProductFeaturesRequest productFeaturesRequest = mappingContext.getSource();
        ProductFeatures productFeatures = new ProductFeatures(
                productFeaturesRequest.getProductEnergy(),
                productFeaturesRequest.getProductOil(),
                productFeaturesRequest.getProductCarbohydrate(),
                productFeaturesRequest.getProductProtein()
        );
        return productFeatures;
    };
    private static final Converter<ProductType,ProductTypeResponse> PRODUCT_TYPE_PRODUCT_TYPE_RESPONSE_CONVERTER = mappingContext ->{
        ProductType productType = mappingContext.getSource();
        ProductTypeResponse productTypeResponse =
                new ProductTypeResponse(
                        productType.getTypeName(),
                        productType.getProductTypeName());
        return productTypeResponse;
    };

    private static final Converter<ProductTypeRequest, ProductType> PRODUCT_TYPE_REQUEST_PRODUCT_TYPE_CONVERTER = mappingContext -> {
        ProductTypeRequest productTypeRequest = mappingContext.getSource();
        ProductType productType =
                new ProductType(
                        productTypeRequest.getTypeName(),
                        productTypeRequest.getProductTypeName()
                );
        return productType;
    };

    private static  final  Converter<ProductRequest, Product>PRODUCT_REQUEST_PRODUCT_CONVERTER = mappingContext -> {
      ProductRequest productRequest = mappingContext.getSource();
      Product product = new Product(
              productRequest.getProductName(),
              productRequest.getProductFee()
      );
      return product;
    };

    private static final  Converter<Product, ProductResponse>PRODUCT_PRODUCT_RESPONSE_CONVERTER = mappingContext -> {
      Product product = mappingContext.getSource();

      ProductResponse productResponse = new ProductResponse(
              product.getProductName(),
              product.getProductType(),
              product.getProductFee(),
              product.getProductFeatures()
      );

      return productResponse;
    };
    @BeanMapping
    public static ModelMapper getModelMapper(){
        ModelMapper modelMapper =  new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE);
        modelMapper.addConverter(PRODUCT_TYPE_PRODUCT_TYPE_RESPONSE_CONVERTER, ProductType.class, ProductTypeResponse.class);
        modelMapper.addConverter(PRODUCT_TYPE_REQUEST_PRODUCT_TYPE_CONVERTER,ProductTypeRequest.class,ProductType.class);
        modelMapper.addConverter(PRODUCT_REQUEST_PRODUCT_CONVERTER, ProductRequest.class, Product.class);
        modelMapper.addConverter(PRODUCT_PRODUCT_RESPONSE_CONVERTER,Product.class, ProductResponse.class);
        modelMapper.addConverter(PRODUCT_FEATURES_REQUEST_PRODUCT_FEATURES_CONVERTER, ProductFeaturesRequest.class, ProductFeatures.class);
        modelMapper.addConverter(PRODUCT_FEATURES_PRODUCT_FEATURES_RESPONSE_CONVERTER,ProductFeatures.class, ProductFeaturesResponse.class);
        modelMapper.addConverter(USER_USER_RESPONSE_CONVERTER,User.class, UserResponse.class);
        modelMapper.addConverter(USER_REQUEST_USER_CONVERTER, UserRequest.class,User.class);
        return modelMapper;
    }
}
