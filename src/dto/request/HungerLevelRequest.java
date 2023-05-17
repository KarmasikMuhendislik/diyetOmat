package dto.request;

public class HungerLevelRequest {
    private String name;
    private double energy;

    public HungerLevelRequest(){

    }

    public HungerLevelRequest(String name, Double energy){
        this.setEnergy(energy);
        this.setName(name);
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
