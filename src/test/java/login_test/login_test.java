package login_test;

import Pagas.homepage;
import Pagas.login_page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;


public class login_test {
    public static WebDriver driver;
    public static homepage phome;
    public static login_page pSignIn;

    @BeforeMethod
    public void testSetup() throws IOException, ParseException
    {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        phome = new homepage(driver);
        pSignIn = new login_page(driver);
        phome.clickLogin();

    }

    @AfterMethod
    public void afterMethod()
    {
        driver.close();
    }

    @Test(priority = 0, dataProvider = "dp")
    public void log_vu_vp (String data) throws InterruptedException
    {
        String user[] = data.split(",");
        pSignIn.login_with_user(user[0], user[1]);
//        pSignIn.login_with_user("users[0]", "users[1]");
//        pSignIn.typeEmail("alaatester4@gmail.com");
//        pSignIn.typePassword("Asdfg987654321");
//        pSignIn.clickLogin();
        WebElement myAccount = driver.findElement(By.id("my-account"));
        String actualProfile = myAccount.getText();  //username , date , more info .....
        String expectedProfile = "Alaa Eid";
        Assert.assertTrue(actualProfile.contains(expectedProfile), "");
        Thread.sleep(1000);
        System.out.println("Accepted Test : Acess To Acount Allow With Valid User And Valid Pass");
    }

    @DataProvider(name = "dp")
    public String[] read() throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/java/Pagas/data.json"); // reader object
        Object obj = jsonParser.parse(reader);
        JSONObject userloginsobj = (JSONObject) obj;
        JSONArray userloginsarr = (JSONArray) userloginsobj.get("users");
        String arr[] = new String[userloginsarr.size()];

        for (int i = 0; i < userloginsarr.size(); i++)
        {
            JSONObject user = (JSONObject) userloginsarr.get(i);
            String usr = (String) user.get("username");
            String pwd = (String) user.get("password");

            arr[i] = usr + "," + pwd;
        }
        return arr;
    }

//     //test combinations (valid/invalid pass and username )
//    @Test(priority = 1)
//    public void log_ivu_vp() throws InterruptedException {
//        pSignIn.typeEmail("aegy2962@gmail.com");
//        pSignIn.typePassword("123456");
//        pSignIn.clickLogin();
//        //retype
//        WebElement signbut = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
//        String actualProfile = signbut.getText();
//        String expectedProfile ="Sign in";
//        Assert.assertTrue(actualProfile.contains(expectedProfile),"");
//        Thread.sleep(10000);
//        System.out.println("Accepted Test : Acess To Acount Not Allow With Invalid User And Valid Pass");
//
//    }
//
//    @Test(priority = 2)
//    public void log_vu_ivp() throws InterruptedException {
//        pSignIn.typeEmail("egy2962@gmail.com");
//        pSignIn.typePassword("1123456");
//        WebElement signbut = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
//        String actualProfile = signbut.getText();
//        String expectedProfile ="Sign in";
//        Assert.assertTrue(actualProfile.contains(expectedProfile));
//        Thread.sleep(10000);
//        System.out.println("Accepted Test : Acess To Acount Not Allow With Valid User And Invalid Pass");
//
//    }
//
//    @Test(priority = 3)
//    public void log_ivu_ivp() throws InterruptedException {
//        pSignIn.typeEmail("aegy2962@gmail.com");
//        pSignIn.typePassword("1123456");
//        WebElement signbut = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
//        String actualProfile = signbut.getText();
//        String expectedProfile ="Sign in";
//        Assert.assertTrue(actualProfile.contains(expectedProfile));
//        Thread.sleep(10000);
//        System.out.println("Accepted Test : Acess To Acount Not Allow With Invalid User And Invalid Pass");
//    }
//
//    @Test(priority = 4)
//    public void log_eu_ep() throws InterruptedException {
//        pSignIn.typeEmail("");
//        pSignIn.typePassword("");
//        WebElement signbut = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
//        String actualProfile = signbut.getText();
//        String expectedProfile ="Sign in";
//        Assert.assertTrue(actualProfile.contains(expectedProfile));
//        Thread.sleep(10000);
//        System.out.println("Accepted Test : Acess To Acount Not Allow With Empty User And Empty Pass");
//    }

}
