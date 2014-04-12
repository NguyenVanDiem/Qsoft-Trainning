package main.qsoft.jdbc.dao;

import main.qsoft.POJO.Contact;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public interface ContactDAO {
    public void setDataSource(DataSource ds);
    public void create(String name, String phone, String email, Integer main, String job);
    public Contact getContact(Integer id);
    public ArrayList<Contact> listContact();
    public void delete(Integer id);
    public void update(Integer id, String name, String phone, String email, Integer main, String job);
}
