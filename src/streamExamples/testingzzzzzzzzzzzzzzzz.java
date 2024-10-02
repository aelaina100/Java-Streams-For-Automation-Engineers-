package streamExamples;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class testingzzzzzzzzzzzzzzzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> arrlist=  Arrays.asList("Draco", "Lazy", "Weak");
		
		String element= "Weak";
		boolean value= arrlist.contains(arrlist);
		if(value) // if returnss true
		{
			System.out.println(element+ " is ana element in the arraylist");
		}
		else {
			Assert.assertTrue(false);
		}
			
		

	}

}
