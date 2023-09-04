package employeeMange;

public class Employee {
	
	protected String name;
	protected int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public void greet() {
        System.out.println("Hello, I am " + name + ".");
    }

    public void performWork() {
        System.out.println("Performing general Works.");
    }
    
	
	


	
	

}
