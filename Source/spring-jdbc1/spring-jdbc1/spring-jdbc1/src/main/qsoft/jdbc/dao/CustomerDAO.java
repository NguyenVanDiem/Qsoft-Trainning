package main.qsoft.jdbc.dao;

import main.qsoft.POJO.Customer;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface CustomerDAO {
    public void setDataSource(DataSource ds);
    public void create(String name, String address, String phone, String fax, String ava);
    public Customer getCustomer(Integer id);
    public ArrayList<Customer> listCustomers();
    public void delete(Integer id);
    public void update(Integer id, String name, String add, String phone, String fax, String ava);
}
