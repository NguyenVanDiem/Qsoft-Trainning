package main.qsoft.jdbc.test;

import main.qsoft.POJO.OrderProduct;
import main.qsoft.jdbc.JdbcTemplate.OrderProductJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testOrderProduct {
    public static void main(String[] args) {
        BeanFactory factory =  new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        OrderProductJdbc jdbc = (OrderProductJdbc) factory.getBean("order_productJdbc");

        /*
        test create
         */
//        jdbc.create(12, 123);

        /*
        test get
         */
//        System.out.println(jdbc.get(12, 456).getOrderId());

        /*
        test get all
         */
//        for(OrderProduct o:jdbc.list()){
//            System.out.println(o.getOrderId());
//        }

        /*
        test delete
         */
//        jdbc.delete(12, 123);
        /*
        test update order id
         */
        //jdbc.updateOrderId(1323, 456);
        /*
        test update product id
         */
//        jdbc.updateProductId(1323, 1111);
    }

}
