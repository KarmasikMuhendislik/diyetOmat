package service;

import dto.request.UserRequest;
import dto.response.ProductResponse;
import entity.Product;

import java.util.List;

public interface OtoDiyetService {
    double totalEnergy(UserRequest userRequest);

    double requiredCalories(double totalEnergy,int id);


    List<ProductResponse> getAvaliableProduct(double userCalories, List<Integer> productPrimaryId);
}
