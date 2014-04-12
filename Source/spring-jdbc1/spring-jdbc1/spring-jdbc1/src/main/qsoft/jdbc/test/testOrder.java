package main.qsoft.jdbc.test;

import main.qsoft.POJO.Order;
import main.qsoft.jdbc.JdbcTemplate.OrderJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testOrder {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        OrderJdbc jdbc = (OrderJdbc) factory.getBean("orderJdbc");
        /*
        test add
         */
        //jdbc.create(1242, 70001.4, 0, new Date(1,1,1989), new Date(1,2,1799));

        /*
        test get
         */
//        Order order = jdbc.getOrder(1);
//        System.out.println(order.getAmount());

        /*
        test get all
         */
//        ArrayList<Order> orders = jdbc.listOrder();
//        for(Order o:orders){
//            System.out.println(o.getAmount() + "\n" + o.getNumber());
//        }
        /*
        test delete
         */
        //jdbc.delete(1);

        /*
        test update
         */
//        jdbc.update(2, 1000, 12000.0, 1, new Date(3, 3, 2000), new Date(4, 3, 2000));
    }
}
