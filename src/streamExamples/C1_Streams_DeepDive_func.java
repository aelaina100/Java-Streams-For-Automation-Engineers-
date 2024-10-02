package streamExamples;      //arraylist & string types have the .contains() method
import java.time.Duration;   //size starts from '1' while length from '0' ??
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import graphql.Assert;            

                             //****** Deep dive into functional testing ******
    //One of the most important real-time testcases.
    //Scenario: add a SINGLE item to cart.         
public class C1_Streams_DeepDive_func {
  @Test
  public void G1_Streams_DeepDive_funcTest()
  {
  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
  ChromeOptions options = new ChromeOptions();
  options.addArguments("--remote-allow-origins=*"); 
  WebDriver driver = new ChromeDriver(options);        
  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
  
  String product_wanted= "APplE";
  String product_wanted_noCase =product_wanted.toLowerCase();
//To identify the element of 'Add to cart', there is absolutely to locator technique that's valid, except
		// the approach below: driver.findElements.get(i).getText();
  
  List<WebElement> elements= driver.findElements(By.cssSelector("h4.product-name"));  // This is nothing but only to get the count
   for (int i=0; i<elements.size();i++) {
	  String  ui_product= elements.get(i).getText().toLowerCase(); // output is something such as 'Cashews - 1 Kg'
	  if(ui_product.contains(product_wanted_noCase)) 
		  // since .contains() doesn't have the feature of ignoring case sensitive such as .equalsIgnoreCase, 
		   // conversion to lower cases is done in 2 places.
	  {
		  driver.findElements(By.xpath("//div[@class= 'product-action']/button")).get(i).click();
		  System.out.println("****************Item added");
		  break;  }//Gets executed when the very above line does. Don't want to continue iterating after wanted product is added. no point.	  
	 
	  else if (i==elements.size()-1) { // If on the last iteration where the 'if block', hasn't been executed = 
		  System.out.println("Product: [" + product_wanted +"] can NOT be found. Hencing throwing an exception:->" );;
		  Assert.assertFalse(true); } } 
   }
  }
   
   /* Note: the style of the following block isn't optimized (The optimied version is included above):-
    * 
    int count= driver.findElements(By.cssSelector("h4.product-name")).size();
    for (int i=0; i<count ;i++) {
    driver.findElements(By.cssSelector("h4.product-name")).get(i).something */
      
   
 
