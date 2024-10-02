package Constructors;

// simply predict the output

public class C_constructorDemo {
	
	
	public C_constructorDemo()                // A constructor
	{
		System.out.println(" I am in the constructor");
	}
	
	
	public C_constructorDemo(int a, int b)  // A parameterized constructor
	{
		System.out.println(" I am in the parameterized constructor");
	
	}
	
	public void getData()
	{
		System.out.println(" I am inside a method");
	}
	

	public static void main(String[] args) {
		
		C_constructorDemo cd= new C_constructorDemo();    
		C_constructorDemo cd2= new C_constructorDemo(4,5); 
	}
}
	// An ambiguous note copied: 
		// Once again, if both constructors above were not created at all, where the rest of the code remains exactly as it is
	      // then java compiler, upon executing the lines for both the 'cd' object & the 'cd2' object, will call both of the 
            //default (implicit) constructors that exist in the Java library/ backend and execute it.
