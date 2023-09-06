import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

public class GetByAttribute {

    public static void main(String[] args) {
        
        SessionFactory factory = ConfigurationDemo.startSession();

        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Employee.class);

        criteria.setProjection(Projections.property("name"));
         List<Employee> employees = criteria.list();
         System.out.println("Name of all Employee's "+employees);
 

        session.close();
        factory.close();

       
    
    }

    
}
