package aadd_cart;


import Pagas.add_t_card;
import Pagas.homepage;
import Pagas.login_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class add_to_cart_test
{
    public static WebDriver driver;
    public static homepage phome;
    public static login_page pSignIn;
    public static add_t_card add;

    @BeforeMethod
    public void testSetup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        phome =  new homepage(driver);
        pSignIn = new login_page(driver);
        add =  new add_t_card(driver);
        phome.clickLogin();
        pSignIn.typeEmail("alaatester4@gmail.com");
        pSignIn.typePassword("Asdfg987654321");
        pSignIn.clickLogin();

    }
    @AfterMethod
    public void afterMethod() {
        //driver.close();
    }

    @Test(priority = 0)
    public void log_vu_vp() throws InterruptedException {
        add.homebutclick();
        add.Blousechoise();


//        WebElement myAccount = driver.findElement(By.id("my-account"));
//        String actualProfile = myAccount.getText();  //username , date , more info .....
//        String expectedProfile ="Alaa Eid";
//        Assert.assertTrue(actualProfile.contains(expectedProfile));
//        Thread.sleep(1000);
//        System.out.println("Accepted Test : Acess To Acount Allow With Valid User And Valid Pass");

    }



}

