package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.CustomerContact;
import main.qsoft.POJO.CustomerOrder;
import main.qsoft.jdbc.dao.CustomerOrderDAO;
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
public class CustomerOrderJdbc implements CustomerOrderDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer cuid, Integer oid) {
        String SQL = "insert into customers_orders(customer_id, order_id) values(?,?)";
        jdbc.update(SQL, new Object[]{cuid, oid});
    }

    @Override
    public CustomerOrder get(Integer cuid, Integer oid) {
        String SQL = "select * from customers_orders where order_id = ? and customer_id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, oid);
            pst.setInt(2, cuid);
            CustomerOrder customerorder = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                customerorder = new CustomerOrder();
                customerorder.setOrid(rs.getInt("order_id"));
                customerorder.setCuid(rs.getInt("customer_id"));
            }
            rs.close();
            pst.close();
            return customerorder;

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
    public ArrayList<CustomerOrder> list() {
        String SQL = "select * from customers_orders";
        ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
        CustomerOrder customerOrder = new CustomerOrder();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                customerOrder = new CustomerOrder();
                customerOrder.setOrid(rs.getInt("order_id"));
                customerOrder.setCuid(rs.getInt("customer_id"));

                customerOrders.add(customerOrder);
            }
            return customerOrders;
        }catch (SQLException e){e.printStackTrace();}
        return customerOrders;

    }

    @Override
    public void delete(Integer cuid, Integer oid) {
        String SQL = "delete from customers_orders where order_id = ? and customer_id = ?";
        jdbc.update(SQL, new Object[]{oid, cuid});
    }

    @Override
    public void updateCustomerId(Integer cuid, Integer oid) {
        String SQL = "update customers_orders set customer_id = ? where order_id = ?";
        jdbc.update(SQL, new Object[]{cuid, oid});
    }

    @Override
    public void updateOrderId(Integer cuid, Integer oid) {
        String SQL = "update customers_orders set order_id = ? where customer_id =?";
        jdbc.update(SQL, new Object[]{oid, cuid});
    }
}
