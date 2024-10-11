package streamExamples;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;
//create two arrayLists and merge them together.
// Then display the sorted list of merged items.

public class N_Streams {
	
	@Test
	public void N_StreamsTest()
	{
		List<String> names1=  Arrays.asList("ahmad", "Yansin", "Jenys"); // or ArrayList<String> names1= new ArrayList<String>();  
		List<String> names2=  Arrays.asList("Adam", "Syra", "lynda");
		
		Stream<String> combined_names= Stream.concat(names1.stream(), names2.stream()).sorted();
		combined_names.forEach(s->System.out.println(s));
		
		// or simply:
	//	Stream.concat(names1.stream(), names2.stream()).sorted().forEach(s->System.out.println(s));
	}

}
