package dto.response;

import entity.HungerLevel;

public class HungerLevelResponse {
    private String name;
    private double energy;

    public HungerLevelResponse() {
    }
    public HungerLevelResponse(String name, Double energy){
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }
}
