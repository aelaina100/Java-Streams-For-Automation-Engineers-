package streamExamples;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import graphql.Assert;

//Scenario: Compare the UI price of a product to that in the database.
	// Solution: get the product's price & compare it to the one in the database,
     // Hint: The UI price is fetched from the database, with the possibility of not being displayed correctly.
          // Pre-requisite: Study the webpage well before proceeding in comprehending this testcase. This is crucial.
public class Y_final_filtering_webTable {
	
	@Test
	public void ZZ_gFinalTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //"--disable-extensions"
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String ui_product= "alMondi";
		List<String> product_list;      // a global variable outside of any statements.
		String database_price= "64"; // or an equivalent database code thats get the price value & stores it in "database_price"
		
		do {
		List<WebElement> webElements= driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//Now, filter the list of webelements based on text (if filtered, controller will be at that webelement)
		 // now, move the controller onto the element where the price is stored. This is done utilizing the .MAP()
		  // function that contains a method containing driver.findElement..(identifying the element), where he price is stored in.
		   // then, get that price.
  product_list= webElements.stream().filter(s->s.getText().equalsIgnoreCase(ui_product)).map(s->getprice(s)
		.getText()).collect(Collectors.toList());
		// Above line: .getText() can only be included as a continuation of 'getprice(s)', and
		 // this is the equivalent of including it, instead, after "By.xpath("following-sibling::td[1]" in the line below, which
		  // is a confirmation that it should directly follow getprice(s) in the .map() function.

// Now if the product isn't on the page, then I would like to navigate to the next page.
 // if not on page, .filter() returns false. Rendering this step and whatever comes after invisible to the compiler where it's
 // going to only 'see' List<String> product_list= webElements.stream() which is nothing but an empty list "[]"/ of size 0

if(product_list.size()==0)  
{
	 try {
	 driver.findElement(By.xpath("//a[@aria-label='Next']")).click(); 
	 // above: if it takes us to the last page where product is still not listed, then 
	 //script will execute the above line again in order to click on the 'next' button again, but this button is going to
	 // be disabled, hence throwing a compiler error. Therefore I will use a try() catch() statement where in the catch(), I 
	 // will include a message denoting that product doesn't exist on any page of this list	 
	}
	 catch(Exception e)
	 {
		System.out.println("FAILED: Product "+ ui_product+ " has not been found anywhere on any page in this list.");
		System.out.println("Throwing an error compiler/ Exception:-->");
		Assert.assertTrue(false);
	 }
}

else { // List<String> product_list    is going to hold the value of [number] with no space. Verifiable with system.out.println(product_list)
	  if (product_list.contains(database_price))
	  {
		System.out.println("PASS. For the product: "+ ui_product );
		System.out.println("The displayed UI price of: " +  product_list.get(0) + " matches that of the database which is: " +database_price  );
	  }
	  else
	  {
		  //
     System.out.println("PASS. For the product: "+ ui_product );	  
	 System.out.println("The displayed UI price of: " +  product_list.get(0) + " does NOT match that in database which is: " +database_price);
	 System.out.println("Throwing an error compiler/ Exception:-->");
	 Assert.assertFalse(true);
	  }
	   
     }


	}
		while(product_list.size()==0);
	}
	
	
	/*Homework:
	// on the last page if the product is not found, then the test should fail indicating so. this is
// done by either:
//1- clicking on the unclickable 'Next' button so an exception is throwable and we catch it where
	  //(in catch() 1- log a message indicating the product is NOT found on all pages.
//2- trying to identify the 'Next' button with an attribute that indicates 'active', 'enabled', etc. so an exception is throwable and we catch it where
	  //(in catch() 1- log a message indicating the product is NOT found on all pages.
	//shown in net program Z_Streams_FilteringWebElement.java  */

	/********************
	
	See if you can or simply erase the following notes:
	// place all web elements holding texts (Under "Veg/fruit name" column) in a list.
		// filter out a web element based on the text you'd like to find (Rice).
		// move the controller from that web element to the web element in the very adjacent row.[using MAP method to manipulate filtered web element].
		
		// Also: This web table exists on several pages- Do{} While{} statement where do{} ALWAYS executes
		 // for the 1st time ever regardless whether while{} returns true or false. This leads us to the following speculation:
		
		   // A- do{}: Rice exits on the 1st page. So while{} must return false so that loop is exited.
		   // B- do{}: Rice does NOT exist on the 1st page. So while{} must return true so that do{} is executed for the 2nd time where
		        // it induces navigation to the 2nd page and etc.   
	   
	   
	   
	   */
	private WebElement getprice(WebElement s)
	{
		WebElement element_price= s.findElement(By.xpath("following-sibling::td[1]"));    // "/" before following::sibling throws exception.
		return element_price;
	}

	// Next example is this exact code but without the comments (Z_final_filtering_webTable)
}
