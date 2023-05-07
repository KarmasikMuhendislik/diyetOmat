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
    @Override
    public double totalEnergy(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        int energy = 0;
        Supplier<Double> result = (userRequest.getGender()=="K")? ()->femaleTotalEnergy(user)
                :((userRequest.getGender()=="E") ? ()->maleTotalEnergy(user)
                : ()->isNotGender());
        double finalResult = result.get();
        return finalResult ;
    }
    public double femaleTotalEnergy(User user){
        double femaleRee = (9.99 * user.getWeight())
                + (6.25 * user.getHeight())
                - (4.92 * user.getAge())
                - 161.0 ;
        double femaleTotalEnergy = femaleRee * 1.2;
        return femaleTotalEnergy;
    }
    public double maleTotalEnergy(User user){
        double maleRee = (9.99 * user.getWeight())
                +(6.25 * user.getHeight())
                -(4.92 * user.getAge())
                + 5.00;
        double maleTotalEnergy = maleRee * 1.2 ;
        return maleTotalEnergy;
    }
    public double isNotGender(){
        return 0;
    }


}
