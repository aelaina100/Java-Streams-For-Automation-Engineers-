package JavaPkg;
public class Q_enhanced_forLoops {
	//Simply have a look at the below lines of code

	public static void main(String [] args)
	{
		String array[]= {"A","B","C","D","E"};
	   // Now- To display all the elements stored in this declared array:
		for(int i=0; i< array.length ;i++)
		{
			System.out.println(array[i]);	
		}
		    System.out.println("===================================================");
		
		//Now- Instead of the regular for loop expressed above, one can write an enhanced one:
		for( String val :array) // Iterating through each element of 'array', storing it each time in 'val'
	     // Also meaning: The increment (i++)/ decrement (i--) part & that of the condition is automatically included.	
		{
			System.out.println(val); // no use for array[i] as you can observe in the regular for-loop above.
		}
		
	}
}
