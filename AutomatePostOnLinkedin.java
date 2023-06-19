package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class AutomatePostOnLinkedin {
    ChromeDriver driver;

    public AutomatePostOnLinkedin() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void linkedinpost() {
        System.out.println("Start Test case: linkedinpost");
        // open url https://www.linkedin.com/
        driver.get("https://in.linkedin.com/");
        // username|sendKeys"jyothisiva44@yahoo.com" Using Locator "XPath"
        // //input[@autocomplete='username'].sendKeys("jyothisiva44@yahoo.com"
        WebElement username = driver.findElementById("session_key");
        username.sendKeys("jyothisiva44@yahoo.com");
        // password|sendKeys "ramjyo@143" Using Locator "XPath"
        // //input[@autocomplete='current-password'].sendKeys("ramjyo@143")
        WebElement password = driver.findElementById("session_password");
        password.sendKeys("ramjyo@143");
        // click signin button Using Locator "XPath"
        // //button[@data-id='sign-in-form__submit-btn']
        WebElement signin = driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
        signin.click();
        // get the count of "who viewed your profile" Using Locator "XPath"
        // //strong[text()='25'].getText();
        WebElement profileViewsCount = driver
                .findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[2]/strong"));
        System.out.println(profileViewsCount.getText());
        // click on post bar Using Locator "ID" id="ember908".click();
        WebElement startPost = driver.findElement(By.xpath("//span[text()='Start a post']"));
        startPost.click();
        // sendkeys " hello everyone" Using Locator "XPath"
        // //div[@aria-placeholder='What do you want to talk about?'].sendKeys("hello
        // everyone")
        WebElement postText = driver
                .findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']"));
        postText.sendKeys("Hello Everyone");
        // click on post button Using Locator "ID" id="ember1126".click();
        WebElement postClick = driver.findElement(By.xpath("//span[text()='Post']"));
        postClick.click();
        // confirming the post Using Locator "XPath" //span[text()='Hello Everyone']
        WebElement verifyPost = driver.findElement(By.xpath("//span[text()='Hello Everyone']"));
        verifyPost.isDisplayed();
        System.out.println("end Test case: linkedinpost");
    }

}
