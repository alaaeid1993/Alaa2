package Pagas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class add_t_card
{
    public static WebDriver driver;
    public static Actions  actions;



    By email= By.id("email");
    By password= By.id("passwd");
    By submitLogin= By.id("SubmitLogin");
    By homebut= By.xpath("//a[normalize-space()='Home']");
    By Blou = By.xpath("//a[normalize-space()='Blouse']");




    public add_t_card(WebDriver driver) {this.driver = driver;}

//
//    public  void typeEmail(String emailTxt) {driver.findElement(email).sendKeys(emailTxt);}
//
//    public void typePassword(String paswd) {driver.findElement(password).sendKeys(paswd);}
//
//    public void clickLogin() {driver.findElement(submitLogin).click();}

    public void homebutclick() {driver.findElement(homebut).click();}

    public void Blousechoise()
    {
       //driver.findElement(Blou).click();
       actions.moveToElement(driver.findElement(Blou));
    }

}
