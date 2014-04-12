package main.qsoft.jdbc.dao;

import main.qsoft.POJO.Contact;
import main.qsoft.POJO.ContactOrder;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface ContactOrderDAO {
    public void setDataSource(DataSource ds);
    public void create(Integer cid, Integer oid);
    public ContactOrder getContactOrder(Integer cid, Integer oid);
    public ArrayList<ContactOrder> listContactOrder();
    public void delete(Integer cid, Integer oid);
    public void updateOrderId(Integer cid, Integer oid);
    public void updateContactId(Integer cid, Integer oid);
}
