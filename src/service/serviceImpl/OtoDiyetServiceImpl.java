package service.serviceImpl;

import dto.request.UserRequest;
import entity.HungerLevel;
import entity.User;
import org.modelmapper.ModelMapper;
import repository.HungerLevelRepository;
import repository.repositoryImpl.HungerLevelRepositoryImpl;
import service.OtoDiyetService;

import java.util.function.Supplier;

public class OtoDiyetServiceImpl implements OtoDiyetService {

    private final ModelMapper modelMapper;
    private final HungerLevelRepository hungerLevelRepository;
    public OtoDiyetServiceImpl() {
        this.modelMapper = new ModelMapper();
        this.hungerLevelRepository = new HungerLevelRepositoryImpl();
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

    @Override
    public double requiredCalories(double totalEnergy, int id) {
        //Burada birde açlık düzeyinin verilmesi gerekiyor.
        HungerLevel hungerLevel = hungerLevelRepository.getHungerLevel(id);
        double calori = totalEnergy * hungerLevel.getEnergy();
        return calori;
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
