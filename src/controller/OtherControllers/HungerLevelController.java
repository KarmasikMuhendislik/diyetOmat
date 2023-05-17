package controller.OtherControllers;

import dto.request.HungerLevelRequest;
import dto.response.HungerLevelResponse;
import service.HungerLevelService;
import service.serviceImpl.HungerLevelServiceImpl;

import java.util.List;

public class HungerLevelController {

    private final HungerLevelService hungerLevelService;

    public HungerLevelController( ) {
        this.hungerLevelService = new HungerLevelServiceImpl();
    }


    public HungerLevelResponse addHungerLevel(HungerLevelRequest hungerLevelRequest){
        return hungerLevelService.addHungerLevel(hungerLevelRequest);
    }
    public boolean deleteHungerLevel(int id){
        return hungerLevelService.deleteHungerLevel(id);
    }

    public HungerLevelResponse getHugerLevel(int id){
        return hungerLevelService.getHungerLevel(id);
    }

    public List<HungerLevelResponse> getAllHungerLevel(){
        return hungerLevelService.getAllHungerLevel();
    }
}
