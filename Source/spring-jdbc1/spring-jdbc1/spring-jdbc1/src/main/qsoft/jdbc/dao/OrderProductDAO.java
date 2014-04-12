package main.qsoft.jdbc.dao;

import main.qsoft.POJO.OrderProduct;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface OrderProductDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer cuid, Integer oid);
    public OrderProduct get(Integer oid, Integer prid);
    public ArrayList<OrderProduct> list();
    public void delete(Integer oid, Integer prid);
    public void updateOrderId(Integer oid, Integer prid);
    public void updateProductId(Integer oid, Integer prid);
}
