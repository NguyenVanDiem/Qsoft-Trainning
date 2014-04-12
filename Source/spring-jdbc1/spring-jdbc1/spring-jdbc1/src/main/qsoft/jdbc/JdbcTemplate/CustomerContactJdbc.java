package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.ContactOrder;
import main.qsoft.POJO.CustomerContact;
import main.qsoft.jdbc.dao.CustomerContactDAO;
import org.apache.derby.vti.VTICosting;
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
public class CustomerContactJdbc implements CustomerContactDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer cuid, Integer coid) {
        String SQL = "insert into customers_contacts(customer_id, contact_id) values(?, ?)";
        jdbc.update(SQL, new Object[]{cuid, coid});
    }

    @Override
    public CustomerContact getCustomerContact(Integer cuid, Integer coid) {
        String SQL = "select * from customers_contacts where contact_id = ? and customer_id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, coid);
            pst.setInt(2, cuid);
            CustomerContact customerContact = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                customerContact = new CustomerContact();
                customerContact.setConid(rs.getInt("contact_id"));
                customerContact.setCusid(rs.getInt("customer_id"));
            }
            rs.close();
            pst.close();
            return customerContact;

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
    public ArrayList<CustomerContact> listCustomerContact() {
        String SQL = "select * from customers_contacts";
        ArrayList<CustomerContact> customerContacts = new ArrayList<CustomerContact>();
        CustomerContact customerContact = new CustomerContact();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                customerContact = new CustomerContact();
                customerContact.setConid(rs.getInt("contact_id"));
                customerContact.setCusid(rs.getInt("customer_id"));

                customerContacts.add(customerContact);
            }
            return customerContacts;
        }catch (SQLException e){e.printStackTrace();}
        return customerContacts;
    }

    @Override
    public void delete(Integer cuid, Integer coid) {
        String SQL = "delete from customers_contacts where contact_id = ? and customer_id = ?";
        jdbc.update(SQL, new Object[]{coid, cuid});
    }

    @Override
    public void updateCustomerId(Integer cuid, Integer coid) {
        String SQL = "update customers_contacts set customer_id = ? where contact_id = ?";
        jdbc.update(SQL, new Object[]{cuid, coid});
    }

    @Override
    public void updateContactId(Integer cuid, Integer coid) {
        String SQL = "update customers_contacts set contact_id = ? where customer_id = ?";
        jdbc.update(SQL, new Object[]{coid, cuid});
    }
}
