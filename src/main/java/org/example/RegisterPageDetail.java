package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class RegisterPageDetail
{

    /* method created for click on element*/
    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    /*method created for type text*/
    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    /*method created for get text from element*/
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    /*method created for wait for clickable*/
    public static void waitForClickable(By by, int time)
    {
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /*method created for wait for disappear*/
    public static void waitForDisappear(By by, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf((WebElement) by));
    }

    /*method created for url to be*/
    public static void urlToBe(String url, int timeDuration)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeDuration));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    /*method created for open browser*/
    public static void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();

        driver.get("https://demo.nopcommerce.com/");/*link to reach the website*/
    }

    /*closes the currently focused window*/
    public static void closeBrowser()
    {
        driver.close();
    }
    protected static WebDriver driver;

    /*return type of method created for timestamp*/
    public static String timeStamp()
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    /*main method*/
    public static void main(String[] args)
    {
        openBrowser();

        urlToBe("https://demo.nopcommerce.com/", 10);/*url to be method called*/

        waitForClickable(By.linkText("Register"),10);/*wait for clickable method called*/

        clickOnElement(By.linkText("Register"));/*locator - by link text to find register button and click on it*/

        waitForClickable(By.name("register-button"),10);/*wait for clickable method called*/

        /*locator - by id to find gender section and choose one option*/
        clickOnElement(By.id("gender-male"));

        /*locator - by name to find firstanme field and type user detail*/
        typeText(By.name("FirstName"),"Rahul");

        /*locator - by name to find lastname field and type user detail*/
        typeText(By.name("LastName"),"Patel");

        /*locator - by id to find email field and type user detail*/
        typeText(By.id("Email"),"rahulpatel1676" + timeStamp()+ "@gmail.com");

        /*method for selecting date of birth*/
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText("10");

        /*method for selecting month */
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByIndex(7);

        /*method for selecting year */
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("1915");

        /*locator - by id to find company field and type user detail*/
        typeText(By.id("Company"),"Zenith");

        /*locator - by name to find password field and type password*/
        typeText(By.name("Password"),"rpatel@1278");

        /*locator - by id to find confirm password field and type confirm password*/
        typeText(By.id("ConfirmPassword"),"rpatel@1278");

        /*locator - by name to find register button and click on it*/
        clickOnElement(By.name("register-button"));

        String registrationMessage = getTextFromElement(By.className("result"));
        System.out.println(registrationMessage);

        waitForClickable(By.linkText("Continue"),10);/*wait for clickable method called*/

        closeBrowser();
    }

}
