package repository;

import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import entity.ProductType;

public interface ProductTypeRepository {
    ProductType addProductType(ProductType productType);

    Boolean deleteProductType(int id);

    ProductType getProductType(int id);
}
