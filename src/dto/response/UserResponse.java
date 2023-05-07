package dto.response;

public class UserResponse {
    private String gender;
    private int weight;
    private int height;
    private int age;
    public UserResponse(){

    }
    public UserResponse(String gender, int height, int weight, int age) {
        this.gender = gender;
        this.height = height;
        this.age = age;
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
