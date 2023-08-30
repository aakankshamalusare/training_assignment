package school;

public class Teacher {

	private int id;
	private String name;
	
	public Teacher() {
		
	}
	
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}


}
