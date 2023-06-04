package controller.OtherControllers;

import dto.request.UserRequest;
import dto.response.UserResponse;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

public class UserController {
    private  UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public UserResponse addUser(UserRequest userRequest){
        return userService.addUser(userRequest);
    }

}
