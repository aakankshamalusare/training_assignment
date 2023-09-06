import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ListAll {

    public static void main(String[] args) {
        
        SessionFactory factory = ConfigurationDemo.startSession();

        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Employee.class);

        List<Employee> employees = criteria.list();

        for (Employee employee : employees) {

            System.out.println(employee);
            
        }

        session.close();
        factory.close();

        
    }
    
}
