package service;

import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;

public interface ProductTypeService {
    ProductTypeResponse addProductType(ProductTypeRequest productTypeRequest);

    Boolean deleteProductType(int id);

    ProductTypeResponse getProductType(int id);
}
