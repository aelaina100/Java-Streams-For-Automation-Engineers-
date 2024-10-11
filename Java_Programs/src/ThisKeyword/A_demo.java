package ThisKeyword;

import org.testng.annotations.Test;

public class A_demo {
	
	int a= 2;   // object that has its scope in the class level (Global variable)
	
	@Test
	public void getData()
	{                 // In contrary to:
		int a= 3;    // object that has its scope in the method level (Local variable) [int a=3 is only limited to the getData() method]
		System.out.println(a);
		
		// Below, Print out the global variable:
		System.out.println(this.a);                    // 'this global'
		// Below, print out the sum value of global variable and 6
		int sum= this.a +6;
		System.out.println("Sum is: " +sum);
	}

}
