package streamExamples;
import java.util.ArrayList;
import org.junit.Assert;


/*      ******** Note: BEFORE delving into this .java class file, review 'NOTES' file under this 'streamStuff project'.*******
 DO not proceed reviewing this class before doing so with the 'NOTES' file.
 +This file presumes that reader is already well-versed with the examples under 'JavaPkg' situated under the project of 'Java_Programs'
 This specific .java class file utilizes TestNg compiler. This is to have as many testcases inside it instead of seperate creation
 of each testcase utilizing the plain by-default Java compiler. These are merly prerequisite testcases intended to exist in one.java 
 class file for the sake of simplicity.
 */

// To do: Syntax to be optimized in step 5 and 6 (and in other steps as well ?)
// Using soft assertions is a good idea in this specific example.
public class A_ApreRequisite {
	public static void main(String [] args)
	{
		// *** You have the following:
		String arr[]= new String[3];
		arr[0]= "Ahmad";
		arr[1]= "Discipline";
		arr[2]= "Hardwork"; 
	 // or:   //  String arr[]= {"Ahmad", "Discipline", "Hardwork"};
	 
		//***  You also have the following:
		ArrayList<String> arrlist= new ArrayList<String>();
		arrlist.add("Draco");
		arrlist.add("Lazy");
		arrlist.add("Weak");
	 // or:   // List<String> arrlist=  Arrays.asList("Draco", "Lazy", "Weak");
		
		// 1- Print out all the elements in arr
		
		for (int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}  // The only way to display elements of the array (Fixed-length data structure) is looping through them, displaying them one by one.
		//System.out.println(arr);  // useless output  [Ljava.lang.String;@2af004b    
		
		
		// 2- print out all the elements in arrlist
		System.out.println(arrlist);  // will display them with brackets.
		System.out.println("********************************");
		
		
		// 3- print out the element in the 0 index of arr 
		String x= arr[0];
		System.out.println(x);
		
		// 4- print out the element in the 0 index of arrlist
		String y= arrlist.get(0);
		System.out.println(y);
		System.out.println("========================================================================");
		
		// 5- Check whether arr contains 'Discipline'
		for(int i=0; i< arr.length; i++)
		{
			String z= arr[i];
			if(z.equals("Discipline")==true) //If(z.equals("Discipline")  -this statement alone will always return false (default)
			{                                                                 
				System.out.println("YES- Array contains 'Discipline' at the index of: "+ i); }}
		
// Another way of optimizing the above lines to convert this array into an arrayList so that .contains can be applied against it:--->
 //Arrays.asList(arr);  & on the right of the '=' operator:     List<String> words
		// This is real-time practice and the correct way (Instructor's way as well).
		
		// 6- Check whether arrlist contains "Weak"
	     Boolean b= arrlist.contains("Weak"); // there is also .containsAll() method. Check it out !S
	     if(b==true)
	     {
	    	 System.out.println( "ArrayList contains 'Weak' at the index of: " + arrlist.indexOf("Weak"));}
	     
	     // 7- What is the index of 'Hardwork'
	     for(int j=0; j<arr.length; j++)
	     {
	    	 String c= arr[j];
	    	 if(c.equals("Hardwork")==true)
	    	 {
	    		 System.out.println("Index of 'Hardwork' is: " + j);}}
	    // Now, another way of optimizing the above lines of code is to convert this array into an arraylist and
	      // then apply .indextof() method against it (Real-time practice & how it should be).
	     
	     //8- What is the index of 'Draco" 
	     int index= arrlist.indexOf("Draco");
	     System.out.println("Index of 'Draco' is: " + index);
	     // IMPORTANT:  .indexof() //a method that ONLY exists in "String" & "ArrayList" classes. [returns -1 if the element or character, that we want to find the index of, doesn't exist ]
	 	 System.out.println("===========================================================================================");

        //9- Is the array 'arr' empty ?
	 	 //System.out.println("Array length/ Number of elements inside of it is: "+arr.length);
          
	 	 // First way: (Assuming one wants to throw an error message when array is empty)
	 	 Assert.assertNotEquals("Created array is EMPTY",0, arr.length);
	 	 System.out.println("Array is NOT empty as it has: " + arr.length+ " elements inside it.");
	 	 
	 	 // Or:Second way: (Assuming one wants to throw an error message when array is populated with data)
	 	 //Assert.assertEquals("Array is POPULATED with data. it has: "+ arr.length + " elemnts inside it.", 0, arr.length);
	 	 //System.out.println("Array is Empty");
	 	 
	 	 /*  // 3rd way utilizing plain Java coding
          if(!(arr.length==0))
          {
        	  // Assert.assertTrue(true);  // a redundant line.
        	  System.out.println(" The created array (Fixed-length dasta structure) is populated/ NOT empty");
          }
          
          else
          {
        	  System.out.println(" The created array (Fixed-length dasta structure) is EMPTY. Hence throwing a compiler error/exception");
        	  Assert.assertTrue(false);
          }
          */
	 	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	 	//10- Is the arrayList 'arrlist' empty ?  // Note this cvan be done with .size() as well
	 	
	 	  //Assuming that one would want to throw an error message/exception if it is empty.
	 	 Assert.assertFalse("ArrayList is EMPTY. Hence throwing an exception.", arrlist.isEmpty());
	 	 System.out.println("Array is populated as it has: " + arrlist.size()+ " elements inside it.");
	 	 
	 	 //Assuming that one would want to throw an error message/exception if it is empty.
	 	 Assert.assertTrue("--ArrayList is NOT EMPTY as it has: " + arrlist.size()+ " elements inside. Hence throwing an exception.", arrlist.isEmpty());
	 	 System.out.println("Arraylist is empty.");

	}}

// There exists many other invaluable methods within the ArrayList class & check out that of array.
    //Example:  arrlist.isEmpty();  //returns boolean
	 // Now decide, if whether you'd really want a second Testng class (Elaboration on these concepts)
 
 //Important (October 8th, 2014) now switch to "Integer" type of data for both the array & the arrayList in this specific example.
 
		

