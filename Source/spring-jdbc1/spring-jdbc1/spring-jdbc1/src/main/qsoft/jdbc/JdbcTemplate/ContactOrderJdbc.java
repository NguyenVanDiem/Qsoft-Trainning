package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.Contact;
import main.qsoft.POJO.ContactOrder;
import main.qsoft.jdbc.dao.ContactOrderDAO;
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
public class ContactOrderJdbc implements ContactOrderDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer cid, Integer oid) {
        String SQL = "insert into contacts_orders(contact_id, order_id) values(?, ?)";
        jdbc.update(SQL, new Object[]{cid, oid});
    }

    @Override
    public ContactOrder getContactOrder(Integer cid, Integer oid) {
        String SQL = "select * from contacts_orders where contact_id = ? and order_id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, cid);
            pst.setInt(2, oid);
            ContactOrder contactOrder = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                contactOrder = new ContactOrder();
                contactOrder.setContact_id(rs.getInt("contact_id"));
                contactOrder.setOrder_id(rs.getInt("order_id"));
            }
            rs.close();
            pst.close();
            return contactOrder;

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
    public ArrayList<ContactOrder> listContactOrder() {
        String SQL = "select * from contacts_orders";
        ArrayList<ContactOrder> contactOrders = new ArrayList<ContactOrder>();
        ContactOrder contactOrder = new ContactOrder();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                contactOrder = new ContactOrder();
                contactOrder.setOrder_id(rs.getInt("order_id"));
                contactOrder.setContact_id(rs.getInt("contact_id"));

                contactOrders.add(contactOrder);
            }
            return contactOrders;
        }catch (SQLException e){e.printStackTrace();}
        return contactOrders;
    }

    @Override
    public void delete(Integer cid, Integer oid) {
        String SQL = "delete from contacts_orders where contact_id = ? and order_id = ?";
        jdbc.update(SQL, new Object[]{cid, oid});
    }

    @Override
    public void updateOrderId(Integer cid, Integer oid) {
        String SQL = "update contacts_orders set order_id = ? where contact_id = ?";
        jdbc.update(SQL, new Object[]{oid, cid});
    }

    @Override
    public void updateContactId(Integer cid, Integer oid) {
        String SQL = "update contacts_orders set contact_id = ? where order_id =?";
        jdbc.update(SQL, new Object[]{cid, oid});
    }
}
