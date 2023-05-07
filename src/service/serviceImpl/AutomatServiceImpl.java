package service.serviceImpl;

import entity.Product;
import repository.ProductRepository;
import repository.repositoryImpl.ProductRepositoryImpl;
import service.AutomatService;
import java.util.Scanner;

public class AutomatServiceImpl implements AutomatService {
    private final ProductRepository productRepository;

    public AutomatServiceImpl( ) {
        this.productRepository = new ProductRepositoryImpl();
    }

    @Override
    public void directEntry() {
        //Bu service gelindiğinde ekrana önce liste gelsin istiyorum.
        productRepository.getAllProduct();
        //Bundan sonra gelen ürünler içerisinden seçme işlemi olacak ve burada seçem işlemi nasıl olur acaba
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ürün No: ");
        int productNo = scanner.nextInt();
        Product product = productRepository.getProduct(productNo);
        //Ödeme service gidilmesi gerekiyor

    }
}
