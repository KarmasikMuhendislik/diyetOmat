package entity.Entries;

import controller.OtherControllers.ProductController;
import dto.response.ProductResponse;

import java.util.List;
import java.util.Scanner;

public class Visualize {
    ProductController prod = new ProductController();
    public void showProducts(List<ProductResponse> productList) {

        System.out.println("Ürün Listesi");
        System.out.println("Product Id || Product ismi || Product Tipi || Product ücreti || Product kalorisi ");
        for (ProductResponse p : productList
        ) {
            System.out.println(p.getId() + " || " + p.getProductName() +" || " + p.getProductType() + " || " + p.getProductFee() + " || " + p.getProductFeatures());
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
    public void selection() {

        System.out.println("tercih ettiğiniz diyetin id değerini girin");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        ProductResponse p = prod.getProduct(id);
        System.out.println("seçtiğiniz diyet bilgileri:");
        System.out.println(p.getId() + " || " + p.getProductName() +" || " + p.getProductType() + " || " + p.getProductFee() + " || " + p.getProductFeatures());

        do{
            System.out.println("girilecek tutar :" + p.getProductFee());
            System.out.println("iptal için 0 girin");
            int payment = sc.nextInt();
            if (payment == p.getProductFee() && payment!=0){
                System.out.println("ödeme başarılı afiyet olsun");
                break;
            }
            else if (payment==0){
                System.out.println("sipariş iptal edildi");
                break;
            }
            else{
                System.out.println("ödeme başarısız tekrar deneyin");
            }

        }
        while (true);




    }
}
