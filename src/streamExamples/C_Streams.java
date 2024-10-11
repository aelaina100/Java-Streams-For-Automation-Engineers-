package streamExamples;
import java.util.stream.Stream;

//Create an ArrayList collection class and store elements into it,
//Thereafter, display the count of elements that start with the letter "A". Utilizing Java Streams. BUT this time in the simplest 'light-weight' way.
public class C_Streams {

	public static void main(String[] args) {
		
	long x= Stream.of("Ahmad", "yansin", "Lyria", "adam","Ansyn" ).filter(s-> s.startsWith("A")).count();
	System.out.println(x);
	
// Note: 
	
	 // Stream.of("Ahmad", "yansin", "Lyria", "adam","Ansyn" )  
	
	                                         //is equivalent to the below lines of :
	
	 /* ArrayList<String> names= new ArrayList<String>();
    	names.add("Ahmad");
		names.add("yansin");
		names.add("Lyria");
		names.add("adam");
		names.add("Ansyn");  
		
       names.stream()
       
       */
	
	// Now, let us say, the left side of lambda, that is the 'Action on that parameter' line should be on a diff. line due to not having enough
	  // space, then how would you write the code ? (this is shown on the next example that is D_Streams)
	}

}
