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
    //This testcase is EXACTLY the same as Y_final_filtering_webTable, where the
    // only difference is that all comments are taken out.

//Scenario: Compare the UI price of a product to that in the database.
	// Solution: get the product's price & compare it to the one in the database,
     // Hint: The UI price is fetched from the database, with the possibility of not being displayed correctly.
          // Pre-requisite: Study the webpage well before proceeding in comprehending this testcase. This is crucial.
public class Z_final_filtering_webTable {
	
	@Test
	public void ZZ_gFinalTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String ui_product= "alMondi";
		List<String> product_list;     
		String database_price= "64"; 
		
		do {
		List<WebElement> webElements= driver.findElements(By.xpath("//tbody/tr/td[1]"));
  product_list= webElements.stream().filter(s->s.getText().equalsIgnoreCase(ui_product)).map(s->getprice(s)
		.getText()).collect(Collectors.toList());
		

if(product_list.size()==0)  
{
	 try {
	 driver.findElement(By.xpath("//a[@aria-label='Next']")).click(); }
	 
	 catch(Exception e)
	 {
		System.out.println("FAILED: Product "+ ui_product+ " has not been found anywhere on any page in this list.");
		System.out.println("Throwing an error compiler/ Exception:-->");
		Assert.assertTrue(false);}}

else { 
	  if (product_list.contains(database_price)) //Instructor's technique !
	  {
		System.out.println("PASS. For the product: "+ ui_product );
		System.out.println("The displayed UI price of: " +  product_list.get(0) + " matches that of the database which is: " +database_price  );
	  }
	  else
	  {
		  
     System.out.println("PASS. For the product: "+ ui_product );	  
	 System.out.println("The displayed UI price of: " +  product_list.get(0) + " does NOT match that in database which is: " +database_price);
	 System.out.println("Throwing an error compiler/ Exception:-->");
	 Assert.assertFalse(true);
	  } }}
		while(product_list.size()==0);}
		     
	private WebElement getprice(WebElement s)
	{
		WebElement element_price= s.findElement(By.xpath("following-sibling::td[1]"));    
		return element_price;
	}

}
