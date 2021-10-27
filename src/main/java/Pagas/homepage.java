package Pagas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage
{
    public static WebDriver driver;

    By login = By.xpath("//a[normalize-space()='Sign in']");

    public homepage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickLogin()
    {
        driver.findElement(login).click();
    }

}
