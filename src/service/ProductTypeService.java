package service;

import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;

import java.util.List;

public interface ProductTypeService {
    ProductTypeResponse addProductType(ProductTypeRequest productTypeRequest);

    Boolean deleteProductType(int id);

    ProductTypeResponse getProductType(int id);

    List<String> getProductPrimaryName();

    List<Integer> getByPrimaryName(String name);

}
