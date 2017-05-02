package Waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class Implicitwait {
	
	public static WebDriver driver;
	public static final int WAIT_TIME = 60;
    public static void main(String[] args) {

    	 String url= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
 		 
		    System.setProperty("webdriver.chrome.driver",url); 
		   
		    driver=new ChromeDriver(); 
		//Implicit();
		//Explicit();
		//fluent() ;
		Webdriverwait();
		  }
    
    public static void  Explicit()
    {
        driver.get("http://the-internet.herokuapp.com/hovers");
    	WebElement myDynamicElement = (new WebDriverWait(driver, 60))
    			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='content1']/div/div[3]/img")));
    		
    	
    	
    }
    public static void  Implicit(){
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://the-internet.herokuapp.com/hovers");
    	WebElement myDynamicElement = driver.findElement(By.xpath(".//*[@id='content1']/div/div[3]/img"));
    		
    	
    	
    }
    @SuppressWarnings("rawtypes")
	
    private static WebElement fluent() {
    	
    	
    	driver.get("http://the-internet.herokuapp.com/hovers");
    	
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(100, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath(".//*[@id='content1']/div/div[3]/img"));
            }
        }); 
    }
    public static ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
    	return new ExpectedCondition<WebElement>() {
    	public WebElement apply(WebDriver driver) {
    	WebElement element = driver.findElement(by);
    	return element.isDisplayed() ? element : null;
    	}
    	};
    	}
    private static void Webdriverwait()
    {
    	driver.get("http://the-internet.herokuapp.com/hovers");
    	Wait<WebDriver> wait = new WebDriverWait(driver, 20);
    	WebElement element = wait.until(visibilityOfElementLocated(By.xpath(".//*[@id='content1']/div/div[3]/img")));
    }
}
