import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class Between {

    public static void main(String[] args) {
        
        SessionFactory factory = ConfigurationDemo.startSession();

        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Employee.class);

         criteria.add(Restrictions.between("salary", 20000.00,25000.00));
         criteria.setFirstResult(7);
         criteria.setMaxResults(10);

        List<Employee> employees = criteria.list();
        
        for (Employee employee : employees) {

            System.out.println(employee);
            
        }

        session.close();
        factory.close();

       
    
    }

}
    


    



    

