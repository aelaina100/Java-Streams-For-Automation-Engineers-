package streamExamples;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.testng.annotations.Test;
// create two arrayLists and merge them together.
 // Then display the  list of merged items.
public class M_Streams {
	
	@Test
	public void M_StreamsTest()
	{
		List<String> names1=  Arrays.asList("ahmad", "Yansin", "Jenys"); // or ArrayList<String> names1= new ArrayList<String>();  
		List<String> names2=  Arrays.asList("Adam", "Syra", "lynda");
		
		Stream<String> combined_names= Stream.concat(names1.stream(), names2.stream());
// Above: You can not add forEach() unless you erase '= Stream.concat(names1.stream(), names2.stream());  part before the equal sign.
		combined_names.forEach(s->System.out.println(s)); // combined_names is of 'Stream' type so it is already stream compatible..duh !
		
		//System.out.println(combined_names); // won't work - Method does not take a 'stream' type 
		
		 
		 
	}

}
