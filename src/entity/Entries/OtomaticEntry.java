package entity.Entries;

import controller.OtherControllers.HungerLevelController;
import controller.OtherControllers.ProductController;
import controller.OtoDiyetController;
import dto.request.UserRequest;
import dto.response.HungerLevelResponse;
import dto.response.ProductResponse;
import entity.Entry;

import java.util.List;
import java.util.Scanner;

public class OtomaticEntry extends Visualize implements Entry {
    OtoDiyetController c = new OtoDiyetController();
    HungerLevelController ch = new HungerLevelController();
    ProductController prod = new ProductController();

    public UserRequest getUserInfo(){
        UserRequest user = new UserRequest();
        Scanner sc = new Scanner(System.in);
        System.out.println("Cinsiyet bilginizi girin : E Erkek , K Kadın");

        do{
            String s = sc.nextLine();
            if ( s.equals("E") ||  s.equals("K")){
                if(s.equals(("E"))){
                    user.setGender("Erkek");
                }
                else{
                    user.setGender("Kadın");
                }
                break;
            }
            else{
                System.out.println("geçerli bir cinsiyet girin");
            }
        }while(true);

        System.out.println("Kilo değerinizi girin");
        user.setWeight(sc.nextInt());
        System.out.println("Boyunuzu cm cinsinden  girin");
        user.setHeight(sc.nextInt());
        System.out.println("Yaş değerinizi girin");
        user.setAge(sc.nextInt());
        return user;
    }
    public HungerLevelResponse getHungerLevel(){
        Scanner sc = new Scanner(System.in);
        System.out.println( "açlık seviyenizi girin ");
        for(HungerLevelResponse hr : ch.getAllHungerLevel()){
            System.out.print(hr.getName() + "|" + hr.getId());
            System.out.print( " || ");
        }
        System.out.println();
        int levelId;
        do{
            levelId = sc.nextInt();
            if (levelId >0 && levelId < 5){

                break;
            }
            else {
                System.out.println("geçerli bir açlık seviyesi girin");
            }
        }while(true);
        return ch.getHugerLevel(levelId);
    }
    @Override
    public List<ProductResponse> getProducts() {
        Scanner sc = new Scanner(System.in);
        UserRequest user = getUserInfo();
        double energy = c.totalEnergy(user);
        HungerLevelResponse hr = getHungerLevel();
        double requiredEnergy = c.requiredCalories(energy,hr.getId());


        List<ProductResponse> productList  =  c.optionCalorieAndProduct(requiredEnergy,null);
        // product primary Id tam olarak ne oluyor id yi buraya getirmek lazım ancak db de primary Id diye bir ifade yok
        // Hunger Level db sine isimle birlikte sorgu yapılamıyor bundan kaynaklı Id değerini HungerLevelResponse'a ekledim
        // ikinci bulgu List<Product> yerine List<ProductResponse> olmalı buna göre sistem ekrana yansıtma yapıyor.

        return productList;
    }


    @Override
    public void run() {
        List<ProductResponse> productList  = getProducts();
        showProducts(productList);
        selection();

    }
}
