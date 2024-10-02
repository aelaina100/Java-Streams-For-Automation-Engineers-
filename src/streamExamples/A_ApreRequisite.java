package streamExamples;
import java.util.ArrayList;
import org.testng.annotations.Test;

/*      ******** Note: BEFORE delving into this .java class file, review 'NOTES' file under this 'streamStuff project'.*******
 DO not proceed reviewing this class before doing so with the 'NOTES' file.
 +This file presumes that reader is already well-versed with the examples under 'JavaPkg' situated under the project of 'Java_Programs'
 This specific .java class file utilizes TestNg compiler. This is to have as many testcases inside it instead of seperate creation
 of each testcase utilizing the plain by-default Java compiler. These are merly prerequisite testcases intended to exist in one.java 
 class file for the sake of simplicity.
 */
public class A_ApreRequisite {
	@Test
	public void valueStored()
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
		
		// 1- print out the element in the 0 index of arr 
		String x= arr[0];
		System.out.println(x);
		
		//2- print out the element in the 0 index of arrlist
		String y= arrlist.get(0);
		System.out.println(y);
		System.out.println("========================================================================");
		
		//3- Check whether arr contains 'Discipline'
		for(int i=0; i< arr.length; i++)
		{
			String z= arr[i];
			if(z.equals("Discipline")==true) //If(z.equals("Discipline")  -this statement alone will always return false (default)
			{                                                                 
				System.out.println("YES- Array contains 'Discipline' at the index of: "+ i); }}
		
// Another way of optimizing the above lines to convert this array into an arrayList so that .contains can be applied against it:--->
 //Arrays.asList(arr);  & on the right of the '=' operator:     List<String> words
		// This is real-time practice and the correct way (Instructor's way as well).
		
		//4- Check whether arrlist contains "Weak"
	     Boolean b= arrlist.contains("Weak"); // there is also .containsAll() method. Check it out !S
	     if(b==true)
	     {
	    	 System.out.println( "ArrayList contains 'Weak' at the index of: " + arrlist.indexOf("Weak"));}
	     
	     //5- What is the index of 'Hardwork'
	     for(int j=0; j<arr.length; j++)
	     {
	    	 String c= arr[j];
	    	 if(c.equals("Hardwork")==true)
	    	 {
	    		 System.out.println("Index of 'Hardwork' is: " + j);}}
	    // Now, another way of optimizing the above lines of code is to convert this array into an arraylist and
	      // then apply .indextof() method against it (Real-time practice & how it should be).
	     //6- What is the undex of 'Draco" 
	     int index= arrlist.indexOf("Draco");
	     System.out.println("Index of 'Draco' is: " + index);
	 	 System.out.println("===========================================================================================");}}

// There exists many other invaluable methods within the ArrayList class & check out that of array.
    //Example:  arrlist.isEmpty(;) //returns boolean
	 // Now decide, if whether you'd really want a second Testng class (Elaboration on these concepts)
 
		

