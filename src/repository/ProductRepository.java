package repository;
import dto.response.ProductResponse;
import entity.Product;
import entity.ProductFeatures;
import entity.ProductType;

import java.util.List;

public interface ProductRepository {
    Boolean deleteProduct(int id);
    Product getProduct(int id);
    Product addProduct(Product product, ProductType productType, ProductFeatures productFeatures);

    List<Product> getAllProduct();

    List<Product> getAllProductTypeId(Integer id);
}
