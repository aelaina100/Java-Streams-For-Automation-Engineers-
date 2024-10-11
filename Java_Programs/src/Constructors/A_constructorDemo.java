package Constructors;

public class A_constructorDemo {

	
	public A_constructorDemo()
	{
		int x= 3;
		String value = "market";
		System.out.println("Executing what's inside the constructor class");	
	}
	
	
	public static void main(String[] args) {
		
		A_constructorDemo cd= new A_constructorDemo(); 
       // As soon as this line is executed, the contents of the constructor it points to (if there is) is executed before proceeding to next line.
      // AND: cd object will ALSO ALWAYS have an access to all other methods defined in this .java class fine
		System.out.println("=================");
		cd.getData();
	}                                             
	
	

	public void getData()
	{
		System.out.println("Some method");
	}
}
// So instead of initializing, and/or declaring a variable, and executing other line(s) of code inside the main()method,
  // I choose to do so whenever I want by creating an object of the class. This is a very useful technique/ comes in handy.

// An ambiguous note copied: 
	// Now, for the same exact code if the constructor was not created, then upon executing the above line for the cd object,
      //compiler will call the default (implicit) constructor that is ALWAYS (by definition) exists in the Java library/ backend
        // and will execute it.