package service;

import dto.request.UserRequest;

public interface OtoDiyetService {
    double totalEnergy(UserRequest userRequest);

    double requiredCalories(double totalEnergy,int id);
}
