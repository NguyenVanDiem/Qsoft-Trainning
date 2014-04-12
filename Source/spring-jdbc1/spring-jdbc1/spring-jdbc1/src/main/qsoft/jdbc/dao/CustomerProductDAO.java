package main.qsoft.jdbc.dao;

import main.qsoft.POJO.CustomerContact;
import main.qsoft.POJO.CustomerProduct;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface CustomerProductDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer cuid, Integer coid);
    public CustomerProduct get(Integer cuid, Integer prid);
    public ArrayList<CustomerProduct> list();
    public void delete(Integer cuid, Integer prid);
    public void updateCustomerId(Integer cuid, Integer prid);
    public void updateProductId(Integer cuid, Integer prid);
}
