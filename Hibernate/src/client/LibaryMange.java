package client;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import configurations.ConfigurationDemo;
import entity.Book;

public class LibaryMange {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for books");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
        }

        System.out.println("Exiting the program.");
    }

    private static void addBook() {
        
    	SessionFactory  factory = ConfigurationDemo.startSession();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	
    	System.out.print("Enter book title : ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author's name: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter Publication Year: ");
        int publicationYear = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        
        session.save(new Book(title,author,publicationYear,isbn));
        transaction.commit();
        
        factory.close();
        
        System.out.println("Book added successfully...!");
    	
    	
    	
    }

    private static void searchBooks() {
    	
    	
    	boolean exit = false;

        while (!exit) {
	        
        	System.out.println("Search Options:");
	        System.out.println("1. Search by title or keyword");
	        System.out.println("2. Search by author");
	        System.out.println("3. Search by publication year range");
	        System.out.println("4. Search by ISBN");
	        System.out.println("5.All book list");
	        System.out.println("6. Back to main menu");
	        System.out.print("Enter your search option: ");

        int searchOption = scanner.nextInt();
        scanner.nextLine(); 

        switch (searchOption) {
            case 1:
                System.out.print("Enter book title or keyword: ");
                String title = scanner.nextLine();
                searchByTitle(title);
                break;
            case 2:
                System.out.print("Enter author's name: ");
                String author = scanner.nextLine();
                searchByAuthor(author);
                break;
            case 3:
                System.out.print("Enter start year: ");
                int startYear = scanner.nextInt();
                System.out.print("Enter end year: ");
                int endYear = scanner.nextInt();
                scanner.nextLine(); 
                searchByPublicationYearRange(startYear, endYear);
                break;
            case 4:
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                searchByISBN(isbn);
                break;
                
            case 5:
            	  getAll();
            	  break;
            case 6:
            	exit=true;
                break;
            default:
                System.out.println("Invalid search option. Please try again.");
                break;
        }
        
        }
    }

    private static void updateBook() {
        
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter bookId for which you want to update");
        int index = scanner.nextInt();
        
        scanner.nextLine();
        
        Book book = session.get(Book.class,index);
        
        if(book!=null) {
        	
        	
        	System.out.print("Enter book title : ");
            String title = scanner.nextLine();
            
            System.out.print("Enter author's name: ");
            String author = scanner.nextLine();
            
            System.out.print("Enter Publication Year: ");
            int publicationYear = scanner.nextInt();
            
            scanner.nextLine();
            
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublicationYear(publicationYear);
            book.setIsbn(isbn);
            
          
            session.update(book);
            transaction.commit();

            
            System.out.println("Book information updated successfully...!");
        	
        }else {
        	
        	System.out.println("Book not found");
        }
     
        
        
        factory.close();
    }

    private static void deleteBook() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter book name for which you want to delete:");
        String title = scanner.nextLine();
        
        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.eq("title", title));
        
        List<Book> book= criteria.list();
        
        if(!book.isEmpty()) {
        	
        	session.delete(book.get(0));
        	System.out.println("Book deleted successfully...!");
       
        }else {
        	
        	System.out.println("Book not exists...!");
        }
        
        
        
        transaction.commit();
        factory.close();
        
    
    	
    	
       
    }

    private static void searchByTitle(String title) {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        
        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.like("title", "%" +title+"%"));
       
        
        List<Book> book= criteria.list();
        
        if(!book.isEmpty()) {
        	
        	
        	for (Book val : book) {
        		
        		System.out.println(val);
				
			}
        
        }else {
        	
        	System.out.println("Book not exists with given title...!");
        }
        
        
        
        transaction.commit();
        factory.close();
        
    }

    
    
    private static void searchByAuthor(String author) {
        
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        
        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.eq("author", author));
        
        List<Book> book= criteria.list();
        
        if(!book.isEmpty()) {
        	
        	
        	for (Book val : book) {
        		
        		System.out.println(val);
				
			}
        
        }else {
        	
        	System.out.println("Book not exists with given author...!");
        }
        
        
        
        transaction.commit();
        factory.close();
        
    }

    private static void searchByPublicationYearRange(int startYear, int endYear) {
       
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        
        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.between("publicationYear", startYear,endYear));
        
        List<Book> book= criteria.list();
        
        if(!book.isEmpty()) {
        	
        	
        	for (Book val : book) {
        		
        		System.out.println(val);
				
			}
        
        }else {
        	
        	System.out.println("Book not exists with given publicationYearRange...!");
        }
        
        
        
        transaction.commit();
        factory.close();
        
    }

    private static void searchByISBN(String isbn) {
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        
        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.eq("isbn", isbn));
        
        List<Book> book= criteria.list();
        
        if(!book.isEmpty()) {
        	
        	
        	for (Book val : book) {
        		
        		System.out.println(val);
				
			}
        
        }else {
        	
        	System.out.println("Book not exists with given isbn...!");
        }
        
        
        
        transaction.commit();
        factory.close();
        
    }
    
    
    private static void getAll() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        
        Criteria criteria = session.createCriteria(Book.class);
        
        List<Book> books = criteria.list();
        
        if(!books.isEmpty()) {
        	
        	for (Book book : books) {
        		System.out.println(book);
				
			}
        }else {
        	
        	System.out.println("No book present in library");
        }
        
        transaction.commit();
        factory.close();
		
	}
}
