package streamExamples;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class testingtestingtesting {
	// Get the price of a specific item.
	//List<String> price;
	@Test
	public void veryUseful() throws InterruptedException
	{
		WebDriver driver = new EdgeDriver();        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// let's leave page pagination till the very end where a do while statement will be utilized.
		
		String wantedproduct= "Tomato";
		
		List<WebElement> elements= driver.findElements(By.cssSelector("td:nth-child(1)"));
		for(int i=0; i<elements.size(); i++)
		{
			if(elements.get(i).getText().equalsIgnoreCase("Apple"))
			{
				// If the box element hosts the text wanted, then move the controller from that box element
				  // and onto the box elements that hosts its price.
				// so the controller right now is at the box holding the wanted text
				 List<String> price= elements.stream().map(s->getPrice(s)).collect(Collectors.toList());
				 System.out.println("000000000000000000000000007&&&&&&&&&&&&&&&&&&&&");
				 System.out.println(price);
				
				break;
				
			}
		}
		
		
		//System.out.println(price);
		
		//Thread.sleep(10000L);
	

	}

	private String getPrice(WebElement s)
	{
		String priceBox= s.findElement(By.xpath("following-sibling::td")).getText();  // including the/ before this partial Xpath will trigger an error.
		return priceBox;
	}
	
	
	}
	
	
	
	
