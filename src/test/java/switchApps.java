//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.Activity;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//import utils.BaseTest;
//import utils.Log;
//
//import java.io.IOException;
////import utils.ReadAdbCommands;
//
//public class switchApps extends BaseTest {
//
//    public switchApps() throws IOException {
//    }
//
//    @Test
//    public void appsSwitch() throws InterruptedException {
//
//        String activity = driver.currentActivity();
//        Boolean act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
////        Thread.sleep(20000);
//        while (true) {
////            activity = driver.currentActivity();
////            act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
//
//
//            driver.startActivity(new Activity("com.nousguide.android.rbtv", "com.redbull.MainActivity"));
//            Thread.sleep(3000);
//            driver.launchApp();
//            Thread.sleep(3000);
//            driver.startActivity(new Activity("com.netflix.ninja", "com.netflix.ninja.MainActivity"));
//            Thread.sleep(3000);
//            driver.startActivity(new Activity("com.ted.android.tv", "com.ted.android.tv.view.MainActivity"));
//            Thread.sleep(8000);
//            driver.pressKeyCode(23);
//            Thread.sleep(1500);
//            driver.pressKeyCode(23);
//            Thread.sleep(1500);
//            driver.pressKeyCode(23);
//            Thread.sleep(50000);
//            driver.pressKeyCode(3);
//            Thread.sleep(3000);
//            driver.startActivity(new Activity("com.vimeo.android.videoapp", "com.vimeo.android.videoapp.core.MainActivity"));
//            Thread.sleep(3000);
//            driver.pressKeyCode(23);
//            Thread.sleep(1500);
//            driver.pressKeyCode(23);
//            Thread.sleep(50000);
//            driver.startActivity(new Activity("com.google.android.youtube.tv", "com.google.android.apps.youtube.tv.activity.MainActivity"));
//            Thread.sleep(3000);
//
//        }
//    }
//}