package entity;

public class HungerLevel {
    private int id;
    private String name;
    private double energy;

    public HungerLevel(){

    }

    public HungerLevel(String name, double energy){
        this.name = name;
        this.energy = energy;
    }

    public HungerLevel(int id, String name, double energy) {
        this.id = id;
        this.name = name;
        this.energy = energy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
