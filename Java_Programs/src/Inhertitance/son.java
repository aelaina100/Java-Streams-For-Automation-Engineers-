package Inhertitance;

public class son extends Grandfather  {

	public static void main(String[] args) {
		
		son s= new son();
		s.city();
		s.country();
		System.out.println(s.z);
		
	}
	
	public void activities()
	{
		System.out.println(" here is activities() method inside SON class");
	}
}
