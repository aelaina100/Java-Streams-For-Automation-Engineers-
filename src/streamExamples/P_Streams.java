package streamExamples;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_Streams {
	
	@Test
	public void P_StreamsTest()
	{
		List<String> names1=  Arrays.asList("ahmad", "Yansin", "Jen"); // or ArrayList<String> names1= new ArrayList<String>();  
		List<String> names2=  Arrays.asList("Adam", "Syra", "lynda");
		
		// For the above arrayLists- Merge them together and verify that "Adam" exists in the merged ArrayList.
		Stream<String> combined_names= Stream.concat(names1.stream(), names2.stream());
		// to verify:
		Boolean b= combined_names.anyMatch(s->s.equals("Adam")); // It has to return 'true'.
		Assert.assertTrue(b);
		
		/* Separate Note:  The match() operations are [They return a boolean True or False):
		                   
		                    anyMatch(): Boolean
		                    allMatch(): Boolean
		                    noneMatch:  Boolean   */  
		
	}

}
