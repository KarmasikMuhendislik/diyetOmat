package entity.Entries;

import controller.DirectDiyetController;
import dto.response.ProductResponse;
import entity.Entry;

import java.util.List;
import java.util.Scanner;

public class DirectEntry extends Visualize implements Entry {
    private DirectDiyetController c = new DirectDiyetController();
    @Override
    public List<ProductResponse> getProducts() {
        return c.getProductList();
    }

    @Override
    public void run(){
        List<ProductResponse> productList =  getProducts();
        showProducts(productList);
        selection();
    }


}
