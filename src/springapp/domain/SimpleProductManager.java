package springapp.domain;

import springapp.repository.ProductDao;

import java.util.List;

public class SimpleProductManager implements ProductManager {
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProductList();
    }

    public void increasePrice(int percentage) {
        List<Product> products = productDao.getProductList();
        for (Product product : products) {
            double newPrice = product.getPrice() * (100 + percentage) / 100;
            product.setPrice(newPrice);
            productDao.saveProduct(product);
        }
    }
}