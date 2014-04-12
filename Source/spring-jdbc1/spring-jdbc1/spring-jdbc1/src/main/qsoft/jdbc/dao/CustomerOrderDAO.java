package main.qsoft.jdbc.dao;

import main.qsoft.POJO.CustomerContact;
import main.qsoft.POJO.CustomerOrder;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface CustomerOrderDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer cuid, Integer oid);
    public CustomerOrder get(Integer cuid, Integer oid);
    public ArrayList<CustomerOrder> list();
    public void delete(Integer cuid, Integer oid);
    public void updateCustomerId(Integer cuid, Integer oid);
    public void updateOrderId(Integer cuid, Integer oid);
}
