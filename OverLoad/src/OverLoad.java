
public class OverLoad {

	void show(String str) {
		
		System.out.println("In String");
	}
	
	void show(Object str) {
		
		System.out.println("In Object");
	}

	public static void main(String[] args) {
		
		OverLoad obj  = new OverLoad();
		
		obj.show((Object)null);

	}

}
