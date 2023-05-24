package repository;

import dto.request.ProductTypeRequest;
import dto.response.ProductTypeResponse;
import entity.ProductType;

import java.util.List;

public interface ProductTypeRepository {
    ProductType addProductType(ProductType productType);

    Boolean deleteProductType(int id);

    ProductType getProductType(int id);

    List<String> getProductPrimaryName();

    List<Integer> getPrimaryName(String name);

    ProductType getProductTypeName(String name);

    List<ProductType> getAll();
}
