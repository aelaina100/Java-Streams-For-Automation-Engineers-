package Constructors;

public class B_constructorDemo {
	
	
	public B_constructorDemo()                // A constructor
	{
		System.out.println(" I am in the constructor");
	}
	
	
	public B_constructorDemo(int a, int b)  // A parameterized constructor
	{
		System.out.println(" I am in the parameterized constructor");
	}
	
	public void getData()
	{
		System.out.println(" I am inside a method");
	}
	

	public static void main(String[] args) {
		
		B_constructorDemo cd= new B_constructorDemo();     // simply predict the output
		
	}

}
