package main.qsoft.jdbc.test;

import main.qsoft.POJO.ContactOrder;
import main.qsoft.jdbc.JdbcTemplate.ContactOrderJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testContactOrder {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        ContactOrderJdbc jdbc = (ContactOrderJdbc) factory.getBean("contact_orderJdbc");

        /*
        test create
         */
        //jdbc.create(12124, 1);
        /*
        test get
         */
        //System.out.println(jdbc.getContactOrder(12124, 1).getContact_id());

        /*test get all

         */
//        for(ContactOrder co:jdbc.listContactOrder()){
//            System.out.println(co.getOrder_id());
//        }
        /*
        test delete
         */
//        jdbc.delete(12124, 1);
        /*
        test update order_id
         */
        //jdbc.updateOrderId(123, 1000);
        /*
        test update contact_id
         */
       // jdbc.updateContactId(1001, 1000);
    }
}
