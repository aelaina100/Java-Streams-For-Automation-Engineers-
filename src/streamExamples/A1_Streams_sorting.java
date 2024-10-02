package streamExamples;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import graphql.Assert;
                         // Ensure that the sorting function works (For products' name).
// CRUCIAL: Instructor's 'way' of writing this testcase is different. This is my own code. and,
// this is a high level coding. It is important to understand the code even if you decide to go with the instructor's.
// and yes, this code isn't optimized as I should, instead, utilize streams. but once again the logic of programming here is invaluable.
public class A1_Streams_sorting {
	
	@Test
	 public void A1_Streams_sortingTest()
	 {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*"); 
	WebDriver driver = new ChromeDriver(options);        
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
	int count= driver.findElements(By.xpath("//tbody/tr/td[1]")).size();
	ArrayList<String> list= new ArrayList<>();
	ArrayList<String> list_afterSorting= new ArrayList<>();
	String product_name = null;
	int counter=0;
do {
	for(int i=0; i<count; i++)
	{
		if(counter==0) 
		{
		product_name= driver.findElements(By.xpath("//tbody/tr/td[1]")).get(i).getText();
		list.add(product_name);
		}
		
		else
		{
			product_name= driver.findElements(By.xpath("//tbody/tr/td[1]")).get(i).getText();
			list_afterSorting.add(product_name);	
			}
	}
	// Now, click on the sorting button (For products' name)
	driver.findElement(By.xpath("//thead/tr/th[1]")).click();
	counter++;
	}

while(counter<2); // will cause the do{} block to execute twice.



System.out.println(list); // output: [-,-,-, etc.]
System.out.println(list_afterSorting); //output: [-,-,-, etc.]

if (list.equals(list_afterSorting))  
{
	System.out.println("FAILED: Sorting button does NOT work");
	Assert.assertTrue(false);
}
else
{
	System.out.println("PASS: Sorting button work !");
	Assert.assertTrue(true);
}

		 }	
}
