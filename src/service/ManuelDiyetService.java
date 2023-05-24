package service;

import entity.Product;

import java.util.List;

public interface ManuelDiyetService {
    List<Product> getAvaliableProduct(double userCalories, List<Integer> productPrimaryId);
}
