package main.qsoft.jdbc.dao;

import main.qsoft.POJO.Contact;
import main.qsoft.POJO.Order;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface OrderDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer number, Double amount, Integer status, Date create, Date update);
    public Order getOrder(Integer id);
    public ArrayList<Order> listOrder();
    public void delete(Integer id);
    public void update(Integer id, Integer number, Double amount, Integer status, Date create, Date update);
}
