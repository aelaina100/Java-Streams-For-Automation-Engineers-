package streamExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

// Simply observe this program line by line (Crucial)
public class O_Streams {
	
	@Test
	public void O_StreamsTest()
	{
		List<String> names1=  Arrays.asList("ahmad", "Yansin", "Jen"); // or ArrayList<String> names1= new ArrayList<String>();  
		names1.stream().filter(s->s.endsWith("n")).map(s->s.toUpperCase()).sorted();
	// Above line NEVER EVER modifies the source 'names1'. Hence- In 2nd line below 'names1' is ALWAYS the original list of "ahmad","Yansin",&"Jen".
		
		List<String> names2=  Arrays.asList("Adam", "Syra", "lynda");
		
		Stream<String> combined_names= Stream.concat(names1.stream(), names2.stream()).sorted();
		combined_names.forEach(s->System.out.println(s));
		
		// or simply:
	//	Stream.concat(names1.stream(), names2.stream()).sorted().forEach(s->System.out.println(s));
	}

}
