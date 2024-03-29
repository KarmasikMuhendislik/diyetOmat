package service.serviceImpl;

import dto.request.ProductFeaturesRequest;
import dto.response.ProductFeaturesResponse;
import entity.ProductFeatures;
import org.modelmapper.ModelMapper;
import repository.ProductFeaturesRepository;
import repository.repositoryImpl.ProductFeaturesRepositoryImpl;
import service.ProductFeaturesService;
import service.ProductService;

public class ProductFeaturesServiceImpl implements ProductFeaturesService {
    private final ProductFeaturesRepository productFeaturesRepository;
    private ModelMapper modelMapper;
    public ProductFeaturesServiceImpl(ProductFeaturesRepository productFeaturesRepository,
                                      ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.productFeaturesRepository = productFeaturesRepository;
    }


    @Override
    public ProductFeaturesResponse addProdcutFeatures(ProductFeaturesRequest productFeaturesRequest) {
        ProductFeatures productFeatures = modelMapper.map(productFeaturesRequest, ProductFeatures.class);
        ProductFeatures entity = productFeaturesRepository.addProductFeatures(productFeatures);
        return modelMapper.map( entity, ProductFeaturesResponse.class);
    }

    @Override
    public Boolean deleteProdcutFeatures(int id) {
        return productFeaturesRepository.deleteProductFeatures(id);
    }

    @Override
    public ProductFeaturesResponse getProductFeatures(int id) {
         ProductFeatures features = productFeaturesRepository.getProductFeatures(id);
        return modelMapper.map(features, ProductFeaturesResponse.class);
    }
}
