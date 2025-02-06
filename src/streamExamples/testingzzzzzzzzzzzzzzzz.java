package streamExamples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.Test;

public class testingzzzzzzzzzzzzzzzz {
// So far: .contains() apply to strings and arrayLists (meaning of any type) where:
 //[for strings:  .contains(String.valueOf('s'))     &  For arrayLists: .contains(arraylist)  
	
	//  .containsAll() applies to arrayLists (meaning of any type)
	
	// As for arrays (fixed-length data  structure, one has to loop through the array)
	
	@Test
	public void basics1(){
		
		System.out.println("****************           Strings         *******************");
		
		String name= "Ahmad";
		//1- What's the index of the character 'a'
		//2- What character is at the index of 2.
		//3- Does the string contain the character 'J' ? 
		//4- Display the characters of the string
		
		
		//1-
		System.out.println(name.indexOf('a'));
		//2-
		System.out.println(name.charAt(2));
		//3-
		char wantedChar= 'h';
		
		Assert.assertTrue("The wanted character of:  " + wantedChar + " is NOT in the string", name.contains(String.valueOf(wantedChar)) );
		
		// OR: Another way of doing it is ====> the fact that .indexOf() method returns -1 if the character isn't found:
		name.indexOf(wantedChar);
		Assert.assertNotEquals( " The character of: " + wantedChar + " can NOT be found in the string of: "+ name, name.indexOf(wantedChar) ,-1);
		
		
		/* Below is the unoptimized long way of doing it (#3)
		char wantedChar= 'd';
		for (int i=0; i<name.length(); i++)
		{
			if (name.charAt(i) == wantedChar){
				System.out.println("The string DOES contain the character of:  " + wantedChar + " And it happens to be at the index of: " + i);
				break;
			}
			
			else if (i== name.length()-1)  // else..if (on the last index) =only begins to execute when the wanted character is not even in the string as
				                            // the 'break' statement has not been executed.
			{
				Assert.assertTrue("The wanted character of:  " + wantedChar + " is NOT in the string", false);
			} } */
		
		
		//4- 
		for (int i=0; i< name.length(); i++)
		{
			System.out.println(name.charAt(i));
		}
//********************************************************************************************************************************************************		
		System.out.println("**************** Arrays of String type *******************");
		String names[]= { "Ahmad", "San", "Yen", "Sodoko"};
		// 5- What is the element at index 3 ?
		// 6- At what index is the element of "Sodoko" is at ?
		// 7- Does the array contain the element of "San" ?
		// 8- Display the elements of this array.
		
	   //5- 
	   System.out.println(names[3]);  // in an arrayList its:    names.get(3)
	  //6- 
	   String element= "Ahmad";
	   for (int i=0; i<names.length; i++)
	   {
		   if (names[i].equalsIgnoreCase(element))
		   {
			   System.out.println("The element of: "+ element + " is at the index of: " + i);
			   break;
		   }
		   
		   if(i==names.length-1)  // else..if (on the last index) =only begins to execute when the wanted character is not even in the string as
                                 // the 'break' statement has not been executed.
		   {
			   Assert.assertTrue("The element of:  " + element+ " is NOT in the array to start with", false);
		   }
	   }
	   //7- convert this array into an arrayList, so that the method of .contains() could be applied.
	   String wantedElement= "San";
	   List<String> names_arrayList =Arrays.asList(names);
	   Assert.assertTrue("The element of: " + wantedElement + " is NOT in the array to start with", names_arrayList.contains(wantedElement)); 
	   
	   //8: do NOT do this====> System.out.println(names)     // output: [Ljava.lang.String;@2bfc268b
	   System.out.println(names_arrayList);
	   // or the non-optimized way/ without first converting the array into an arrayList:
	   for(int j=0; j<names.length; j++)
	   {
		   System.out.println(names[j]);
	   }
	   
//*****************************************************************************************************************************************************
	    System.out.println("**************** Arrays of integer type *******************"); 
		int intNumbers[]= {101, 202, 303, 404}; // In automation, simply convert this array of integers to an array of Strings. [Add as #13]
		// 9- What is the element at index 3 ?
		// 10- At what index is the element of 303 is at ?
		// 11- Does the array contain the element of 202 ?
		// 12- Display the elements of this array
		
		// CRUCIAL NOTE: In an automation environment, simply convert this array of integer type, to an array of String type. This way, converting this 
		//array of String type into an arrayList will enable us to use the .contains method with no errors.
		
		//9-
		System.out.println(intNumbers[3]);
		
		//10-
		int value= 303;
		for(int z=0; z<intNumbers.length; z++)
		{
			if(intNumbers[z]==value)
			{
				System.out.println("The element of: "+ value + " is at the index of: " + z);
				break;
			}
			
			else if(z==intNumbers.length-1)
			{
				Assert.assertFalse("The element of: " + value + " is NOT in the array to start with", true);
			}
		}
		
		//11- 
		// Covert this array into an arrayList, do that the .contains() method could be applied
		int someNumber= 404;
		  
		//List<int[]> intNumbers_arrayList= Arrays.asList(intNumbers); // Won't help us, as   intNumbers_arrayList.contains(someNumber)   will not
		// render the argument of 'someNumber' recognized. This has to do with the syntax of  "List<int[]> intNumbers_arrayList= Arrays.asList(intNumbers);"
		// where if the syntax was:  ArrayList<Integer> intNumbers_arrayList= new ArrayList<Integer>();, then the .contains() would work perfectly fine...
		
		//So, instead use a for-loop [In order to continue using the .contains() method just fine]:===>
		ArrayList<Integer> intNumbers_arrayList= new ArrayList<Integer>();
		for(int v=0; v<intNumbers.length; v++)
		{
			intNumbers_arrayList.add(intNumbers[v]);
		} 
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		System.out.println(intNumbers_arrayList);
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Assert.assertTrue(" !@V! The array does NOT contain the number of: " + someNumber+ " in the 1st place !!" , intNumbers_arrayList.contains(someNumber));  ///you ARE here
		
		
		//Or: Without converting this array (Fixed-length data structure) into an arrayList (The long unoptimized way):==>
		int someValue= 202;
		for(int x=0; x<intNumbers.length; x++)
		{
			if(intNumbers[x]==someValue)
			{
				System.out.println("The element of: " + someValue+  " is IN the array at the index of: " + x);
				break;
			}
			
			else if(x==intNumbers.length-1)
			{
				Assert.assertTrue("The element of: " + someValue + " is NOT in the array to start with", false);
			}
		}
		
		//12- 
		//do NOT do this====> System.out.println(intNumbers);     // output: [I@2bfc268b
		for(int b=0; b<intNumbers.length; b++) 
		{
			System.out.println(intNumbers[b]);
		}
		
//*****************************************************************************************************************************************************
	    System.out.println("**************** ArrayList of String type *******************"); 		
		// Below: The long way of creating an arrayList & adding element(s) to it.
		ArrayList<String> arrayList= new ArrayList<String>();  // Order is guaranteed. Duplicates are allowed (The only collection class where this is the case)
		arrayList.add("China");
		arrayList.add("Korea");
		arrayList.add("Japan");
		
		//Below: the faster/ optimized way of creating an arrayList & adding elements to it.
		/*
		List<String> arrayList= Arrays.asList("Chine", "Korea", "Japan");
		*/
		
		//13- At which index, is the element of "Korea" at ?
		//14- What element is at the index of 2
	    //15- Does the arrayList contain the element of "China" ?
	    //16- Display the elements inside this arrayList !
		
		
		//13
		String country= "korea";
		for(int c=0; c<arrayList.size(); c++)
		{
			if( arrayList.get(c).equalsIgnoreCase(country) )
			{
				System.out.println(" The element of: " + country + " is at the index of: " +c);
				break;
			}
			
			else if(c==arrayList.size()-1)
			{
				//System.out.println(" The element of: " + country + " is NOT in the arrayList to start with"); //Better to throwing exception. So, use the line below:
				Assert.assertTrue(" The element of: " + country + " is NOT in the arrayList to start with", false);
			}
		}
		
		//14-
		System.out.println(arrayList.get(2));
		//15-
		String checkCountry= "China";
		Assert.assertTrue("The element of: " + checkCountry + " is NOT present in the arrayList", arrayList.contains(checkCountry));
		
		//16-
		System.out.println(arrayList);   //[China, Korea, Japan]
		// Or: if one wants to display them one by one then looping through the elements in the arrayList is the answer
		for (int f=0; f<arrayList.size(); f++)
		{
			System.out.println(arrayList.get(f));
		}
//********************************************************************************************************************************************************
		System.out.println("**************** ArrayList of integer type *******************"); 		
		// Below: The long way of creating an arrayList & adding element(s) to it.
		ArrayList<Integer> arrayList2= new ArrayList<Integer>();  // Order is guaranteed. Duplicates are allowed (The only collection class where this is the case)
		arrayList2.add(90);
		arrayList2.add(80);
		arrayList2.add(70);
		
		//Below: the faster/ optimized way of creating an arrayList & adding elements to it.
		/*
		List<String> arrayList= Arrays.asList(90,80,70);
		*/
		
		//17- At which index, is the element of "70" at ?
		//18- What element is at the index of 1
	    //19- Does the arrayList contain the element of 80 ?
	    //20- Display the elements inside this arrayList !
		
		
		//17-
		int numElement= 70;
		for(int n=0; n<arrayList2.size(); n++)
		{
			if(arrayList2.get(n)==numElement)
			{
				System.out.println("The number of: " + numElement + " is @ the index of: " +n);
				break;
			}
			
			else if(n==arrayList2.size()-1)
			{
				Assert.assertTrue("The number of: " + numElement+ " is NOT in the arrayList to start with" , false);
			}
		}
		
		//18-
		System.out.println(arrayList2.get(2));
		//19-
		int checkNum= 80;
		Assert.assertTrue("The element of: " + checkNum+ " is NOT present in the arrayList to start with", arrayList2.contains(checkNum));
		
//***********************************************************************************************************************************************		
		int intValues[]= {101, 202, 303, 404}; // In automation, simply convert this array of integers to an array of Strings in order to avoid the nuances of
		                                       // employing the .contains() method.
		
		
		
		}
		
		
		
		
		
		
		// Do for an arrayList of type int
	}	
	
