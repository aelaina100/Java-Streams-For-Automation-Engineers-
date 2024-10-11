package JavaPkg;


public class B_methods { 
	public void validateheader()
	{
		System.out.println(" I navigated to home");
	}
	

}
// With the assumption that method(s) here are going to be accessed (used)repeatedly by many classes that either utilize
 // the plain by-default java compiler or TestNg compiler.
// Another way of stating:  (If you feel that this method/ lines of code are going to be repeatedly used).


// That's the whole purpose of such a class where no execution takes place but rather an access does.

// Also in Java- you can't have a method INSIDE a method. Absolutely NOT.
  // You can NOT create a method inside the main statement (inside the Plain by-default Java compiler) or inside a testNg compiler method
  // You can NOT create a testNg method(Testcase) inside a testng method(Testcase).