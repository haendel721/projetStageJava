package Controller;

import org.openqa.selenium.WebDriver;

public class ChromeDriver {
    public WebDriver drive(){
        System.setProperty("webdriver.chrome.driver", "D:/Stage/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
        return driver;
    }
}
