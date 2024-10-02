package streamExamples;
// Create an ArrayList collection class and store elements into it,
//Thereafter, display the count of elements that start with the letter "A". Utilizing Java Streams.

import java.util.ArrayList;

import org.testng.annotations.Test;

public class B_Streams {
    @Test
	public void B_StreamTest() {
    	
    	ArrayList<String> names= new ArrayList<String>();
    	names.add("Ahmad");
		names.add("yansin");
		names.add("Lyria");
		names.add("adam");
		names.add("Ansyn");
		
		long x= names.stream().filter(s-> s.startsWith("A")).count();// int won't work, but only long
		System.out.println(x);
// .stream() makes the collection class (In this case it is the 'names' ArrayList) stream compatible, so that stream can process it.
// .filter(....):an intermediate operation that can only be executed to start with when 1- It returns 'true'. & 2- is followed by a terminal operation.
		
// A terminal operation, is the method applied at the final stream {The stream that is created, in this case, after applying the filter() method).
 // without the terminal operation existing, the intermediate one is going to be treated as if it does not even exist/ not even typed out.
// Now, even if the terminal operation exists, it will not be executed along with the intermediate one if the intermediate returns false ( as if the 
		//intermediate and terminal not even typed out to start with)
		
// Parameter 's' will be scanning the whole list of names but in parallel (at the same time), where for each single scan the action is applied, this is
  //very powerful and makes the execution time very very quick !

// Now, the step of .filter(....) is called an intermediate operation, and if at least one thing gets filtered, then it will return 'true', if not
  // ,then it will return false.   and when at least one thing is filtered, then another stream is created ( the stream of Ahmad & Ansyn)
		
//Crucial: The aggregate operations (Stream operations) that we perform on the output of a collection class (Either an ArrayList, list, or set),
 // do NOT change the data of the source, but simply return a new stream. For example,
  // the above line of code: names.stream().filter(s-> s.startsWith("A"))   will NEVR EVER modify the elements inside the source of 'names' arraylist.
		
// NOW, the above code can even be written in a much simpler way that is light-weight stream compatible collection (Useful for practice),
		//as illustrated in the next program titled: C_Streams
	}
}
