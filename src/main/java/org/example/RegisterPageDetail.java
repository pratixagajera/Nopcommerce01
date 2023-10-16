package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterPageDetail
{
    protected static WebDriver driver;

    public static void main(String[] args)/*main method*/
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();

        /*link to reach the website*/
        driver.get("https://demo.nopcommerce.com/");

        /*locator - by link text to find register button and click on it*/
        driver.findElement(By.linkText("Register")).click();

        /*locator - by id to find gender section and choose one option*/
        driver.findElement(By.id("gender-male")).click();

        /*locator - by name to find firstanme field and type user detail*/
        driver.findElement(By.name("FirstName")).sendKeys("Rahul");

        /*locator - by name to find lastname field and type user detail*/
        driver.findElement(By.name("LastName")).sendKeys("Patel");

        /*locator - by id to find email field and type user detail*/
        driver.findElement(By.id("Email")).sendKeys("rahulpatel1676@gmail.com");

        /*locator - by id to find company field and type user detail*/
        driver.findElement(By.id("Company")).sendKeys("Zenith");

        /*locator - by name to find password field and type password*/
        driver.findElement(By.name("Password")).sendKeys("rpatel@1278");

        /*locator - by id to find confirm password field and type confirm password*/
        driver.findElement(By.id("ConfirmPassword")).sendKeys("rpatel@1278");

        /*locator - by name to find register button and click on it*/
        driver.findElement(By.name("register-button")).click();

        driver.close();/*closes the currently focused window*/
    }

}
