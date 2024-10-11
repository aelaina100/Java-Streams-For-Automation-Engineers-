package streamExamples;
import java.util.ArrayList;

import org.testng.annotations.Test;
// // 1- Create a variable and place several elements inside of it. Using streams, only print out the first item whose length is greater than 5

public class G_Streams {
	
	@Test
	public void G_StreamsTest()
	{
		// This variable has to belong to a collection class as streams only apply to it. I will choose an ArrayList
				ArrayList<String> names= new ArrayList<String>();
				names.add("Ahmad");
				names.add("yansin");
				names.add("Lyria");
				names.add("adam");
				names.add("Ansyn");
				
				names.stream().filter(s->s.length()>5).limit(1).forEach(s->System.out.println(s));
				
			// This Intermediate operation  .filter(s->s.length()>5)   = yansin only ( this intermediate one filters out something so it returns true)
				// yansin is the new stream.
				
				// My understanding according to notes is that, limit(1) above is also a part of the intermediary operation.
				// the terminal operation above is:   .forEach(s->System.out.println(s)). 
				// yansin will be sent to this terminal operation where it will be printed out.
				
				// forEach(s->System.out.println(s)) helps us scan throughout the entirety of what has been returned.
		// Again, attempting to solve this problem with traditional plain Java programming is a daunting task since it is going to
		// require more lines of code and a more complicated logic.
	}

}
