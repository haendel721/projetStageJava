package Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class RempliLogFb {
    public void rempli( String adrMail , String MotPasse){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver chrome = new ChromeDriver();
        WebDriver driver = chrome.drive();
        try{
            driver.get("https://www.facebook.com/");
            Thread.sleep(3000);
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.name("login"));
            emailField.sendKeys(adrMail);
            passwordField.sendKeys(MotPasse);
            loginButton.click();
//            Thread.sleep(5000);
            System.exit(0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}



