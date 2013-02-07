package springapp.repository;

import springapp.domain.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}