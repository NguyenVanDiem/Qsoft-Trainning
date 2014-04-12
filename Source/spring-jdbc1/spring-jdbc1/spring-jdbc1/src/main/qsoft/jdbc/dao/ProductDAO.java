package main.qsoft.jdbc.dao;

import main.qsoft.POJO.Order;
import main.qsoft.POJO.Product;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface ProductDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer serial, Integer year, String model, String manu, Double price);
    public Product getProduct(Integer id);
    public ArrayList<Product> listProduct();
    public void delete(Integer id);
    public void update(Integer id, Integer serial, Integer year, String model, String manu, Double price);
}
