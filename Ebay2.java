package ebay_practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sachin B\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		
		//Search string in the search bar
		String name = "macbook";
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys(name);
		Thread.sleep(3000);
	
		
		//Changing the search categary\
		driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).click();
		Thread.sleep(3000);
		for (int i=10; i>=0; i--) {
			driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).sendKeys(Keys.ARROW_DOWN);	
		}
		driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).sendKeys(Keys.ENTER);
		
		//clicking search bar
		driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[3]/input")).click();
		
		
		//verifying page loaded completely
		String expected = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=macbook&_sacat=58058";
		String actual = driver.getCurrentUrl();
	
		if (expected.equals(actual)) {
			System.out.println("page loaded successfully");
			
		}else {
			System.out.println("page loading failed");
		}
		
		//verifying first name matches with search string
		String x = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1/span[2]")).getText();
		
		if (name.equals(x)) {
			System.out.println("name matched with search string");
		}else {
			System.out.println("not matched with search string");
		}
	}

}
