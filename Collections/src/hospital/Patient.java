package hospital;

public class Patient {

	private String name;
	private int age;
    private String gender;
    
    public Patient() {
    	
    }
    
    public Patient(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
    
    public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	
	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
    
    
}
