package streamExamples;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class D_Streams {
    @Test
	public void D_Streamstest() {
    	
    	long x= Stream.of("Ahmad", "yansin", "Lyria", "adam","Ansyn" ).filter(s-> 
    	
    	s.startsWith("A")).count();  
        System.out.println(x);
	}

}
