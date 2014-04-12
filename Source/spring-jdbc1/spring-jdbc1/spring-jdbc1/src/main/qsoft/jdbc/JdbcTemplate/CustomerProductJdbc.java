package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.ContactOrder;
import main.qsoft.POJO.CustomerProduct;
import main.qsoft.jdbc.dao.CustomerProductDAO;
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
public class CustomerProductJdbc implements CustomerProductDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer cuid, Integer prid) {
         String SQL = "insert into customers_products(customer_id, product_id) values(?,?)";
        jdbc.update(SQL, new Object[]{cuid, prid});
    }

    @Override
    public CustomerProduct get(Integer cuid, Integer prid) {
        String SQL = "select * from customers_products where customer_id = ? and product_id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, cuid);
            pst.setInt(2, prid);
            CustomerProduct customerProduct = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                customerProduct = new CustomerProduct();
                customerProduct.setCustomerId(rs.getInt("customer_id"));
                customerProduct.setProductId(rs.getInt("product_id"));
            }
            rs.close();
            pst.close();
            return customerProduct;

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
    public ArrayList<CustomerProduct> list() {
        String SQL = "select * from customers_products";
        ArrayList<CustomerProduct> customerProducts = new ArrayList<CustomerProduct>();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            CustomerProduct customerProduct = null;
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                customerProduct = new CustomerProduct();
                customerProduct.setCustomerId(rs.getInt("customer_id"));
                customerProduct.setProductId(rs.getInt("product_id"));
                customerProducts.add(customerProduct);
            }
            rs.close();
            pst.close();
            return customerProducts;

        }catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public void delete(Integer cuid, Integer prid) {
        String SQL = "delete from customers_products where customer_id =? and product_id = ?";
        jdbc.update(SQL, new Object[]{cuid, prid});
    }

    @Override
    public void updateCustomerId(Integer cuid, Integer prid) {
        String SQL = "update customers_products set customer_id = ? where product_id =?";
        jdbc.update(SQL, new Object[]{cuid, prid});
    }

    @Override
    public void updateProductId(Integer cuid, Integer prid) {
        String SQL = "update customers_products set product_id =? where customer_id =?";
        jdbc.update(SQL, new Object[]{prid, cuid});
    }
}
