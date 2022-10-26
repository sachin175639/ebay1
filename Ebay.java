package ebay_practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ebay {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sachin B\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		
		WebElement electronics = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		WebElement cellphone = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[1]/a"));
		
		
		Actions act= new Actions(driver);
		act.moveToElement(electronics).build().perform();
		Thread.sleep(3000);
		act.moveToElement(cellphone).click().build().perform();
		Thread.sleep(3000);
		WebElement pa = driver.findElement(By.xpath("//*[@id=\"s0-17-12_2-0-1[0]-0-0\"]/ul/li[3]/a"));
		act.moveToElement(pa).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/section[1]/div[1]/div[2]/button/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"c3-mainPanel-Screen%20Size\"]/span")).click();
		driver.findElement(By.id("c3-subPanel-Screen%20Size_4.0%20-%204.4%20in_cbx")).click();
		driver.findElement(By.xpath("//*[@id=\"c3-mainPanel-price\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[1]/div/input")).sendKeys("12");
		driver.findElement(By.xpath("//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[2]/div/input")).sendKeys("13");
		driver.findElement(By.xpath("//*[@id=\"c3-mainPanel-location\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"c3-subPanel-location_Worldwide\"]/span/span/input")).click();
		driver.findElement(By.xpath("//*[@id=\"x-overlay__form\"]/div[3]/div[2]/button")).click();
		String x = driver.findElement(By.xpath("//*[@id=\"s0-28_1-9-0-1[0]-0-0-6-5-4[0]-flyout\"]/button/span")).getText();
	
		
		String actual = "3 filters applied";
		
		if (x.equals(actual)) {
			System.out.println("3 filters are applied");
		}else {
			System.out.println("filters not applied");
		}
		}

}
