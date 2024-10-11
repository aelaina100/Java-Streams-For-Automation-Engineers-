package streamExamples;
import java.util.ArrayList;
import org.testng.annotations.Test;
//Create a variable and place several elements inside of it. Using streams, For item(s) that end with 'a' print out but shown in capital letters.
public class I_Streams {
	
	@Test
	public void I_StreamsTest()
	{
		// This variable has to belong to a collection class as streams only apply to it. I will choose an ArrayList
				ArrayList<String> names= new ArrayList<String>();
				names.add("Ahmad");
				names.add("yansin");
				names.add("Lyria");
				names.add("adam");
				names.add("Ansyn");
				// basically before the last step of printing out, convert the new stream into capital letters.
// so far in the examples- we are having a new stream via the intermediary operation and then either display its count or display its content 
// In other words, we have not been manipulating/ performing operations on this new stream BUT in here we are going to since we need to convert it 
//to capital letters before displaying it ( displaying it is the terminal operation).
				
// To manipulate/ Perform operations on the new stream/ or even original ( a new stream as a result of filtering or limiting or something else) then 
				//utilize the MAP method.
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
// Reminder:  to simplify the code even further:
	 // Stream.of("Ahmad", "yansin", "Lyria", "adam","Ansyn" ).filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
}
// Again, without streams 6 or 10 lines of code would, at least, be required.