package streamExamples;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import graphql.Assert;
// Get the texts present in a row & then verify if a certain text "City" exists.
public class Q_CRUCIAL_Streams {
	// whole program requires improvement.
	// the following choice of locator is NOT good !. In future try a better technique if not also changing the whole webpage.
	@Test
	public void Q_StreamsTest()
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); 
		
		String wanted= "city";
		// the following choice of locator is no good !. In future try a better technique if not also changing the whole webpage.
		String first=  driver.findElement(By.xpath("((//table[@id='product'])[2]/thead/tr/th)[1]")).getText();
		String second= driver.findElement(By.xpath("((//table[@id='product'])[2]/thead/tr/th)[2]")).getText();
		String third=  driver.findElement(By.xpath("((//table[@id='product'])[2]/thead/tr/th)[3]")).getText();
		String fourth= driver.findElement(By.xpath("((//table[@id='product'])[2]/thead/tr/th)[4]")).getText();
		
		// Now, place these 4 strings in an ArrayList
		List<String> names= Arrays.asList(first, second, third, fourth);
		Boolean x= names.stream().anyMatch(s->s.equalsIgnoreCase(wanted));
		System.out.println("======");
		System.out.println(x);
		System.out.println("======");
		Assert.assertTrue(x);
		System.out.println(" the text: '" + wanted + "' exists");
	}

}
