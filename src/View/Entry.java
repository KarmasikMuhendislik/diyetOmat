package View;

import dto.response.ProductResponse;

import java.util.List;

public interface Entry {
    public List<ProductResponse> getProducts();
    public void run();
}
