package utils.FactoryClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class keyCode {
    private AndroidDriver driver;
    public keyCode(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void Forward() throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.MEDIA_FAST_FORWARD));
        Log.info("Forward 20 seconds");
        Thread.sleep(1500);
    }
    public void Rewind() throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
        Log.info("Rewind 20 seconds");
        Thread.sleep(1500);
    }
    public void OK()throws InterruptedException{
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Log.info("OK button pressed");
        Thread.sleep(1500);
    }
}
