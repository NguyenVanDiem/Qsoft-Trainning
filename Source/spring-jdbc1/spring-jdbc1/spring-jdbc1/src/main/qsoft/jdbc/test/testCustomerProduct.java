package main.qsoft.jdbc.test;

import main.qsoft.POJO.CustomerProduct;
import main.qsoft.jdbc.JdbcTemplate.CustomerProductJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testCustomerProduct {
    public static void main(String[] args) {
        BeanFactory factory =  new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        CustomerProductJdbc jdbc = (CustomerProductJdbc) factory.getBean("customer_productJdbc");

        /*
        test create
         */
//       jdbc.create(123, 7189);

        /*
        test get
         */
//        System.out.println(jdbc.get(123, 456).getCustomerId());
        /*
        test get all
         */
//        for(CustomerProduct c:jdbc.list()){
//            System.out.println(c.getCustomerId());
//        }
        /*
        test delete
         */
//        jdbc.delete(123, 456);
        /*
        test update customer id
         */
//        jdbc.updateCustomerId(321, 789);

        /*
        test update product id
         */
        jdbc.updateProductId(321,999);
    }
}
