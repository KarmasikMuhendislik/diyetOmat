package service.serviceImpl;

import dto.request.HungerLevelRequest;
import dto.response.HungerLevelResponse;
import dto.response.ProductResponse;
import entity.HungerLevel;
import org.modelmapper.ModelMapper;
import repository.HungerLevelRepository;
import repository.repositoryImpl.HungerLevelRepositoryImpl;
import service.HungerLevelService;

import java.util.List;
import java.util.stream.Collectors;

public class HungerLevelServiceImpl implements HungerLevelService {
    private final ModelMapper modelMapper;
    private final HungerLevelRepository hungerLevelRepository;

    public HungerLevelServiceImpl( ) {
        this.hungerLevelRepository = new HungerLevelRepositoryImpl();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public HungerLevelResponse addHungerLevel(HungerLevelRequest hungerLevelRequest) {
        HungerLevel hungerLevel = modelMapper.map(hungerLevelRequest, HungerLevel.class);
        HungerLevel entity = hungerLevelRepository.addHungerLevel(hungerLevel);
        return null;
    }
    @Override
    public boolean deleteHungerLevel(int id) {
        return hungerLevelRepository.deleteHungerLevel(id);
    }
    @Override
    public HungerLevelResponse getHungerLevel(int id) {
        HungerLevel hungerLevel = hungerLevelRepository.getHungerLevel(id);
        HungerLevelResponse hungerLevelResponse = modelMapper.map(hungerLevel, HungerLevelResponse.class);
        System.out.println(hungerLevelResponse.getName() +", "+ hungerLevelResponse.getEnergy());
        return hungerLevelResponse;
    }
    @Override
    public List<HungerLevelResponse> getAllHungerLevel() {
        List<HungerLevel> hungerLevelsList = hungerLevelRepository.getAll();
        List<HungerLevelResponse>hungerLevelResponseList = hungerLevelsList.stream()
                .map(hungerLevel -> modelMapper.map(hungerLevel, HungerLevelResponse.class)).collect(Collectors.toList());
        for (HungerLevelResponse hungerLevelResponse: hungerLevelResponseList){
            System.out.println(hungerLevelResponse.getName()+", "
            +hungerLevelResponse.getEnergy());
        }
        return hungerLevelResponseList;
    }

}
