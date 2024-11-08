package streamExamples;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


// On the webpage: https://rahulshettyacademy.com/seleniumPractise/#/offers, Ensure that the sorting functionality is intact.
// Solution: Before proceeding to read the rest, think of the solution.
 //The best&only solution to this issue:-> (Any other solution renders the code unoptimzed- too many line & or more complex of a code.
   // 1- start out with clicking on the sort button.
  //  2- collect the product's names into a list.
 //   3- Apply the .sort() stream functionality to the already collected list, and collect this 2nd list.
 //   4- if the original list matches the latter list, then the sorting functionality is intact. If not, then
   //the sorting functionality is faulty (Where nothing was sorted out, to start with, right after you clicked on the sorting button)
public class B1_Streams_sorting { 
    @Test
	public void B1_Streams_sortingTest()
	{
    	
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*"); 
WebDriver driver = new ChromeDriver(options);        
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

//driver.findElement(By.xpath("//thead/tr/th[1]")).click();  // clicks on the 'sort' button.
List<WebElement> elements= driver.findElements(By.xpath("//tbody/tr/td[1]")); // If this line is the 1st, = causes stale element exception.
List<String> text_UI_sorting  =elements.stream().map(s->s.getText()).collect(Collectors.toList());
List<String> text_method_sorting= text_UI_sorting.stream().sorted().collect(Collectors.toList());

assertEquals(text_UI_sorting, text_method_sorting, "FAILED: Sorting function does NOT work/ nothing in the UI was sorted in the first place");

/*  the above line replaces the 'if' statement below:
if(text_UI_sorting.equals(text_method_sorting))
{
	System.out.println("PASS: Sorting function works");
	Assert.assertTrue(true);
}

else
{
	System.out.println("FAILED: Sorting function does NOT work/ nothing in the UI was sorted in the first place");
	Assert.assertTrue(false);  
}    */

driver.quit();


	}}
/* B-
// Note: the below code has too many lines of code. As a first step: Go over it/ skim through and,
 // then, think of a simpler way to do way with its redundancy.
public class B1_Streams_sorting {
	 
    @Test
	public void B1_Streams_sortingTest()
	{
    	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*"); 
    	WebDriver driver = new ChromeDriver(options);        
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    	
    	List<WebElement> elements= driver.findElements(By.xpath("//tbody/tr/td[1]"));
    	
    	List<String> foodName= elements.stream().map(s->s.getText()).collect(Collectors.toList());
    	driver.findElement(By.xpath("//thead/tr/th[1]")).click();  // clicks on the 'sort' button.
    	
    	//List<String> afterSorting_foodName= elements.stream().map(s->s.getText()).collect(Collectors.toList());
    	// above commented out line: throws a stale elements exception:- Element not attached to webpage.
    	List<WebElement> the_elements= driver.findElements(By.xpath("//tbody/tr/td[1]"));
    	List<String> afterSorting_foodName= the_elements.stream().map(s->s.getText()).collect(Collectors.toList());
    	
    	//System.out.println(foodName);
    	//System.out.println(afterSorting_foodName);
    	if(foodName.equals(afterSorting_foodName))
    	{
    		System.out.println("FAILED: the sorting functionality does NOT work");
    		Assert.assertTrue(false);
    	}
    	else
    	{
    		System.out.println("PASSED: Sorting functionality is intact");
    		Assert.assertTrue(true);
    	}

}
} */
