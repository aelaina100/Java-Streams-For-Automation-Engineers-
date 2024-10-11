package streamExamples;
import java.util.ArrayList;

import org.testng.annotations.Test;
//Create a variable and place several elements inside of it. Using streams, Print out the item(s) in the list whose length is 4

public class H_Streams {
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
		
		names.stream().filter(s->s.length()==4).forEach(s->System.out.println(s));
	}

}
