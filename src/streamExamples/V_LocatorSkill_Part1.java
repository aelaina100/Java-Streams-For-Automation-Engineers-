package streamExamples;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
                              // Pre-requisit to X_Streams_FilteringWebTable.java
// Simply and STRICTLY read line by line and observe.
public class V_LocatorSkill_Part1 {
	// You have a disabled button (unclickable).
	// clicking on it, should return an exception.

@Test
public void W_LocatorSkillTest() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver_104.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
	//Follow the instructions:
	// 1- Click on button 'Next'
	Thread.sleep(3000L);
	driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
	
	// 2- Now, click on button '4'
	Thread.sleep(3000L);
	driver.findElement(By.xpath("//span[text()='4']")).click();
	
	// 3- Now- Click on button 'Next'
	Thread.sleep(3000L);
	driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
	// This line shoudl throw an exception as it is simply not clickable:
	//It can be identfified with  findElement(By.cssSelector("a[aria-label='Next']")) but
	// but the .click() part throws an exception because the button is not clickable at this stage
	// Exception is:-->
	//org.openqa.selenium.ElementClickInterceptedException: element click intercepted:
	//Element <a role="button" href="#" tabindex="0" aria-disabled="true" aria-label="Next">...</a> is not clickable at point (1133, 135)
	
	// Testcase: after step #1 and #2, ensure that 'Next' button is not clickable. Solved in the next example: X_LocatorSkill_part2
}

}
