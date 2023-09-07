package configurations;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Book;
import entity.Employee;




public class ConfigurationDemo {

    public static SessionFactory startSession(){

        Configuration cfg = new Configuration();
        cfg.configure("/resources/hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Book.class);

        SessionFactory factory = cfg.buildSessionFactory();

        return factory;

    }


    
}
