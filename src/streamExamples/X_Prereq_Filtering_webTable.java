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

//This code, will only check the first and second page. Not that useful, as
//I want to check every single page of the list.
//so I want to repeat the same code over and over again. How can we do that ?
//the answer is in the very last line of this testcase (check it out)

//Scenario: Compare the UI price of a product to that in the database.
	// Solution: get the product's price & compare it to the one in the database,
     // Hint: The UI price is fetched from the database, with the possibility of not being displayed correctly.
          // Pre-requisite: Study the webpage well before proceeding in comprehending this testcase. This is crucial.
public class X_Prereq_Filtering_webTable {
	
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
		
		String ui_product= "rIcE";
		
		List<WebElement> webElements= driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//Now, filter the list of webelements based on text (if filtered, controller will be at that webelement)
		 // now, move the controller onto the element where the price is stored. This is done utilizing the .MAP()
		  // function that contains a method containing driver.findElement..(identifying the element), where he price is stored in.
		   // then, get that price.
List<String> product_list= webElements.stream().filter(s->s.getText().equalsIgnoreCase(ui_product)).map(s->getprice(s)
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
		System.out.println("Product has not been found anywhere on any page in this list. hence, throwing a comiler error");
		Assert.assertTrue(false);
	 }
}



	}
	

	
	
	private WebElement getprice(WebElement s)
	{
		WebElement element_price= s.findElement(By.xpath("following-sibling::td[1]"));    // "/" before following::sibling throws exception.
		return element_price;
	}

}
// This is done by utlizing the do while statement.
// where the block of the do will always be executed first & at least one time where
// if while() false, the compliler will exit the loop. other it's going to keep on executing 
//the do block, until while() return false.

   //Next example is the final complete version: Y_final_filtering_webTable
