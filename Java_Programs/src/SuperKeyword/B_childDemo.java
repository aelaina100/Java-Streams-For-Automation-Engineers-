package SuperKeyword;
// And also that, you have the following class
// predict the output

public class B_childDemo extends A_parentDemo {
	
	String name= "QA Click Academy";
	
	public B_childDemo()
	{
		super();  // If I want to use my parent's class constructor into this class 'B_childDemo', then simply call the 'super' keyword 
		          // by typing it out in here.This works as long as we are extending
		          // PLUS ALWAYS remember that whenever you use the super() method in child constructor, then it should always be 
		          // written in the first line inside the child constructor
		System.out.println("Child class constructor");
	}
	
	public void getStringData()
	{
		System.out.println(name);
		System.out.println(super.name);
	}
	
	public void getData()
	{
		super.getData();
		System.out.println(" I am in the child class");
		
	}
	

	public static void main(String[] args) {
		
		B_childDemo cd= new B_childDemo();
		cd.getStringData();
		cd.getData();
		
	
		
		
	}

}
