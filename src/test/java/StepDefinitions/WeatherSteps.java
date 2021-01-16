package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WeatherSteps {

    WebDriver driver=null;

    @Given("user is navigate to weather home page")
    public void user_is_navigate_to_weather_home_page() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        String projectPath = System.getProperty("user.dir");
        System.out.println("Prject path is " +projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://www.weather.gov.sg/home/");

        System.out.println("Home page is loaded successfully");
    }

    @When("user select four day outlook page")
    public void user_select_four_day_outlook_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        driver.findElement(By.xpath("//header/div[1]/nav[1]/ul[1]/li[1]/a[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'2-hr Nowcast')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//body/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
        System.out.println("Perform navigation is successfully completed");

    }

    @Then("user read weather details")
    public void user_read_weather_details() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        String lowTemp = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/span[1]")).getText();

        System.out.println("Low temperature is " +lowTemp);

    }

}
