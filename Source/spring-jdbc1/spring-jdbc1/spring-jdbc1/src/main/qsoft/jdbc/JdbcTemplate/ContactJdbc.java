package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.Contact;
import main.qsoft.jdbc.dao.ContactDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class ContactJdbc implements ContactDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, String phone, String email, Integer main, String job) {
        String SQL = "insert into contacts(name, phone, email, main, job_title) values(?,?,?,?,?)";
        jdbc.update(SQL, new Object[]{name,phone,email,main,job});
    }

    @Override
    public Contact getContact(Integer id) {
        String SQL = "select * from contacts where id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, id);
            Contact contact = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setPhone(rs.getString("phone"));
                contact.setEmail(rs.getString("email"));
                contact.setMain(rs.getInt("main"));
                contact.setJob_title(rs.getString("job_title"));
            }
            rs.close();
            pst.close();
            return contact;

        }catch (SQLException e){throw new RuntimeException(e);}
        finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){

                }
            }
        }
    }

    @Override
    public ArrayList<Contact> listContact() {
        String SQL = "select * from contacts";
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Contact contact = new Contact();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setPhone(rs.getString("phone"));
                contact.setEmail(rs.getString("email"));
                contact.setMain(rs.getInt("main"));
                contact.setJob_title(rs.getString("job_title"));
                contacts.add(contact);
            }
            return contacts;
        }catch (SQLException e){e.printStackTrace();}
        return contacts;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from contacts where id = ?";
        jdbc.update(SQL, new Object[]{id});
    }

    @Override
    public void update(Integer id, String name, String phone, String email, Integer main, String job) {
        String SQL = "update contacts set name = ?, phone = ?, email = ?, main = ?, job_title = ?where id =?";
        jdbc.update(SQL, new Object[]{name, phone, email, main, job,id});
    }
}
