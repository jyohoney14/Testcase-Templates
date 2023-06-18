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

public class SearchAmazon {
    ChromeDriver driver;

    public SearchAmazon() {
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

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        // Navigate to url https://www.google.com/
        driver.get("https://www.google.com/");
        // Locate search field Using Locator "ID" id="APjFqb"
        WebElement searchBox = driver.findElementById("APjFqb");
        // sendKeys "amazon" Using Locator "XPath"
        // textarea[@id='APjFqb'].sendKeys("amazon")
        searchBox.sendKeys("amazon");
        // click on google search button Using Locator "XPath"
        // div[@class='lJ9FBc']/center/input[1]
        WebElement googleSearchButton = driver.findElement(By.xpath("//div[@class='lJ9FBc']/center/input[1]"));
        googleSearchButton.click();
        // validate search results Using Locator "XPath" //h3[text()='Amazon.in']
        WebElement valText = driver.findElement(By.xpath("//h3[text()='Amazon.in']"));
        System.out.println("Amazon search results displayed" + valText.isDisplayed());
        System.out.println("end Test case: testCase01");
    }

}
