package Stepdefination;

import Testranner.Cucumberrunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
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
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver; // scroll
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(3000);
       // driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[@name=\"name\"][1]")).click();

    }

    @When("user enter {string} and {string} and {string}")
    public void userEnterFristNameAndLastNameAndEmail(String fristName,String lastName,String Email) throws InterruptedException {
       // driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[@name=\"name\"][1]")).click();
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[@name=\"name\"][1]")).sendKeys(fristName);
        driver.findElement(By.xpath("//label[text()=\"Last Name\"]/following-sibling::input[@name=\"name\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//label[text()=\"Email\"]/following-sibling::input[@type=\"text\"]")).sendKeys(Email);
        
    }

    @And("also enter {string} and {string}")
    public void alsoEnterPasswordAndRepeatPassword(String Password, String repeatPassword) {
        driver.findElement(By.xpath("//label[text()=\"Password\"]/following::input[@type=\"password\"][1]")).sendKeys(Password);
        driver.findElement(By.xpath("//label[text()=\"Repeat Password\"]/following-sibling::input[@type=\"password\"]")).sendKeys(repeatPassword);

    }

    @And("enter the register button")
    public void enterTheRegisterButton() {
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @Then("user find the home page")
    public void userFindTheHomePage() {
        System.out.println("Test");
    }
}
