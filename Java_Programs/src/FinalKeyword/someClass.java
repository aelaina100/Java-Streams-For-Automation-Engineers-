package FinalKeyword;


//'Final' keyboard can be used on: Variable level, Method level, & Class level

	//1- On a variable level: To ensure variable can NEVER be changed.
 	// [If you want to declare a variable as a constant value. where it's ALWAYS not changeable, editable, mutable].

//2- On a Method level: To ensure the method can not be overridden.
	  // [Method marked as 'Final' is unique and there can NEVER be another one written with the same name for the intent of overriding it]

//3- On a class level: TO ensure that this class[ It's method(s)] can never be inherited ( Extended) by a child class.

public class someClass {
	
	public void someClassTest()
	{
			System.out.println(" Inside the method of someClassTest() beloning to the someClassTest() Method");
		
	}

}
