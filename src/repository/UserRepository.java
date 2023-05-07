package repository;

import dto.request.UserRequest;
import dto.response.UserResponse;
import entity.User;

public interface UserRepository {
    User addUser(User user);
}
