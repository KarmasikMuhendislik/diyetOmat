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

    private  UserRepository userRepository;
    private  ModelMapper modelMapper;
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository ) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User userEntity =modelMapper.map(userRequest,User.class);
        User user = userRepository.addUser(userEntity);
        return modelMapper.map(user, UserResponse.class);
    }



}
