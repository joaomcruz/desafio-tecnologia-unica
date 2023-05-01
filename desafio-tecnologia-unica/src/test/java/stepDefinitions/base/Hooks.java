package stepDefinitions.base;

import Driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Timestamp;

import static Driver.DriverFactory.cleanupDriver;
import static Driver.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setup() {
        getDriver();
    }


    @After
    public void tearDown() {

        cleanupDriver();
    }
}