package streamExamples;
import java.util.ArrayList;

import org.testng.annotations.Test;

// Create a variable and place several elements inside of it. Using streams, only print out the first item.

public class F_Streams {
	@Test
	public void F_StreamsTest()
	{
		// This variable has to belong to a collection class as streams only apply to it. I will choose an ArrayList
		ArrayList<String> names= new ArrayList<String>();
		names.add("Ahmad");
		names.add("yansin");
		names.add("Lyria");
		names.add("adam");
		names.add("Ansyn");
		
		names.stream().limit(1).forEach(s->System.out.println(s));  // .limit(1) is the intermediary operation  & forEach(..) is the terminal one.
		
		//Note:  limit(2)                  limit to the first 2 items/ will create a new stream of:  Ahmad, yansin
		 //      limit(3)                  limit to the first 3 items/ will create a new stream of:  Ahmad, yansin, Lyria      and so on.
		
}}