package utils.FactoryClasses;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;
import utils.Log;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class keyCode {



    public AndroidDriver driver;

    public keyCode(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void Forward() throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.FORWARD));
        Log.info("Forward 20 seconds");
        Thread.sleep(1500);
    }

    public void Rewind() throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
        Log.info("Rewind 20 seconds");
        Thread.sleep(1500);
    }

    public void OK() throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        Log.info("OK button pressed");
        Thread.sleep(1500);
    }
    public void playPause() throws InterruptedException {
        driver.pressKey(new KeyEvent(AndroidKey.MEDIA_PLAY_PAUSE));
        Log.info("Play / Pause button pressed");
        Thread.sleep(1500);
    }

    public String playerState(String deviceName) throws InterruptedException, IOException {
        BaseTest b = new BaseTest();
        List<String> adb = Arrays.asList("");
        List<String> adb1 = Arrays.asList("");
        List<String> adb2 = Arrays.asList("");
        List<String> adb3 = Arrays.asList("");
        List<String> adb4 = Arrays.asList("");
        boolean live = Boolean.parseBoolean(null);
        try {
            Map<String, Object> ADB = ImmutableMap.of("command", "logcat -d", "args", adb);
            String AA = (String) this.driver.executeScript("mobile: shell", ADB);
            live = AA.contains("Player is buffering");
            if (AA.contains("Player is paused")) {
                b.takeScreenShot();
                Map<String, Object> AD = ImmutableMap.of("command", "logcat -d |grep 'Player is paused'", "args", adb1);
                String pause = (String) this.driver.executeScript("mobile: shell", AD);
                Log.info("********** Player is paused ********** " + deviceName + "'s STB:  " + pause);
                Thread.sleep(1500);
            } else if (AA.contains("Player is resumed")) {
                b.takeScreenShot();
                Map<String, Object> AD = ImmutableMap.of("command", "logcat -d |grep 'Player is resumed'", "args", adb2);
                String pause = (String) this.driver.executeScript("mobile: shell", AD);
                Log.info("********** Player is Resumed ********** " + deviceName + "'s STB:  " + pause);
                Thread.sleep(1500);
            } else if (AA.contains("Player is buffering")) {
                b.takeScreenShot();
                Map<String, Object> AD = ImmutableMap.of("command", "logcat -d |grep 'Player is buffering'", "args", adb3);
                String pause = (String) this.driver.executeScript("mobile: shell", AD);
                Log.info("********** Player is Live ********** " + deviceName + "'s STB:  " + pause);
                Thread.sleep(1500);
            }
            Map<String, Object> clearLogcat = ImmutableMap.of("command", "logcat -c", "args", adb4);
            this.driver.executeScript("mobile: shell", clearLogcat);
        } catch (Exception ignore) {

        }
        return String.valueOf(live);
    }
}
