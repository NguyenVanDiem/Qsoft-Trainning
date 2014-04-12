package main.qsoft.jdbc.test;

import main.qsoft.POJO.CustomerContact;
import main.qsoft.jdbc.JdbcTemplate.CustomerContactJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testCustomerContact {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        CustomerContactJdbc jdbc = (CustomerContactJdbc) factory.getBean("customer_contactJdbc");

        /*test create

         */
        //jdbc.create(1,3);
        /*test get

         */
//        System.out.println(jdbc.getCustomerContact(1, 2).getCusid());
        /*
        test get all
         */
//        for(CustomerContact cc:jdbc.listCustomerContact()){
//            System.out.println(cc.getCusid());
//        }

        /*
        test delete
         */
//        jdbc.delete(1,2);

        /*
        test update coid
         */
//        jdbc.updateContactId(1, 10);
        /*
        test update cuid
        */
//        jdbc.updateCustomerId(12, 10);
    }
}
