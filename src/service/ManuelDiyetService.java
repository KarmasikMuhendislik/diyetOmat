package service;

import dto.response.ProductResponse;
import entity.Product;

import java.util.List;

public interface ManuelDiyetService {
    List<ProductResponse> getAvaliableProduct(double userCalories, List<Integer> productPrimaryId);
}
