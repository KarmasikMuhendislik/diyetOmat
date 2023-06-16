package View.Entries;

import controller.OtherControllers.ProductController;
import controller.OtherControllers.ProductTypeController;
import dto.response.ProductResponse;

import java.util.List;
import java.util.Scanner;

public class Visualize {
    ProductController prod ;
    ProductTypeController prodType;

    public Visualize(ProductController prod, ProductTypeController prodType) {
        this.prod = prod;
        this.prodType = prodType;
    }

    public void showProducts(List<ProductResponse> productList) {

        System.out.println("Ürün Listesi");
        System.out.println("Product Id || Product İsmi || Product Tipi || Product Ücreti || Product Kalorisi ");
        for (ProductResponse p : productList
        ) {
            System.out.println(p.getId() + " || " + p.getProductName() +" || " + p.getProductType() + " || " + p.getProductFee() + " || " + p.getProductFeatures());
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

    public List<Integer> getPriorities(){
        Scanner sc = new Scanner(System.in);
        List<String> priorityList = prodType.getProductPrimaryName();
        System.out.println("Aşağıdaki diyet türlerinden birini seçin ve seçiminizi yazın:");
        System.out.println("---");
        for (String s : priorityList
             ) {
            System.out.println(s);
        }
        System.out.println("---");
        do{
            String s = sc.nextLine();
            if (priorityList.contains(s)){
                return prodType.getPrimaryName(s);
            }
            else{
                System.out.println("Diyet türünü düzgün yazın.");
            }

        }while(true);



    }
    public void selection() {

        System.out.println("Tercih ettiğiniz diyetin id değerini girin");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        ProductResponse p = prod.getProduct(id);
        System.out.println("Seçtiğiniz diyet bilgileri:");
        System.out.println(p.getId() + " || " + p.getProductName() +" || " + p.getProductType() + " || " + p.getProductFee() + " || " + p.getProductFeatures());

        do{
            System.out.println("Girilecek tutar :" + p.getProductFee());
            System.out.println("İptal için 0 girin");
            int payment = sc.nextInt();
            if (payment == p.getProductFee() && payment!=0){
                System.out.println("Ödeme başarılı afiyet olsun.");
                break;
            }
            else if (payment==0){
                System.out.println("Sipariş iptal edildi.");
                break;
            }
            else{
                System.out.println("Ödeme başarısız tekrar deneyin.");
            }

        }
        while (true);




    }
}
