package streamExamples;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;
                                    // Observe the code and predict the outputs
public class T_Steams {
	
	@Test
	public void T_SteamsTest()
	{
     ArrayList<String> names= new ArrayList<String>();
     names.add("Yany");
     names.add("Abhijeet");
     names.add("Rona");
     names.add("Alekhya");
     names.add("Rama");
     
	List<String> ls= names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());  //RONA ALEKHYA RAMA
		ls.stream().filter(s->s.startsWith("R")).sorted().forEach(s->System.out.println(s));    // RAMA RONA
		System.out.println("=====================");
		System.out.println(ls);
		System.out.println("=====================");
		System.out.println(ls.get(1));
		System.out.println("=====================");
	}

}
