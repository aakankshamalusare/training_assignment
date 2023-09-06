import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class NotEqual {

    public static void main(String[] args) {
        
        SessionFactory factory = ConfigurationDemo.startSession();

        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Employee.class);

        criteria.add(Restrictions.ne("position","dev"));

        List<Employee> employees = criteria.list();
        
        for (Employee employee : employees) {

            System.out.println(employee);
            
        }

        session.close();
        factory.close();

       
    
    }

}
    

