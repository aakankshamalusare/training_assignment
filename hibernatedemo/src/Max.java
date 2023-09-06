import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

public class Max {

    public static void main(String[] args) {
        
        SessionFactory factory = ConfigurationDemo.startSession();

        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Employee.class);

        criteria.setProjection(Projections.max("salary"));
         List<Employee> employees = criteria.list();
         System.out.println("Max Salary: "+employees);
 

        session.close();
        factory.close();

    }
    
    
}
