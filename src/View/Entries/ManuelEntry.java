package View.Entries;

import controller.ManuelDiyetController;
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

public class ManuelEntry extends Visualize implements Entry {
    ManuelDiyetController c ;
    HungerLevelController ch;

    public ManuelEntry(ManuelDiyetController c, HungerLevelController ch, ProductController pc, ProductTypeController ptc) {
        super(pc,ptc);
        this.c = c;
        this.ch = ch;
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
    public double getCaloriesInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tercih ettiğiniz kalori değerini girin");
        double energy = sc.nextDouble();
        return energy;
    }
    public List<Integer> getPriorities(){
        Scanner sc = new Scanner(System.in);
        List<Integer> s  = super.getPriorities();
        return s;
    }
    @Override
    public List<ProductResponse> getProducts() {

        double energy= getCaloriesInfo();
        HungerLevelResponse hr = getHungerLevel();
        List<Integer> ptr = getPriorities();

        List<ProductResponse> productList  =  c.optionCalorieAndProduct(energy,ptr);
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
