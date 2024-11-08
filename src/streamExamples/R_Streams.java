package streamExamples;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

// Observe the following: 
  //So far, we've been performing operations such as:
  //Stream.of(" Abhijeet", "Rona", "Alekhya", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase());
  // and then displaying it on the screen by adding:  .forEach(s->System.out.println(s));

//In other words- We have been applying stream operations on a declared collection class, rendering a new stream that is eventually printed out/displayed 
//on the screen. Nonetheless. in real-time projects,we don't display it [This has been for practice purposes only]. 
// Instead, we collect it into a new list in order to send it to either UI or backend.
// So for the above line add: Collect(Collectors.toList())
//                                              .toSet()
//                                              .toMAP()  // another option. 
//  and then create a list variable so the new list is stored in List<String> ls

public class R_Streams {
	
	@Test
	public void R_StreamsTest()
	{
// So, In real-time project you will have:
List<String> ls= Stream.of(" Abhijeet", "Rona", "Alekhya", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
// Separate: For the above line, predict what the new list is without running the program.   (Answer: RONA, ALEKHYA, RAMA)
// Where we can apply stream operations on this collected new list named ls:--> (For example-->):
ls.stream().filter(s->s.startsWith("R")).sorted().forEach(s->System.out.println(s));    // output is: RAMA, RONA

// CRUCIAL NOTE: Immediate above line NEVER EVER modifies the source 'ls'. 
   //Hence-  the line below proves that 'ls' is ALWAYS the original list of "RONA, ALEKHYA, RAMA"
System.out.println(ls);   // output with brackets [..,..,..]

// Now below: print out the first element in 'ls'.
System.out.println("=====================");
System.out.println(ls.get(0));

// The next example, S_Streams is this exact same program but without any comments
  
  

		
	}

}
