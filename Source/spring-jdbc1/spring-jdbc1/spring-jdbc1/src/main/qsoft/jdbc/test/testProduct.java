package main.qsoft.jdbc.test;

import main.qsoft.POJO.Product;
import main.qsoft.jdbc.JdbcTemplate.ProductJdbc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nguyen D. Ngo on 4/12/14.
 */
public class testProduct {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("/main/qsoft/jdbc/Bean/Beans.xml");
        ProductJdbc jdbc = (ProductJdbc) factory.getBean("productJdbc");
        /*
        test create
         */
//        jdbc.create(115, 2003, "model B", "Viettel", 1240.0);
        /*
        test get
         */
//        System.out.println(jdbc.getProduct(1).getManufacturer());
        /*test get all

         */
        for(Product p: jdbc.listProduct()){
            System.out.println(p.getManufacturer());
        }
        /*
        test delete
         */
        jdbc.delete(1);
        /*
        test update
         */
        jdbc.update(2, 110, 2014, "New Model A", "Viettel IDC", 196.2);

    }
}
