package streamExamples;
import java.util.ArrayList;
// Create an ArrayList collection class and store elements into it,
// Thereafter, display the count of elements that start with the letter "A". Utilizing plain java programming (No streams).
import org.testng.annotations.Test;

public class A_Stream {
	@Test
	public void A_StreamTest() {
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Ahmad");
		names.add("yansin");
		names.add("Lyria");
		names.add("adam");
		names.add("Ansyn");

       int count= 0;
       for(int i=0; i < names.size(); i++)  // Again-  while .length is for Arrays (fixed-length data structure) & Strings.
		{
		String x= names.get(i);
		if (x.startsWith("A"))
		{
		 count ++;	      // same as: count = count +1;
		}
		}
	   System.out.println(" Number of names that start with 'A' is: " + count);	
	   
	   /*
	  CRUCIAL:  Now- Instead of the regular for loop expressed above, try replacing it with an enhanced one as shown below:
	    for(String val: names)
       {
    	   if (val.startsWith("A"))
    	   {
    		  count++; }} */
	   
	} }
		
// Crucial:     .size() is for arrays  while  .length() is for Strings
// Now, this program can be written in one single line of code or two..with the help of streams[ This is how streams optimize the code), so
//                      *****            // do this in the next program that is B_Streams.        *****
