package service;

import dto.request.HungerLevelRequest;
import dto.response.HungerLevelResponse;

import java.util.List;

public interface HungerLevelService {

    HungerLevelResponse addHungerLevel(HungerLevelRequest hungerLevelRequest);

    boolean deleteHungerLevel(int id);


    HungerLevelResponse getHungerLevel(int id);

    List<HungerLevelResponse> getAllHungerLevel();
}
