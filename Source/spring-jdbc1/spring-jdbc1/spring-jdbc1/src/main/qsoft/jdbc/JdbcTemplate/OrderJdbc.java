package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.Contact;
import main.qsoft.POJO.Order;
import main.qsoft.jdbc.dao.OrderDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class OrderJdbc implements OrderDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer number, Double amount, Integer status, Date create, Date update) {
        String SQL = "insert into orders(number, amount, status, created_date, updated_date) values(?,?,?,?,?)";
        jdbc.update(SQL, new Object[]{number,amount,status,create,update});
    }

    @Override
    public Order getOrder(Integer id) {
        String SQL = "select * from orders where id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, id);
            Order order = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setNumber(rs.getInt("number"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setCreate(rs.getDate("created_date"));
                order.setUpdate(rs.getDate("updated_date"));
            }
            rs.close();
            pst.close();
            return order;

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
    public ArrayList<Order> listOrder() {
        String SQL = "select * from orders";
        ArrayList<Order> orders = new ArrayList<Order>();
        Order order = new Order();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setNumber(rs.getInt("number"));
                order.setAmount(rs.getDouble("amount"));
                order.setStatus(rs.getInt("status"));
                order.setCreate(rs.getDate("created_date"));
                order.setUpdate(rs.getDate("updated_date"));
                orders.add(order);
            }
            return orders;
        }catch (SQLException e){e.printStackTrace();}
        return orders;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from orders where id = ?";
        jdbc.update(SQL, new Object[]{id});
    }

    @Override
    public void update(Integer id, Integer number, Double amount, Integer status, Date create, Date update) {
        String SQL = "update orders set number = ?, amount = ?, status = ?, created_date = ?, updated_date = ?where id =?";
        jdbc.update(SQL, new Object[]{number, amount, status, create, update,id});
    }
}
