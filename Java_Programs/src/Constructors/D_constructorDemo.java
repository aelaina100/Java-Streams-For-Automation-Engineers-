package Constructors;

// Look at the below code, predicting the output

public class D_constructorDemo {
	
	public D_constructorDemo()
	{
		System.out.println("I am in the constructor");
		System.out.println("Lecture # 1");
		System.out.println("");
	}
	
	public D_constructorDemo(int a, int b)
	{
		System.out.println("Parameterized");
		int c= a + b;
		System.out.println(c);
		System.out.println("");
	}
	
	public D_constructorDemo(String text)
	{
		
		System.out.println(text);
		System.out.println("");
	}


	public void getData() {
		System.out.println("  In a method");
	}
	
	public static void main(String[] args) {
		
		D_constructorDemo cd= new D_constructorDemo();
		D_constructorDemo cdo= new D_constructorDemo("Here is some text for you");
		D_constructorDemo cdob= new D_constructorDemo(99,2);
	}
	}


