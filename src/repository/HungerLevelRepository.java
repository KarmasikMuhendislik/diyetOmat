package repository;

import entity.HungerLevel;

import java.util.List;

public interface HungerLevelRepository {
    HungerLevel addHungerLevel(HungerLevel hungerLevel);

    boolean deleteHungerLevel(int id);

    HungerLevel getHungerLevel(int id);

    List<HungerLevel> getAll();
}
