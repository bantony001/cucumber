package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest{    	
    WebDriver driver;
    
    @Given("^the user is in facebook page$")
    public void the_user_is_in_facebook_page() throws Throwable {
    	System.setProperty("webdriver.chrome.driver","C:\\Studies\\Tools\\Selenium\\jar\\chromedriver\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("https://www.facebook.com/");
    }

    @When("^the user enters \"(.*?)\" and \"(.*?)\"$")
    public void the_user_enters_and(String userName, String password) throws Throwable {
    	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(userName);
    	driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(password);
    	Thread.sleep(5000);
    }

    @Then("^the user should be able to close the screen\\.$")
    public void the_user_should_be_able_to_close_the_screen() throws Throwable {
    	driver.close();
    	Thread.sleep(5000);
    }
    
    @When("^the user enters the credentials$")
    public void the_user_enters_the_credentials(DataTable usercredentials) throws Throwable { 
    	List<List<String>> data = usercredentials.raw();
        driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(data.get(0).get(0)); 
        driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(data.get(0).get(1));
    }
    
    @When("^the user enters the user credentials$")
    public void the_user_enters_the_user_credentials(DataTable usercredentials) throws Throwable {
    	List<Map<String, String>> data= usercredentials.asMaps(String.class, String.class);
        driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(data.get(0).get("UserName")); 
        driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(data.get(0).get("Password"));
        Thread.sleep(5000);
    }
}
