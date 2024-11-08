package streamExamples;
// This is Exactly the previous program but simply without any comments. Observe and predict each the outputs.

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class S_Streams {
	
	@Test
	public void S_StreamsTest()
	{
		
		List<String> ls= Stream.of(" Abhijeet", "Rona", "Alekhya", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		ls.stream().filter(s->s.startsWith("R")).sorted().forEach(s->System.out.println(s));  
		System.out.println("=====================");
		System.out.println(ls);
		System.out.println("=====================");
		System.out.println(ls.get(1)); //Verify: one could use  ls.stream().filter(s->s.indexOf(1)). Nevertheless, the former optimizes the code.
		System.out.println(ls.get(0));
		System.out.println("=====================");
		
			  
	}

}
