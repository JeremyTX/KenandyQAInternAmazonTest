import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest  {
    public static void main(String[] args) throws InterruptedException {
        
    	//Create instance of ChromeDriver
    	System.setProperty("webdriver.chrome.driver", "src/chromedriver");
    	WebDriver driver = new ChromeDriver();
    	
        // Visit amazon home page
        driver.get("http://www.amazon.com");
        
        // Wait for the page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Finds the Search Box by its name "field-keywords"
        WebElement element = driver.findElement(By.name("field-keywords"));

        // Search for "Apple Watch"
        element.sendKeys("Apple Watch");

        // Now submit the form. 
        element.submit();
        
        // Click on the sub category "Smart Watches"
        String linkSmartWatches = "Smart Watches";
        driver.findElement(By.xpath("//span[starts-with(., \"" + linkSmartWatches + "\")]")).click();

        //Click on the "Apple Watch Sport 42mm Space Gray Aluminum Case with Black Sport Band"
        driver.findElement(By.linkText("Apple Watch Sport 42mm Space Gray Aluminum Case with Black Sport Band")).click();
      
        //Click on Customer Reviews
        driver.findElement(By.partialLinkText("customer reviews")).click();
        
        //Get Star Rating for Space Grey Watch
        WebElement spaceGreyRating = driver.findElement(By.partialLinkText("stars"));
        System.out.println(spaceGreyRating.getText());
        
        //Scroll Up
        ((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
        
        //Click on White Apple Watch
        driver.findElement(By.xpath("//img[@src='http://ecx.images-amazon.com/images/I/41HIRUV0HGL._SS36_.jpg']")).click();
        
        //Click on Customer Reviews
        driver.findElement(By.partialLinkText("customer reviews")).click();
        
        //Get Star Rating for White Watch
        WebElement whiteRating = driver.findElement(By.partialLinkText("stars"));
        System.out.println(whiteRating.getText());

        //Compares the two star ratings and prints a message if they're the same
        if (whiteRating.getText().equals(spaceGreyRating.getText())) {
        	System.out.println("The ratings are the same!");
        }
                
        //Close the Webpage	
        driver.quit();
    }
}