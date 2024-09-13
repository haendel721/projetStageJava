package Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class RempliLogInstagram {
    public void remplir(String adrMail , String motPasse){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver chrome = new ChromeDriver();
        WebDriver driver = chrome.drive();
        try {
            driver.get("https://www.instagram.com/accounts/login/");
            Thread.sleep(3000);
            WebElement usernameField = driver.findElement(By.cssSelector("input[type='text']"));
            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
//            class="_aa4b _add6 _ac4d _ap35"
            usernameField.sendKeys(adrMail);
            passwordField.sendKeys(motPasse);
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
//            Thread.sleep(10000);
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
