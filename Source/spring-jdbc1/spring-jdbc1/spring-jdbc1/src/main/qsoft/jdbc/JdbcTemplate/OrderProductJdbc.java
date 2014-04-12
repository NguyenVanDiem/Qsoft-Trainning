package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.OrderProduct;
import main.qsoft.jdbc.dao.OrderProductDAO;
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
public class OrderProductJdbc implements OrderProductDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer oid, Integer pid) {
        String SQL = "insert into orders_products(order_id, product_id) values(?, ?)";
        jdbc.update(SQL, new Object[]{oid, pid});
    }

    @Override
    public OrderProduct get(Integer oid, Integer prid) {
        String SQL = "select * from orders_products where order_id = ? and product_id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, oid);
            pst.setInt(2, prid);
            OrderProduct orderProduct = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                orderProduct = new OrderProduct();
                orderProduct.setOrderId(rs.getInt("order_id"));
                orderProduct.setProductId(rs.getInt("product_id"));
            }
            rs.close();
            pst.close();
            return orderProduct;

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
    public ArrayList<OrderProduct> list() {
        String SQL = "select * from orders_products";
        ArrayList<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            OrderProduct orderProduct = null;
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                orderProduct = new OrderProduct();
                orderProduct.setOrderId(rs.getInt("order_id"));
                orderProduct.setProductId(rs.getInt("product_id"));
                orderProducts.add(orderProduct);
            }
            rs.close();
            pst.close();
            return orderProducts;

        }catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public void delete(Integer oid, Integer prid) {
        String SQL = "delete from orders_products where order_id = ? and product_id =?";
        jdbc.update(SQL, new Object[]{oid, prid});
    }

    @Override
    public void updateOrderId(Integer oid, Integer prid) {
        String SQL = "update orders_products set order_id = ? where product_id =?";
        jdbc.update(SQL, new Object[]{oid, prid});
    }

    @Override
    public void updateProductId(Integer oid, Integer prid) {
        String SQL = "update orders_products set product_id = ? where order_id =?";
        jdbc.update(SQL, new Object[]{prid, oid});
    }

}
