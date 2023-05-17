package service.serviceImpl;

import dto.request.UserRequest;
import dto.response.UserResponse;
import entity.User;
import org.modelmapper.ModelMapper;
import repository.UserRepository;
import repository.repositoryImpl.UserRepositoryImpl;
import service.UserService;

import java.util.function.Supplier;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserServiceImpl( ) {
        this.userRepository = new UserRepositoryImpl();
        this.modelMapper = new ModelMapper();
    }
    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User userEntity =modelMapper.map(userRequest,User.class);
        User user = userRepository.addUser(userEntity);
        return modelMapper.map(user, UserResponse.class);
    }



}
