import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class ConfigurationDemo {

    static SessionFactory startSession(){

        Configuration cfg = new Configuration();
        cfg.configure("/resources/hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);

        SessionFactory factory = cfg.buildSessionFactory();

        return factory;

    }


    
}
