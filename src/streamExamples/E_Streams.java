package streamExamples;
import java.util.ArrayList;

import org.testng.annotations.Test;
// Using streams- add a group of names to a variable and then Print out the names whole length is greater than 4
public class E_Streams {
    
	@Test
	public void E_StreamsTest() {
		// Streams can only be applied to a collection class (That is ArrayList, List, & Set). So 
		  // I am going to create an arrayList and the add elements to it and then utilize stream operations:
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Ahmad");  
		names.add("yansin");
		names.add("Lyria");
		names.add("adam");
		names.add("Ansyn");
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s)); 
		
		// In the above line, the output of the portion of:  filter(s->s.length()>4)   is:   Ahmad,yanis, Lyria, Ansyn  (which is a new stream).
		   // [the intermediate operation above creates a new stream].
		
		// So, the 'forEach' terminal line is applied to    Ahmad,yanis, Lyria, Ansyn

//'forEach' grabs each and every item in the new stream parallelly and applies on each the action of printing out.
		
// Now- Solving this problem with traditional plain java lines of code, would take way more lines and logic.

	}

}
