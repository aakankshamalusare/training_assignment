

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class CRUDOperation {

    static void createOperation(){

        SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee(1,"AK",2000000, "Dev");
        session.save(employee);
        transaction.commit();

        session.close();

    }

    static void readOperation(){

        SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        /*
         * 
         * load() :
         *  -It throws ObjectNotFoundException if the object doesn’t exist in the database or session cache
         *  -load() is used to fetch an object if it is sure that object exists.
         * 
         */

         Employee employee = session.load(Employee.class, 1);
         System.out.println(employee);


        /*
         * get()
         * -It returns null if the object doesn’t exist in the database or session cache.
         * 	It throws ObjectNotFoundException if the object doesn’t exist in the database 
         * -get() is used to fetch an object when it is not sure whether the object exists or not.
         */


         employee = session.get(Employee.class, 2);
         System.out.println(employee);

         session.close();

        
    }


    static void updateOperation(){

        SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = session.get(Employee.class, 1);
        employee.setName("AK");

        session.update(employee);;
     
        Employee employee2 = new Employee(2, "BK", 40000, "Architect");
        session.saveOrUpdate(employee2);
        transaction.commit();

        session.close();

    }

    static void deleteOperation(){

        SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = session.get(Employee.class, 2);
        session.delete(employee);

        transaction.commit();



    }

    public static void main(String[] args) {

        

        createOperation();
        readOperation();
        updateOperation();
        deleteOperation();

        
        
    }
    
}
