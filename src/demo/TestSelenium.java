package demo;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class TestSelenium {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		((RemoteWebDriver)driver).setLogLevel(Level.ALL);
		driver.manage().window().maximize();
		driver.get("http://demo.opencart.com/");
		
		driver.findElement(By.xpath("//*[@id='currency']/div/button")).click();
		driver.findElement(By.name("GBP")).click();
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
		
		driver.findElement(By.name("search")).sendKeys("iPod");
		
		fluentWait(By.xpath("//*[@id='search']/span/button"), driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search']/span/button")));
		
		driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
		
	
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement comparisonButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[4]/div[1]/div/div[3]/button[3]")));
		
		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[1]/div/div[3]/button[3]")).click();
		
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		WebElement comparisonButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[4]/div[2]/div/div[3]/button[3]")));
		
		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[2]/div/div[3]/button[3]")).click();
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		WebElement comparisonButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[4]/div[3]/div/div[3]/button[3]")));
		
		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[3]/div/div[3]/button[3]")).click();
		
		
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		WebElement comparisonButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[4]/div[4]/div/div[3]/button[3]")));
		
		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[4]/div/div[3]/button[3]")).click();
		
		
		fluentWait(By.id("compare-total"), driver);
		
		driver.findElement(By.id("compare-total")).click();
		
		driver.findElement(By.xpath("//*[@id='content']/table/tbody[2]/tr/td[2]/a")).click();
		
		Random random = new Random();
		
		int nextInt = random.nextInt(3);
		
		driver.findElements(By.cssSelector("input.btn-primary")).get(nextInt).click();
		
		
		//String price = driver.findElements(By.xpath("//*[@id='content']/table/tbody[1]/tr[3]")).get(nextInt).getText();
		
		//driver.findElement(By.xpath("//*[@id='cart']/button")).click();
		
		
		
		

	}
	public static WebElement fluentWait(final By locator, WebDriver driver ) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    });

	    return  foo;
	};
	
	
	
	
	
	
}
