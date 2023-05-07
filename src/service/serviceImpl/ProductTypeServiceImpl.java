package service.serviceImpl;

import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import entity.ProductFeatures;
import entity.ProductType;
import org.modelmapper.ModelMapper;
import repository.ProductTypeRepository;
import repository.repositoryImpl.ProductTypeRepositoryImpl;
import service.ProductTypeService;

public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    private ModelMapper modelMapper;
    public ProductTypeServiceImpl() {
        this.productTypeRepository = new ProductTypeRepositoryImpl();
        this.modelMapper = new ModelMapper();
    }
    @Override
    public ProductTypeResponse addProductType(ProductTypeRequest productTypeRequest) {
        ProductType productType = modelMapper.map(productTypeRequest, ProductType.class);
        ProductType entity = productTypeRepository.addProductType(productType);
        return modelMapper.map(entity,ProductTypeResponse.class);
    }
    @Override
    public Boolean deleteProductType(int id) {
        return productTypeRepository.deleteProductType(id);
    }
    @Override
    public ProductTypeResponse getProductType(int id) {
        ProductType productType = productTypeRepository.getProductType(id);
        return modelMapper.map(productType,ProductTypeResponse.class);
    }
}
