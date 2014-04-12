package main.qsoft.jdbc.test;

import main.qsoft.POJO.Customer;
import main.qsoft.jdbc.JdbcTemplate.CustomerJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testCustomer {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");

        CustomerJdbc customerJdbc = (CustomerJdbc) factory.getBean("customerJdbc");
        /*
        Test add
         */
        //customerJdbc.create("Ngo Dinh Nguyen", "TS-BN", "123516", "123516", "avatar link");
        /*
        Test get
         */
//        Customer customer = customerJdbc.getCustomer((Integer)5);
//        System.out.println(customer.getName());
        /*
        Test delete
         */
        //customerJdbc.delete(3);

        /*
        Test get all
         */
//        ArrayList<Customer> customers = customerJdbc.listCustomers();
//        if(customers != null)
//            for(Customer c:customers)
//                System.out.println(c.getName());
//        else
//            System.out.println("customers is null");
        /*
        Test update
         */
        //customerJdbc.update(4, "ngo dinh nguyen change", "Tu Son change", "+76453", "+1342341", "change");
    }
}
