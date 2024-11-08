package streamExamples;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

                            //****** Deep dive into functional testing ****** 
//One of the most important real-time testcases.
//Scenario: add more than one product to basket (Multiple items this time)
public class D1_Streams_DeepDive_func_mult {
	@Test
	public void F1_Streams_DeepDive_functional_multTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] product_wanted= {"banana", "Tomato", "Corn"};
		List<WebElement> elements= driver.findElements(By.cssSelector("h4.product-name")); // only to obtain the count number. ONLY
		int count=0;
		
		for(int i=0; i<elements.size(); i++)
		{
			String product_info_section= elements.get(i).getText();  // output such as: 'Brocolli - 1 Kg'. 
			// Now, let's check if product_wanted[] contains the string(s) of ui_product_info. Our main strategy.
			// However; remember that .contains is a feature of ArrayLists and not arrays.
			//Next line: splitting based on '-' character.
		    String[] array1= product_info_section.split("-");   // {'brocolli ',' 1 Kg'} // pay attention to spaces in each array element.
		    String ui_product_name= array1[0].trim().toLowerCase();    // trims all space(s), right and left
		   
		    List<String> final_product_wanted= Arrays.asList(product_wanted);
		    List<String> final_product_wanted_nocase= final_product_wanted.stream().map(s->s.toLowerCase()).collect(Collectors.toList());
		    // above line is ensure that case sensitivity does not matter for products I want to add to basket.
		    if(final_product_wanted_nocase.contains(ui_product_name))  // contains is better than '.qualsIgnoreCase' + check the comment below.
		    {
		    	driver.findElements(By.xpath("//div[@class= 'product-action']/button")).get(i).click();
		    	count++;
		    	if (count==product_wanted.length) 
		    	{
		    		break; //Exists 'for loop (No need to iterate to the next item when all items listed are already added to basket.
		    	}
		    	
		    }
		    // Now, I want to use the .contain(). But, it's a function of an arraylist and not an array.
		    // So convert the array 'product_wanted' into an arraylist. Also, note that- you never ever declare an arraylist
		    // with elements inside of it just directly. You first have to declare an array, and then convert it into an
		    //arraylist when immedately needed (even if this causes the arraylist to be inside a loop. This is fine."
		    // This is due to memory management, for saving space.
		    
		}
	}

}
