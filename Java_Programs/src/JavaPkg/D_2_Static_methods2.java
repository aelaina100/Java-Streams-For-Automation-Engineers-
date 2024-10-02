package JavaPkg;
import org.testng.annotations.Test;


public class D_2_Static_methods2 {
	
	@Test  // or The plain by-default Java compiler instead. Does NOT make a difference for accessing other method(s) from here.
	public void D_write()
	{
		System.out.println("Write method !");
		
		F_findOut(); // Accessing this method directly without creating an object. since this method is labeled as 'static'
		// Also, accessing method 'F_findOut' via object will still work (Buy why bother if 'static' was used).
		
		D_2_Static_methods2  d= new D_2_Static_methods2 ();  // Creating an object of this class to access the E_explore() method that's inside it.
		d.E_explore(); // output: "This is an explanatory method" & return value is contained. To use it check out the below line.
		
		System.out.println("*********************************************");
		
		String returned= d.E_explore(); 
		// outcome: Prints out "This is an exploratory method" PLUS 'returned' stores value of "This text is being returned"
		System.out.println("Returned value is: " + returned);	
	}
	
	
	
	public String E_explore()
	{
		System.out.println("This is an exploratory method");
		return "This text is being returned";
	}
	
	
	
	public static void F_findOut() 
	{
	// Adding 'static' keyword to method declaration, renders
	// such method accessible without creating an object of the class in which this method is present.
	// All other methods that are not assigned the 'Static' keyword, can ONLY be accessed via object creation. 
	
		System.out.println("Findout method");
	}	 
	
}
