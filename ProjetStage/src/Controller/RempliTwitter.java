package Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class RempliTwitter {
    public void rempli(String adrMail, String motPasse){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver chrome = new ChromeDriver();
        WebDriver driver = chrome.drive();
        try {
            driver.get("https://twitter.com/login");
            Thread.sleep(10000);
            WebElement usernameField = driver.findElement(By.name("text"));
            usernameField.sendKeys(adrMail);
            WebElement nextButton = driver.findElement(By.xpath("//span[text()='Suivant']"));
            nextButton.click();
//            WebElement passwordField = driver.findElement(By.name("password"));
//            passwordField.sendKeys(motPasse);
//            WebElement loginButton = driver.findElement(By.xpath("//span[text()='Log in']"));
//            Thread.sleep(10000);
//            loginButton.click();
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
