package Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class RempliLogLin {
    public void rempli(String adrMail, String motPasse){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver chrome = new ChromeDriver();
        WebDriver driver = chrome.drive();
        try {
            driver.get("https://www.linkedin.com/login");
            Thread.sleep(3000);
            WebElement emailField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            emailField.sendKeys(adrMail);
            passwordField.sendKeys(motPasse);
            WebElement loginButton = driver.findElement(By.tagName("button"));
            loginButton.click();
//            Thread.sleep(10000);
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
