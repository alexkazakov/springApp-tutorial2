package springapp.domain;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ak
 * Date: 06.02.13
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class ProductTest {
    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product();
    }

    @Test
    public void testGetAndSetDescription() throws Exception {
        String description = "Milk";
        Assert.assertNull(product.getDescription());
        product.setDescription(description);
        Assert.assertEquals(product.getDescription(), description);
    }

    @Test
    public void testGetAndSetPrice() throws Exception {
        double price = 100.0;
        Assert.assertNull(product.getPrice());
        product.setPrice(price);
        Assert.assertEquals(product.getPrice(), price);
    }
}
