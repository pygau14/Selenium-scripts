
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class swagLabs {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/pygau14/eclipse-workspace/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        //Open Flipkart URL
        driver.get("https://www.saucedemo.com/");
    }
//	
    
    @Test(priority=1)
    public void testLogin() {
        
    	// selecting the email text field and entering the username
    	WebElement emailfield = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
    	emailfield.click();
    	emailfield.clear();
    	emailfield.sendKeys("standard_user");
    	
    	 try {
             Thread.sleep(5000); // Sleep for 5 seconds
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	 
    	 //selecting the password text field and entering the password
    	 WebElement passwordfield = driver.findElement(By.xpath("//*[@id=\"password\"]"));
    	 passwordfield.click();
    	 passwordfield.clear();
    	 passwordfield.sendKeys("secret_sauce");
    	 
    	 //clicking on login button
    	 WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
    	 loginbutton.click();
    	 
    	 
    	 try {
             Thread.sleep(5000); // Sleep for 5 seconds
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	 
    	 // Assert "Products" text is displayed
         WebElement productsText = driver.findElement(By.xpath("//span[@class='title' and text()='Products']"));
    	 Assert.assertEquals(productsText.getText(),"Products","Test case failed");
    	 
    	// Locate the dropdown element
         WebElement dropdownElement = driver.findElement(By.className("product_sort_container"));
         
         // Create a list of expected option values
         List<String> expectedOptions = new ArrayList<>();
         expectedOptions.add("Name (A to Z)");
         expectedOptions.add("Name (Z to A)");
         expectedOptions.add("Price (low to high)");
         expectedOptions.add("Price (high to low)");
         
         // Create a Select object with the dropdown element
         Select dropdown = new Select(dropdownElement);

         // Get all available options
         List<WebElement> options = dropdown.getOptions();
         
         // Assert each option value
         for (int i = 0; i < options.size(); i++) {
             String actualOption = options.get(i).getText();
             String expectedOption = expectedOptions.get(i);
             Assert.assertEquals(actualOption, expectedOption, "Option value mismatch at index " + i);
         }
         
         
         WebElement addtoCartBtn = driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]"));
         addtoCartBtn.click();
         
         
         try {
             Thread.sleep(5000); // Sleep for 5 seconds
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	 
    }
    


    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
