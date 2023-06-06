package service.serviceImpl;

import dto.request.ProductTypeRequest;
import dto.response.ProductResponse;
import dto.response.ProductTypeResponse;
import entity.ProductType;
import org.modelmapper.ModelMapper;
import repository.ProductTypeRepository;
import repository.repositoryImpl.ProductTypeRepositoryImpl;
import service.ProductTypeService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    private ModelMapper modelMapper;
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository, ModelMapper modelMapper) {
        this.productTypeRepository = productTypeRepository;
        this.modelMapper = modelMapper;
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
//Öncelik Varmı olarak kullanılacak yer Burası
    @Override
    public List<String> getProductPrimaryName() {
        List<String> productPrimaryKeyList = productTypeRepository.getProductPrimaryName();
        //for(String string : productPrimaryKeyList){
        //    System.out.println(string);
        //}
        return productPrimaryKeyList;
    }

    @Override
    public List<Integer> getByPrimaryName(String name) {
        List<Integer> primaryNameList = productTypeRepository.getPrimaryName(name);
        for(Integer key : primaryNameList){
            System.out.println(key);
        }
        return primaryNameList;
    }

    @Override
    public List<ProductTypeResponse> getAll() {
        List<ProductType> productTypeList = productTypeRepository.getAll();
        List<ProductTypeResponse> productTypeResponseList =
                productTypeList.stream().map(productType -> modelMapper.map(productType, ProductTypeResponse.class)).collect(Collectors.toList());
        return null;
    }


    public ProductTypeResponse getTypeName(String name){
        ProductType productType = productTypeRepository.getProductTypeName(name);
        return modelMapper.map(productType,ProductTypeResponse.class);
    }


}
