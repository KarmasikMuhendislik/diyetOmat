package View.Entries;

import controller.OtherControllers.HungerLevelController;
import controller.OtherControllers.ProductController;
import controller.OtherControllers.ProductTypeController;
import controller.OtoDiyetController;
import dto.request.UserRequest;
import dto.response.HungerLevelResponse;
import dto.response.ProductResponse;
import View.Entry;

import java.util.List;
import java.util.Scanner;

public class OtomaticEntry extends Visualize implements Entry {
    OtoDiyetController c;
    HungerLevelController ch;
    ProductController prod;

    ProductTypeController prodType;

    public OtomaticEntry(OtoDiyetController c, HungerLevelController ch, ProductController prod, ProductTypeController prodType) {
        super(prod,prodType);
        this.c = c;
        this.ch = ch;
        this.prod = prod;
        this.prodType = prodType;
    }

    public UserRequest getUserInfo(){
        UserRequest user = new UserRequest();
        Scanner sc = new Scanner(System.in);
        System.out.println("Cinsiyet bilginizi girin : E Erkek , K Kadın");

        do{
            String s = sc.nextLine();
            if ( s.equals("E") ||  s.equals("K")){
                if(s.equals(("E"))){
                    user.setGender("E");
                }
                else{
                    user.setGender("K");
                }
                break;
            }
            else{
                System.out.println("Geçerli bir cinsiyet girin:");
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
        System.out.println( "Açlık seviyenizi girin: ");
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
                System.out.println("Geçerli bir açlık seviyesi girin:");
            }
        }while(true);
        System.out.println("hunger level id :"+ levelId);
        System.out.println(ch.getHugerLevel(levelId).getId());
        System.out.println("-----");
        return ch.getHugerLevel(levelId);
    }
    public List<Integer> getPriorities(){
        Scanner sc = new Scanner(System.in);
        List<Integer> s  = super.getPriorities();
        return s;
    }
    @Override
    public List<ProductResponse> getProducts() {
        Scanner sc = new Scanner(System.in);
        UserRequest user = getUserInfo();
        double energy = c.totalEnergy(user);
        HungerLevelResponse hr = getHungerLevel();

        double requiredEnergy = c.requiredCalories(energy,hr.getId());

        List<Integer> ptr = getPriorities();


        System.out.println("parameters:");
        System.out.println(energy);
        System.out.println(hr.getId());

        System.out.println("Gerekli Kalori: "+ (int)requiredEnergy);
        for (Integer i : ptr
             ) {
            System.out.println("id:"+i);
        }


        List<ProductResponse> productList  =  c.optionCalorieAndProduct(requiredEnergy,ptr);
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
