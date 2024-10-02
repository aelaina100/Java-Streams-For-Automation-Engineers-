package streamExamples;
import java.util.ArrayList;
import org.testng.annotations.Test;
//Create a variable and place several elements inside of it. Using streams, print out all elements but in capital letters.
public class J_Streams {
	
	@Test
	public void J_StreamsTest()
	{
		// This variable has to belong to a collection class as streams only apply to it. I will choose an ArrayList
		ArrayList<String> names= new ArrayList<String>();
		names.add("Ahmad");
		names.add("yansin");
		names.add("Lyria");
		names.add("adam");
		names.add("Ansyn");
		
		names.stream().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
//If you write codes this way (Using streams instead of traditional plain Java code),Then you're a distinguished gentleman who can clear up interviews.
	//someone who is very advanced in the automation game.
}
