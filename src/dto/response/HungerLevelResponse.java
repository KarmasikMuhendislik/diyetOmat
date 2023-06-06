package dto.response;

import entity.HungerLevel;

public class HungerLevelResponse {

    private int Id;
    private String name;
    private double energy;

    public HungerLevelResponse() {
    }
    public HungerLevelResponse(int Id,String name, Double energy){
        this.Id=Id;
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
