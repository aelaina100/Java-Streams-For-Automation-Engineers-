package streamExamples;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

// Create an array ( A fixed length data structure), then using streams
// Find the names that have the first letter as capital "A" and then sort them out and eventually print out results in capital letters.
public class L_Streams {
	// streams only apply to a collection class ( ArrayList, List, & Set). Therefore,
   // Our created Array has to undergo a conversion to an ArrayList so that Java streams can be applied to it
	@Test
	public void L_Streamstest()
	{
		String names[]= {"Azmad","yansin","Lyria","adam","Ansyn"};  // Is a simpler format to create and array where memory is dynamically allocated.
        
		List<String> namesList= Arrays.asList(names);	
	    namesList.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
 /*or:  String names[]= new String[5];    // The longest 'traditional way' of creating an array.
		names[0]= "Azmad";
		names[1]= "yansin";
		names[2]= "Lyria";
		names[3]= "adam";
    	names[4]= "Ansyn"; */   
	    
	    //Note: I've written this program in very few steps. That's the diff. between an Architect and a mere Automation QA where
	      // The architect finds solutions + being a high level automation QA Engineer!. These skills will not only help you clear up interviews but
	       // are also impressive skills under your belt.
	}
}
