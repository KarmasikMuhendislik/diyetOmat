package entity;

public class User {
    private int id;
    private String gender;
    private int weight;
    private int height;
    private int age;

    public User(){

    }
    public User(String gender, int height, int weight, int age) {
        this.gender = gender;
        this.height =height;
        this.weight = weight;
        this.age =age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String  gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
