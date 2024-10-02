package streamExamples;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

// You have the following:  List<Integer> values= Arrays.asList(3,2,2,7,5,1,9,7);
              // ANSWER each question separately 
    //Q1: what structure is the above ?
   // Q2: Print out the unique numbers from this array.
  //  Q3: Print out the sorted array ( In ascending order)
 //   Q4: Print out the unique sorted numbers.
//    Q5: get a unique sorted order and display the 3rd index.
public class U_Streams {
	
	@Test
	public void  U_StreamsTest()
	{
		/*Q1: It is an ArrayList ( one way of creating it. Where the other ways are:-->
		      ArrayList<Integer> numbers= new ArrayList<Integer>();
		                         number.add(3);
		                         number.add(2); 
		                         etc.    */
		
		// And stream.of(3,2,2,7,5,1,9,7).filter(....)/ other stream methods     // only use it if you are applying stream operations.
		
	//Q2: To optimize the code, Java streams will be utilized (Instead of plain java where 2 for loops are required- at least)
		List<Integer> values= Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().forEach(s->System.out.println(s));  // Remember that .limit() .distinct() .filter(s-s...) are all aggregate
		  // operations of Java Streams.
		
	//Q3:
		System.out.println("=====Q3========");
		values.stream().sorted().forEach(s->System.out.println(s));
		
	//Q4:
		System.out.println("======Q4=======");
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		
	//Q5:
				System.out.println("======Q5=======");
				List<Integer> ls= values.stream().distinct().sorted().collect(Collectors.toList());  // what if you add .get(3) here ?
				System.out.println(ls.get(3));    // this is 3rd index ( 4th element in the list)
				// getting an index in never a stream operation/ method.
		
	}

}
