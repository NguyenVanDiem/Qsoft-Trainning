package main.qsoft.jdbc.dao;

import main.qsoft.POJO.CustomerContact;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface CustomerContactDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer cuid, Integer coid);
    public CustomerContact getCustomerContact(Integer cuid, Integer coid);
    public ArrayList<CustomerContact> listCustomerContact();
    public void delete(Integer cuid, Integer coid);
    public void updateCustomerId(Integer coid, Integer cuid);
    public void updateContactId(Integer cuid, Integer coid);
}
