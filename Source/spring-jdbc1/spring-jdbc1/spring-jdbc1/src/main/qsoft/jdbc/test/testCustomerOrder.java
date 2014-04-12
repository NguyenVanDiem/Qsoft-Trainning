package main.qsoft.jdbc.test;

import main.qsoft.POJO.CustomerOrder;
import main.qsoft.jdbc.JdbcTemplate.CustomerOrderJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testCustomerOrder {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        CustomerOrderJdbc jdbc = (CustomerOrderJdbc) factory.getBean("customer_orderJdbc");

        /*
        test create
         */
        //jdbc.create(123, 789);

        /*
        test get
         */
//        System.out.println(jdbc.get(123, 456).getCuid());

        /*
        test get all
         */
//        for(CustomerOrder c: jdbc.list()){
//            System.out.println(c.getCuid());
//        }

        /*
        test delete
         */
//        jdbc.delete(123, 456);

        /*
        test update customer id
         */
//        jdbc.updateCustomerId(456, 789);

        /*
        test update order id
         */
//        jdbc.updateOrderId(456, 123);
    }
}
