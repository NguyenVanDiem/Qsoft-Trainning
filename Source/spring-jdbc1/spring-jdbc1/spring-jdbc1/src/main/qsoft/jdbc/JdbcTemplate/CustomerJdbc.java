package main.qsoft.jdbc.JdbcTemplate;

import main.qsoft.POJO.Customer;
import main.qsoft.jdbc.dao.CustomerDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class CustomerJdbc implements CustomerDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbc;

//    private ParameterizedRowMapper<Customer> customerRowMapper = new ParameterizedRowMapper<Customer>() {
//        @Override
//        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//            Customer customer = new Customer();
//            customer.setId(resultSet.getInt(i));
//            customer.setName(resultSet.getString(i));
//            customer.setAddress(resultSet.getString(i));
//            customer.setPhone(resultSet.getInt(i));
//            customer.setFax(resultSet.getInt(i));
//            customer.setAvatar(resultSet.getString(i));
//            return customer;
//        }
//    };
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, String address, String tel, String fax, String ava) {
        String SQL = "insert into customers(name, address, phone, fax, avatar) values(?,?,?,?,?)";
        jdbc.update(SQL, new Object[]{name,address,tel,fax,ava});
//        System.out.println("insert customer = "+name);
//        System.out.println("address = "+address);
//        System.out.println("tel = "+ tel);
//        System.out.println("fax = "+ fax);
//        System.out.println("avatar = "+ava);
    }

    @Override
    public Customer getCustomer(Integer id) {
        String SQL = "select * from customers where id = ?";


//
//        customer = (Customer) jdbc.queryForObject(SQL, new Object[]{id}, customerRowMapper);
//        System.out.println("get customer successful");
//        System.out.println(customer.getName());
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setInt(1, id);
            Customer customer = null;
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setPhone(rs.getString("phone"));
                customer.setFax(rs.getString("fax"));
                customer.setAvatar(rs.getString("avatar"));
            }
            rs.close();
            pst.close();
            return customer;

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
    public ArrayList<Customer> listCustomers() {
        String SQL = "select * from customers";
        //List<Customer> customers = jdbc.query(SQL, customerRowMapper);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setPhone(rs.getString("phone"));
                customer.setFax(rs.getString("fax"));
                customer.setAvatar(rs.getString("avatar"));
                customers.add(customer);
            }
            return customers;
        }catch (SQLException e){e.printStackTrace();}
        return customers;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from customers where id = ?";
        jdbc.update(SQL, new Object[]{id});
    }

    @Override
    public void update(Integer id, String name, String add, String tel, String fax, String ava) {
        String SQL = "update customers set name = ?, address = ?, phone = ?, fax = ?, avatar = ?where id =?";
        jdbc.update(SQL, new Object[]{name, add, tel, fax, ava,id});
    }
}
