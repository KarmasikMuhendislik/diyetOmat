package service;

import dto.request.UserRequest;
import dto.response.UserResponse;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);
    double totalEnergy(UserRequest userRequest);
}
