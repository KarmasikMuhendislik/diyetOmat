package View.Entries;

import controller.DirectDiyetController;
import controller.OtherControllers.ProductController;
import controller.OtherControllers.ProductTypeController;
import dto.response.ProductResponse;
import View.Entry;
import entity.Product;

import java.util.List;
import java.util.Scanner;

public class DirectEntry extends Visualize implements Entry {
    private DirectDiyetController c ;

    public DirectEntry(DirectDiyetController c, ProductController pc, ProductTypeController ptc) {
        super(pc,ptc);
        this.c = c;
    }

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
