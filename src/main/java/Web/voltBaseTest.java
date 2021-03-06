package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Log;

public class voltBaseTest {

    @Test
    public void logIn() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/eyal/Desktop/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://tv.partner.co.il/");
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("eyalabush@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Aa123456");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/form/button")).submit();
        Thread.sleep(7000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,2000)");
//        js.executeScript("arguments[0].scrollIntoView();", "");
        WebDriverWait wait = new WebDriverWait(driver, 10);

//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vod\"]/a/div/div/span")));
//        element.click();
        Thread.sleep(3000);
        WebElement channel = driver.findElement(By.cssSelector("#tv-guide > a > div > div > span"));
        channel.click();
        Thread.sleep(5000);
        WebDriverWait Wait = new WebDriverWait(driver,10);
        Actions mousehover = new Actions(driver);
        mousehover.moveToElement(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]/div[16]"))).build().perform();
        Wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]/div[16]")))).isDisplayed();
        driver.findElement(By.cssSelector("#UwyGZ > div:nth-child(5) > i")).click();

//      WebElement e =  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div[2]/div[2]/section/div/div[1]/div/div[1]/div[2]/div/div[1]/div[2]"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(e).build().perform();
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div[2]/div[2]/section/div/div[1]/div/div[1]/div[2]/div/div[1]/div[3]")).click();
//    }

    }
}