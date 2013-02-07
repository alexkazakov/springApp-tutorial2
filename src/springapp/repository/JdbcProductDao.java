package springapp.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import springapp.domain.Product;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    /**
     * Logger for this class and subclasses
     */
    protected final Log logger = LogFactory.getLog(getClass());
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDatasource(DataSource datasource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(datasource);
    }

    public List<Product> getProductList() {
        logger.info("Getting products!");
        List<Product> products = jdbcTemplate.query(
                "select id, description, price from products", new HashMap<String, Object>(), new ProductMapper());
        return products;
    }

    public void saveProduct(Product prod) {
        logger.info("Saving product: " + prod.getDescription());
        int count = jdbcTemplate.update(
                "update products set price = :price where id = :id",
                new MapSqlParameterSource().addValue("price", prod.getPrice())
                        .addValue("id", prod.getId()));
        logger.info("Rows affected: " + count);
    }

    private static class ProductMapper implements RowMapper<Product> {

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product prod = new Product();
            prod.setId(rs.getInt("id"));
            prod.setDescription(rs.getString("description"));
            prod.setPrice(new Double(rs.getDouble("price")));
            return prod;
        }

    }

}