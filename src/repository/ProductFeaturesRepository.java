package repository;

import dto.request.ProductFeaturesRequest;
import entity.ProductFeatures;

public interface ProductFeaturesRepository {
    ProductFeatures addProductFeatures(ProductFeatures productFeatures);

    Boolean deleteProductFeatures(int id);

    ProductFeatures getProductFeatures(int id);
}
