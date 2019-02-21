package utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestNetflix {
    public AndroidDriver driver;
    public WebDriverWait wait;
    public String version = " 2.29.8 ifs גירסת ממיר 77 וגירסת ";
    public String ifspackageName = "com.ifeelsmart.smartui";
    public String Eyal = "eyal.avramchik@partner.co.il";
    public String Michael = "Michael.skali1@partner.co.il";
    String Shlomi = "shlomi.mor4@partner.co.il";
    public DesiredCapabilities cap = new DesiredCapabilities();
    BaseTest baseTest = new BaseTest();

//    static AppiumDriverLocalService service;

//    public BaseTest() throws IOException {
//    }

    //"appPackage","appActivity",
    @Parameters({"Name", "appPackage", "appActivity", "port", "deviceName", "platformVersion", "AdbLog", "udid", "bpPort", "ip"})
    //Parameters that reads from testng.xml
    @BeforeClass
    public void Capabilities(String Name, String appPackage, String appActivity, String port, String deviceName, String platformVersion, String AdbLog, String udid, String bpPort, String ip) throws Exception {
        cap.setCapability("deviceName", deviceName);
        cap.setCapability("udid", udid);
        cap.setCapability("port", port);
        cap.setCapability("bpPort", bpPort);
        cap.setCapability("appPackage", appPackage);
        cap.setCapability("appActivity", appActivity);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability("ip", ip);
        cap.setCapability("Name", Name);
        cap.setCapability("newCommandTimeout", 4300);
        killNetflix(ip);
        baseTest.cmd(port);
        baseTest.checkDevices();
        AppiumServer server = new AppiumServer();
        server.AppiumServer(port, bpPort, Name);
        Log.info(" --- נטפליקס נפתחת בממיר של  --- " + deviceName);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:" + port + "/wd/hub"), cap);
        baseTest.logCat(ip);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterclass() {
    }

    public void killNetflix(String ip) throws IOException {
        try {
            CommandLine cmd = new CommandLine("adb");
            CommandLine cmd1 = new CommandLine("adb");
            cmd.addArgument("-s").addArgument(ip, false).addArgument("shell", false).addArgument("\"kill $(pidof com.netflix.ninja)\"", false);
            DefaultExecutor exec = new DefaultExecutor();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(cmd);
            Log.info("Closing Netflix app from the background, please wait...");
        } catch
        (Exception ignore) {
            System.out.println(ignore);
        }
    }
}