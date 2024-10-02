package streamExamples;
import java.util.ArrayList;
import org.testng.annotations.Test;
// Find sorted names that have the first letter as capital "A" and print out results in capital letters.

public class K_Streams {

	@Test
	public void K_StreamsTest()
	{
		//So the very last step is is to capitalize what we have before printing out. 
		ArrayList<String> names= new ArrayList<String>();
		names.add("Azmad");
		names.add("yansin");
		names.add("Lyria");
		names.add("adam");
		names.add("Ansyn");
		
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
	// or: names.stream().sorted().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	// Note: Sorting can ONLY be applied to an arrayList
    // Note: In general if you are asked to write a sorting program in an interview: then,
		// you will have to write a 2 for loops at least plus an array to create the program. whereas, if you use streams
		//It will be straight forward where the array given by the interviewer is to be converted into an ArrayList, then 
		// make it stream compatible and then apply all the necessary steam operations.
	}
}
