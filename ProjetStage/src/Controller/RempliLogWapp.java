package Controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RempliLogWapp {
    public void remplir(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver chrome = new ChromeDriver();
        WebDriver driver = chrome.drive();

        try {
            driver.get("https://web.whatsapp.com");
            Thread.sleep(3000);
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
