package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.Order;
import main.qsoft.POJO.Product;
import main.qsoft.jdbc.dao.ProductDAO;
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
public class ProductJdbc implements ProductDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Integer serial, Integer year, String model, String manu, Double price) {
        String SQL = "insert into products ( serial, year,  model,  manufacturer, price) values(?,?,?,?,?)";
        jdbc.update(SQL, new Object[]{serial,year,model,manu,price});
    }

    @Override
    public Product getProduct(Integer id) {
        String SQL = "select * from products where id = ?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, id);
            Product product = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setSerial(rs.getInt("serial"));
                product.setYear(rs.getInt("year"));
                product.setModel(rs.getString("model"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setPrice(rs.getDouble("price"));
            }
            rs.close();
            pst.close();
            return product;

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
    public ArrayList<Product> listProduct() {
        String SQL = "select * from products";
        ArrayList<Product> products = new ArrayList<Product>();
        Product product = null;
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setSerial(rs.getInt("serial"));
                product.setYear(rs.getInt("year"));
                product.setModel(rs.getString("model"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
            return products;
        }catch (SQLException e){e.printStackTrace();}
        return products;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from products where id = ?";
        jdbc.update(SQL, new Object[]{id});
    }

    @Override
    public void update(Integer id, Integer serial, Integer year, String model, String manu, Double price) {
        String SQL = "update products set serial = ?, year = ?, model = ?, manufacturer = ?, price = ?where id =?";
        jdbc.update(SQL, new Object[]{serial, year, model, manu,price,id});
    }
}
