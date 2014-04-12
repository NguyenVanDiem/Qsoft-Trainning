package main.qsoft.jdbc.test;

import main.qsoft.POJO.Contact;
import main.qsoft.jdbc.JdbcTemplate.ContactJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testContact {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        ContactJdbc jdbc = (ContactJdbc) factory.getBean("contactJdbc");

        /*
        test add
         */
//        jdbc.create("contact Name 2", "conatact phone: +124 2", "ngo@abc.xyz.vn", 1, "CEO");

        /*
        test get

         */
//        Contact contact = jdbc.getContact(2);
//        System.out.println(contact.getName());

        /*
        test get all
         */
//        ArrayList<Contact> contacts = jdbc.listContact();
//        for(Contact c:contacts){
//            System.out.println(c.getName());
//        }
        /*
        test delete
         */
//        jdbc.delete(1);
        /*
        test update
         */
        jdbc.update(2, "change contact name", "change phone: +12312", "change email", 0, "CxO change");
    }
}
