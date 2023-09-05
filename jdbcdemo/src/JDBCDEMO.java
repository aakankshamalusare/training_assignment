import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDEMO {
    public static void main(String[] args) throws Exception {
        
        Connection con = null;

        //1. Load Driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Establish the connection
        con = DriverManager.getConnection(
        "jdbc:mySQL://localhost:3306/jdbcdemo?" + "autoReconnect=true&useSSL=false", "root", "root");

        // Create a Statement 
        Statement statement = con.createStatement();

        // Create a PreparedStatement for parameterized queries
        PreparedStatement preparedStatement =con.prepareStatement(  "INSERT INTO student (id, name, age) VALUES (?, ?, ?)");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            
            System.out.println("CRUD Operations:");
            System.out.println("1. Create (Insert) using Statement");
            System.out.println("2. Create (Insert) using PreparedStatement");
            System.out.println("3. Read (Select)");
            System.out.println("4. Update using Statement");
            System.out.println("5. Update using PreparedStatement");
            System.out.println("6. Delete using Statement");
            System.out.println("7. Delete using PreparedStatement");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
           
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:{

                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                        
                    scanner.nextLine(); 
                      
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                        
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();

                    String query = "INSERT INTO student (id,name,age) VALUES(" + id+",'"+name+"',"+age+")";
                    statement.executeUpdate(query);
                    
                    System.out.println("Record inserted successfully using Statement.");

                }
                    break;

                case 2:{

                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                        
                    scanner.nextLine(); 

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                        
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();

                    preparedStatement = con.prepareStatement(  "INSERT INTO student (id, name, age) VALUES (?, ?, ?)");

                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setInt(3, age);

                    preparedStatement.executeUpdate();

                    System.out.println("Record inserted successfully using PreparedStatement.");

                }
                    break;

                case 3:{

                    ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

                    while(resultSet.next()){

                        System.out.println("ID: "+resultSet.getInt("id")+", Name: "+resultSet.getString("name")+
                        ", Age: "+resultSet.getInt(3));
                    }


                }
                    break;

                case 4:{

                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Enter new student age: ");
                    int newStudentAge = scanner.nextInt();

                    String query = "UPDATE student SET age=" + newStudentAge +" WHERE id= "+updateId;

                    statement.executeUpdate(query);

                    System.out.println("Record updated successfully using Statement.");
                
                }
                    break;

                case 5:{

                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    
                    scanner.nextLine(); 
                    
                    System.out.print("Enter new student age: ");
                    int newStudentAge = scanner.nextInt();

                    
                    preparedStatement = con.prepareStatement("UPDATE student SET age = ? WHERE id = ?");

                                       
                    preparedStatement.setInt(1,newStudentAge );
                    preparedStatement.setInt(2, updateId);

                    preparedStatement.executeUpdate();

                    System.out.println("Record updated successfully using PreparedStatement.");
                }
                   break;

                case 6:{

                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    
                    String query = "DELETE FROM student WHERE id = " + deleteId;
                    statement.executeUpdate(query);
                    
                    System.out.println("Record deleted successfully using Statement.");
                   
                }
                     break;
                
                case 7:{

                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    
            
                    preparedStatement = con.prepareStatement( "DELETE FROM student WHERE id= ?");
                    preparedStatement.setInt(1, deleteId);

                     preparedStatement.executeUpdate();


                    
                    System.out.println("Record deleted successfully using preparedStatement.");


                }
                    break;
                

                case 8:{

                    scanner.close();
                    statement.close();
                    preparedStatement.close();
                    con.close();
                    System.out.println("Exiting...");
                    System.exit(0);

                }
                    break;
            
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        
    }
}
