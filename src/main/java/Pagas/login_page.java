package Pagas;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class login_page
{
    public static WebDriver driver;
    By email= By.id("email");
    By password= By.id("passwd");
    By submitLogin= By.id("SubmitLogin");



    public login_page(WebDriver driver) {
        this.driver = driver;
    }

    public  void typeEmail(String emailTxt)
    {
        driver.findElement(email).sendKeys(emailTxt);
    }

    public void typePassword(String pswd)
    {
        driver.findElement(password).sendKeys(pswd);
    }

    public void clickLogin()
    {
        driver.findElement(submitLogin).click();
    }

    public void login_with_user(String user, String pas)
    {
        typeEmail(user);
        typePassword(pas);
        clickLogin();
    }




}
