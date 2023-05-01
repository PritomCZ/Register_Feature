package Stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class RegisterStepdefs {
    WebDriver driver;
    @Given("user base url")
    public void userBaseUrl() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();

        // SET CHROME OPTIONS
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver; // scroll
        js.executeScript("window.scrollBy(0,350)", "");

    }

    @When("user enter {string} and {string} and {string}")
    public void userEnterFristNameAndLastNameAndEmail(String fristName, String lastName, String Email) throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("")).sendKeys(fristName);
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[2]")).sendKeys(lastName);
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[3]")).sendKeys(Email);
        
    }

    @And("also enter {string} and {string}")
    public void alsoEnterPasswordAndRepeatPassword(String Password, String repeatPassword) {
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/div[2]/input")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[4]")).sendKeys(repeatPassword);
    }

    @And("enter the register button")
    public void enterTheRegisterButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/div[3]/button[1]")).click();
    }

    @Then("user find the home page")
    public void userFindTheHomePage() {
        System.out.println("Test");
    }
}
