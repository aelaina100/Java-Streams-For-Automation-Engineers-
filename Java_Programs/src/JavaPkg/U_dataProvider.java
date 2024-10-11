package JavaPkg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class U_dataProvider {
	
	// This class could be moved under a different project.
	@DataProvider
	public String[][] getData()
	{
		String[][] object= new String[3][2];
		
		object[0][0]= "ffff@gmail.com";
	    object[0][1]= "hfghh"; 
	    
	    object[1][0]= "ffff@gmail.com";
	    object[1][1]= "hfghh";
		
	    object[2][0]= "333@gmail.com";
	    object[2][1]= "33333";
	    
	    return object; 
	}

	@Test(dataProvider= "getData")
	public void login(String username, String password)
	{
		System.out.println(username);
		System.out.println(password);
		System.out.println("=======End of method/Testcase");
		System.out.println("");
	}


}
