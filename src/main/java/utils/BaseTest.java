package utils;
import ch.ethz.ssh2.StreamGobbler;
import com.google.common.collect.ImmutableMap;
import com.sun.mail.imap.protocol.Item;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.codec.binary.Base64;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.imagecomparison.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.netty.handler.codec.base64.Base64Encoder;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.FactoryClasses.keyCode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Pattern;


import javax.imageio.ImageIO;

import static org.apache.tools.ant.taskdefs.Antlib.TAG;
import static org.testng.Assert.*;

public class BaseTest {
    public AndroidDriver driver;
    public WebDriverWait wait;
    public String version = " 2.29.8 ifs גירסת ממיר 77 וגירסת ";
    public String ifspackageName = "com.ifeelsmart.smartui";
    public String Eyal = "eyal.avramchik@partner.co.il";
    public String Michael = "Michael.skali1@partner.co.il";
    String Shlomi = "shlomi.mor4@partner.co.il";
    public DesiredCapabilities cap = new DesiredCapabilities();

//    public Logger log = LogManager.getLogger(BaseTest.class);


//    public BaseTest() throws IOException {
//    }


    @Parameters({"Name", "appPackage", "appActivity", "port", "deviceName", "platformVersion", "udid", "bpPort", "ip"})
    //Parameters that reads from testng.xml
    @BeforeClass
    public void Capabilities(String Name, String appActivity, String appPackage, String port, String deviceName, String platformVersion, String udid, String bpPort, String ip) throws Exception {
        cap.setCapability("deviceName", deviceName);
        cap.setCapability("Name", Name);
        cap.setCapability("udid", udid);
        cap.setCapability("port", port);
        cap.setCapability("bpPort", bpPort);
//        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("allowInvisibleElements",true);
        cap.setCapability("appPackage", appPackage);
        cap.setCapability("appActivity", appActivity);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability("ignoreUnimportantViews ", true);
        cap.setCapability("skipDeviceInitialization", true);
        cap.setCapability("skipServerInstallation", true);
        cap.setCapability("ip", ip);
//        KillAppium(port);
//        cap.setCapability("deviceReadyTimeout", 30);
//        getRefreashRate(ip, deviceName);
//        killifs(ip); // //kill the ifs app before starting the session,No clear cache or data, works only with root and debug FW
//        checkDevices();
        AppiumServer server = new AppiumServer();
        server.AppiumServer(port, bpPort, Name);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:" + port + "/wd/hub"), cap);


//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        Thread thread = new Thread(new Runnable() {
            public void run() {
                String packageName = driver.getCurrentPackage();
                Boolean pac = packageName.equals("com.ifeelsmart.smartui");
                while (pac) {
                    packageName = driver.getCurrentPackage();
                    pac = packageName.equals("com.ifeelsmart.smartui");
//                    openSTB();
                    try {
                    DRM(ip);
//                        memoryTest(ip,deviceName);
//                   logCatLinux(ip);
//                        pingSent(ip);
                    } catch (Exception ignore) {
                        Log.info(ignore.getMessage());
                    }
                }
                takeScreenShot();
                try {
                    logCatLinux(ip);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Runtime rt = Runtime.getRuntime();
                try {
                    readLogcat();
//                            deleteShlomiLogcat();
//                            rt.exec("taskkill " + logcat);
//                            logcat.isAlive();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    List<String> adb2 = Arrays.asList("");
                    Map<String, Object> ADB = ImmutableMap.of("command", "logcat -t 20000 | grep com.ifeelsmart.smartui", "args", adb2);

                    String as = (String) driver.executeScript("mobile: shell", ADB);
                    Log.info(" Partner tv is not running in the front, Only package: " + packageName);
//                SendEmail.sendmail(as, "eyal.avramchik@partner.co.il", "IFS Just crashed !");
//                SendEmail.sendmail(as, "shlomi.mor4@partner.co.il", "IFS Just crashed !");
                    if (as.contains("FATAL")) {
                        Log.info("FATAL EXCEPTION");
//                    service.stop();
                    } else
                        Log.info("No FATAL EXCEPTIONS found in the log file...");
//                service.stop();
                } catch (Exception ignore) {
                    Log.info(ignore.getMessage());
                }
            }
        });
        thread.start();

//        String x = driver.getCapabilities().getCapability("deviceName").toString();
//        String y = (driver.getSessionDetails()).toString();
//        Log.info(deviceName);
//        }

    }


    @AfterClass
    public void after() {

    }

    @AfterTest
    public void afterTest() {

    }

    public void openSTB() {
        try {
            List<String> lsArgs = Arrays.asList("");
            List<String> lsArgs2 = Arrays.asList("");
            Map<String, Object> lsCmd = ImmutableMap.of("command", "dumpsys power | grep state=", "args", lsArgs);
            String lsOutput = (String) driver.executeScript("mobile: shell", lsCmd);
            if (lsOutput.contains("OFF")) {
                Log.info("The STB is closed ... Opening the STB... ");
                Map<String, Object> OFF = ImmutableMap.of("command", "input keyevent 26", "args", lsArgs2);
                String state = (String) driver.executeScript("mobile: shell", OFF);
            }


            if (lsOutput.contains("ON")) {

            }
//        } else {
//            Log.info("STB is off, Opening STB, please wait a moment ...");
//            Map<String, Object> openscreen = ImmutableMap.of("command", "input keyevent 26", "args", lsArgs);
//            String OpenScreen = (String) driver.executeScript("mobile: shell", openscreen);
//            Log.info(OpenScreen);
        } catch (Exception ignore) {
            Log.info(ignore.getMessage());
        }
    }

    public void read(String FILENAME) {
//        final String FILENAME = "C:\\Selenium\\Eyal\\eyal.txt";


        BufferedReader br = null;
        FileReader fr = null;
        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            int printCount = 0; // Counter to count from 0 to 9 for printing 10 lines.
            boolean foundFatal = false; // Boolean variable to know when we found the fatal.

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.contains("Fatal signal") || (sCurrentLine.contains("FATAL EXCEPTION"))) {
                    foundFatal = true; // We found the fatal exception. No need to continue and search for another.
                }
                if (printCount == 9) { // If we reached a counter of 9 we just finished printing 10 lines.
                }
                if (foundFatal) {
                    // We found the fatal. Print a line and start counting up to 10 lines.
                    Log.info(sCurrentLine);
                    //SendEmail.sendmail(sCurrentLine, "eyal.avramchik@partner.co.il", "FATAL EXCEPTION !!!!!!");
                    printCount++;
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    @Parameters({"deviceName"})
    public String monitorErrors(String deviceName, String ip) {


//        capabilities.setCapability("deviceName", deviceName);
        List<String> adb = Arrays.asList("");
        List<String> adb1 = Arrays.asList("");
        List<String> adb2 = Arrays.asList("");
        List<String> adb3 = Arrays.asList("");
        List<String> adb4 = Arrays.asList("");
        List<String> adb5 = Arrays.asList("");
        List<String> adb6 = Arrays.asList("");
        List<String> adb7 = Arrays.asList("");
        List<String> adb8 = Arrays.asList("");
        List<String> adb9 = Arrays.asList("");
        List<String> adb10 = Arrays.asList("");
        try {
            Map<String, Object> ADB = ImmutableMap.of("command", "logcat -d |grep 'DRM'", "args", adb);
            String AA = (String) this.driver.executeScript("mobile: shell", ADB);
            driver.pressKey(new KeyEvent(AndroidKey.CHANNEL_UP));
            Log.info("--- Zapping up ---");
            Thread.sleep(4000);
//            if (AA.contains("teardown/3002")) {
//                takeScreenShot();
//                Map<String, Object> AD = ImmutableMap.of("command", "logcat -d |grep 'teardown/3002'", "args", adb1);
//                String teardown = (String) this.driver.executeScript("mobile: shell", AD);
//                Log.info("********** Decoding error from ********** " + deviceName + "'s STB:  " + teardown);
//                logCatLinux(ip);
//                SendEmail.sendmail(teardown, Eyal, "Decoding Error is catched right now");
//                Thread.sleep(60000);
//                Log.info("Wait 60 seconds before retry mannually");
//            } if (AA.contains("error_code:#PBA")) {
//                takeScreenShot();
//                Map<String, Object> PBA = ImmutableMap.of("command", "logcat -d |grep 'error_code:#PBA'", "args", adb3);
//                String pbaerror = (String) this.driver.executeScript("mobile: shell", PBA);
//                Log.info("********** PBA Error ********** " + pbaerror);
//                logCatLinux(ip);
////                SendEmail.sendmail(pbaerror, "eyal.avramchik@partner.co.il", "PBA Error");
//                Thread.sleep(60000);
//                Log.info("Wait 60 seconds before retry mannually");
//
//            } else if (AA.contains("IFS_RESULT_HOST")) {
//                //press ok button to see the mini epg info
//                takeScreenShot();
//                Map<String, Object> DECODING = ImmutableMap.of("command", "logcat -d|grep 'IFS_RESULT_HOST'", "args", adb4);
//                String blackscreen = (String) this.driver.executeScript("mobile: shell", DECODING);
//                Log.info("********** SC error ********** " + blackscreen);
//                logCatLinux(ip);
//                Thread.sleep(60000);
//                Log.info("Wait 60 seconds before retry mannually");
////                SendEmail.sendmail(blackscreen, "eyal.avramchik@partner.co.il", "SC Error");
//            } else if (AA.contains("fatal")) {
//                takeScreenShot();
//                Map<String, Object> COACH = ImmutableMap.of("command", "logcat -d|grep 'fatal'", "args", adb5);
//                String fatal = (String) this.driver.executeScript("mobile: shell", COACH);
//                Log.info("********** fatal catched ********** " + fatal);
//                logCatLinux(ip);
//                Thread.sleep(60000);
//                Log.info("Wait 60 seconds before retry mannually");
//                Map<String, Object> clearLogcat2 = ImmutableMap.of("command", "logcat -c", "args", adb10);
//                this.driver.executeScript("mobile: shell", clearLogcat2);
//            }
            if (AA != null) {
                Log.info(AA);
                takeScreenShot();
                Log.info("First screenshot");
                Log.info("DRM Error catched");
                logCatLinux(ip);
                Thread.sleep(60000);
                Log.info("Wait 60 seconds before retry mannually");
                takeScreenShot();
                Log.info("Second screenshot after 60 seconds");
                Map<String, Object> clearLogcat2 = ImmutableMap.of("command", "logcat -c", "args", adb10);
                this.driver.executeScript("mobile: shell", clearLogcat2);
            }
//            if (AA.contains("Player is paused")) {
////                Map<String, Object> gg = ImmutableMap.of("command", "logcat -d |grep 'Player is paused'", "args", adb8);
////                String pause = (String) this.driver.executeScript("mobile: shell", gg);
//                Log.info("********** Player is paused ********** " + deviceName + "'s STB:  ");
//            } else if (AA.contains("Player is resumed")) {
////                Map<String, Object> bb = ImmutableMap.of("command", "logcat -d |grep 'Player is resumed'", "args", adb9);
////                String pause1 = (String) this.driver.executeScript("mobile: shell", bb);
//                Log.info("********** Player is Resumed ********** " + deviceName + "'s STB:  ");
//            } else if (AA.contains("exoPlayer is buffering")) {
////                Map<String, Object> cc = ImmutableMap.of("command", "logcat -d |grep 'Player is buffering'", "args", adb10);
////                String pause2 = (String) this.driver.executeScript("mobile: shell", cc);
//                Log.info("********** Player is Live ********** " + deviceName + "'s STB:  ");
//            }
        } catch (Exception ignore) {
        }
        return deviceName;
    }

    public void pingSent(String ip) {

        List<String> ping = Arrays.asList("");
        List<String> gate = Arrays.asList("");
        Map<String, Object> DNS = ImmutableMap.of("command", "ping -c1 80.179.52.100 | grep packets", "args", ping);
        String result = (String) this.driver.executeScript("mobile: shell", DNS);
        Map<String, Object> GATE = ImmutableMap.of("command", "ping -c1 80.179.52.100 | grep packets", "args", gate);
        String def = (String) this.driver.executeScript("mobile: shell", GATE);
        if (result.contains("0 received")) {
            Log.info("Ping Fails !!!!!!!!!!!!!!!!!!!!!!!!!!!!!Ping Fails!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Ping Fails!!!!!!!!!!!!!!!!!!!!!!!!!!Ping Fails " + result + ip);
            takeScreenShot();
            SendEmail.sendmail(result, "eyal.avramchik@partner.co.il", "Ping fails in Eyal automation !!");
        } else if (def.contains("0 received")) {
            Log.info("Default Gateway Ping Fails !!!!!!!!!!!!!!!!!!!!!!!!!!!!! Default Gateway Ping Fails !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Default Gateway Ping Fails !!!!!!!!!!!!!!!!!!!!!!!!!! Default Gateway Ping Fails " + def);
            takeScreenShot();
            SendEmail.sendmail(result, "eyal.avramchik@partner.co.il", "Default Gateway Ping Fails in Eyal automation !!");
        }
    }

    public void PBA() {
        List<String> pba = Arrays.asList("");
        try {
            Map<String, Object> PBAerror = ImmutableMap.of("command", "logcat -d | grep  'IFS_RESULT_HOST'", "args", pba);
            String AA = (String) this.driver.executeScript("mobile: shell", PBAerror);

            if (AA.contains("IFS_RESULT_HOST")) {
                driver.pressKeyCode(23);
                takeScreenShot();
                Log.info(AA);
//                SendEmail.sendmail(AA, Eyal, "Black screen catched !!");

                List<String> adb1 = Arrays.asList("");
                Map<String, Object> ADB2 = ImmutableMap.of("command", "logcat -c", "args", adb1);//clear the logcat and get new lines
                String bb = (String) this.driver.executeScript("mobile: shell", ADB2);
            }
        } catch (Exception ignore) {
        }

    }

    public void takeScreenShot() {

        // Set folder name to store screenshots.
        String destDir = "screenshots";

        // Capture screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Log.info("Screensot is captured");

        // Set date format to set It as screenshot file name.
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        // Create folder under project with name "screenshots" provided to destDir.
        new File(destDir).mkdirs();

        // Set file name using current date time.
        String destFile = date.format(new Date()) + ".png";
        try {
            // Copy paste file at destination folder location
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
            Log.info("Screenshot added to the folder");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void p() {
//        try {
//            Process pr = Runtime.getRuntime().exec("adb" + " logcat -d");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//            StringBuilder log = new StringBuilder();
//            String line = "";
//            while ((line = bufferedReader.readLine()) != null) {
//                log.append(line);
//               Log.info(log.toString());
//            }
//        } catch (IOException e){}
//    }

    public String getIfsPid() {

        List<String> pid = Arrays.asList("");
        Map<String, Object> PID = ImmutableMap.of("command", "pidof com.ifeelsmart.smartui", "args", pid);//clear the logcat and get new lines
        String ifspid = (String) this.driver.executeScript("mobile: shell", PID);
        return ifspid;
    }

    public void killIfsPid() {
        List<String> kill = Arrays.asList("");
        Map<String, Object> KILL = ImmutableMap.of("command", "kill " + getIfsPid(), "args", kill);//clear the logcat and get new lines
        String killifs = (String) this.driver.executeScript("mobile: shell", KILL);
    }

    public void readLogcat() throws IOException {

        BufferedReader reader = null;
        File file = new File("C:\\Users\\OSN20933\\shlomi_crash.txt");
        try {
            reader = new BufferedReader(new FileReader(file));
            for (String next, line = reader.readLine(); line != null; line = next) {
                next = reader.readLine();
//
//                Log.info("Current line: " + line);
                Boolean decoding = line.contains("teardown/3002");
                Boolean PBA = line.contains("error_code:#PBA");
                Boolean BlackScreen = line.contains("IFS_RESULT_HOST");
                if (decoding) {
//                    SendEmail.sendmail("Decoding error is cacthed","eyal.avramchik@partner.co.il","Decoding error is cacthed");
                    Log.info("Decoding error catched !!");


                } else if (PBA) {
                    SendEmail.sendmail("PBA error is cacthed", "eyal.avramchik@partner.co.il", "PBA error is cacthed");
                } else if (BlackScreen) {
                    takeScreenShot();
//                    SendEmail.sendmail("Black screen error is cacthed", "eyal.avramchik@partner.co.il", "Black screen error is cacthed");
                }
//                Log.info("Next line: " + next);
//                if (line.contains("IFS_RESULT_HOST")) {
//                    Log.info("-------- Black screen catched ---------");
//                } else if (line.contains("error_code:#PBA")) {
//                    Log.info("PBA error occures");
//                } else if (line.contains("כניסה למצב שינה בתוך 30 שניות")) {
//                    Log.info("Entering Sleep mode from LogCat");
//                } else if (line.contains("Waking up by power key from standby mode")) {
//                    Log.info("Waking up from LogCat");
//                } else if (line.contains("teardown/3002")) {
//                    Log.info("----------- Decoding error catched -----------");
//                } else if (line.contains("STB Information")) {
//                    Log.info("STB Information");


            }
        } finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException logOrIgnore) {
            }
        }

//       File file = new File("C:\\Selenium\\Eyal\\stb.txt");
//
//       BufferedReader br = new BufferedReader(new FileReader(file));
//
//       String st;
//       while ((st = br.readLine()) != null)
//           if (st.contains("STB Information"))
//               Log.info(st);
//           else
//               break;
    }

    public void shellCommands() throws IOException {
        try {
            CommandLine cmd = new CommandLine("adb");
            cmd.addArgument("logcat", false).addArgument("-d", false);
            DefaultExecutor exec = new DefaultExecutor();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(cmd);

            if (outputStream.toString().contains("IFS_RESULT_HOST")) {
                List<String> adb1 = Arrays.asList("");
                Map<String, Object> printtear = ImmutableMap.of("command", "logcat -d |grep 'IFS_RESULT_HOST'", "args", adb1);
                driver.pressKeyCode(23);
                takeScreenShot();
                String coach = (String) this.driver.executeScript("mobile: shell", printtear);
                Log.info(coach);
            } else if (outputStream.toString().contains("error_code:#PBA")) {
                List<String> ad = Arrays.asList("");
                Map<String, Object> ppp = ImmutableMap.of("command", "logcat -d |grep 'error_code:#PBA'", "args", ad);
                driver.pressKeyCode(23);
                takeScreenShot();
                String ccc = (String) this.driver.executeScript("mobile: shell", ppp);
                Log.info(ccc);
            }

            List<String> adb = Arrays.asList("");
            Map<String, Object> clearLogcat = ImmutableMap.of("command", "logcat -c", "args", adb);
            this.driver.executeScript("mobile: shell", clearLogcat);

//            else if (outputStream.toString().contains("error_code:#PBA")) {
//                List<String> pba = Arrays.asList("");
//                Map<String, Object> PBA = ImmutableMap.of("command", "logcat -d |grep 'error_code:#PBA'", "args", pba);
//                String pbaerror = (String) this.driver.executeScript("mobile: shell", PBA);
//                Log.info(pbaerror);
//            }

//        cmd.addArgument("shell", false).addArgument("-s", false).addArgument(ip, false).addArgument("kill", false).addArgument(outputStream.toString(), false);


//            CommandLine commandline = CommandLine.parse(command);


        } catch
        (Exception ignore) {
        }
    }

    public void deleteShlomiLogcat() {
        try {
            Files.deleteIfExists(Paths.get("C:\\Users\\OSN20933\\shlomi_crash.txt"));
        } catch (IOException e) {
        }
    }

    public void readLogcatRealTime() throws IOException {
        Process logcatread;
        final StringBuilder log = new StringBuilder();
        try {
            logcatread = Runtime.getRuntime().exec(new String[]{"logcat"});
            BufferedReader br = new BufferedReader(new InputStreamReader(logcatread.getInputStream()), 4 * 1024);
            String line;
            String separator = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
//                log.append(line);
//                log.append(separator);
                if (line.contains("Send teardown with metrics end with status code: 204")) {
                    log.append(line.contains("Send teardown with metrics end with status code: 204"));
                    try {
                        Runtime.getRuntime().exec(new String[]{"logcat", "-c"});
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }


    public void killifs(String ip) throws IOException {

        try {
            CommandLine cmd = new CommandLine("adb");
            CommandLine cmd1 = new CommandLine("adb");
            cmd.addArgument("-s").addArgument(ip, false).addArgument("shell", false).addArgument("\"kill $(pidof com.ifeelsmart.smartui)\"", false);
            DefaultExecutor exec = new DefaultExecutor();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(cmd);
            Log.info("Closing ifs from the background, please wait...");
        } catch
        (Exception ignore) {
            System.out.println(ignore);
        }
    }


    public void checkDevices() throws IOException {
        try {
            CommandLine cmd = new CommandLine("adb");
            cmd.addArgument("devices", false);
            DefaultExecutor exec = new DefaultExecutor();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(cmd);
            if (outputStream.toString().contains("192.168.1.")) {
                Log.info("At least 1 STB is connected, Starting The test ...");
            } else {
                Log.info("No STB devices connected, Aborting the tests !!! " + outputStream.toString());
                System.exit(1);
            }
        } catch
        (Exception ignore) {
            System.out.println(ignore);
        }
    }


    public void StopNodes() throws IOException {
        try {
            CommandLine stop = new CommandLine("taskkill");
            stop.addArgument("/F", false).addArgument("/IM", false).addArgument("node.exe", false);
            DefaultExecutor exec = new DefaultExecutor();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(stop);
            Log.info(outputStream.toString());

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void killAppiumServer() {
        try {
            CommandLine killAppium = new CommandLine("netstat");
            killAppium.addArgument("-ano", false).addArgument("|", false).addArgument("find", false).addArgument("\"0.0.0.0:4723\"", false);
            DefaultExecutor exec = new DefaultExecutor();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(killAppium);
            Log.info(outputStream.toString());

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void cmd(String port) throws IOException {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "/bin/bash", "-c", "netstat -nlp | grep :" + port);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                Log.info(line);
//                System.out.println(line.substring(71));
//                String AppiumServerPid = line.substring(61);
                String AppiumServerPid = line;

                Log.info("Killing Appium port, Wait a sec...");
                ProcessBuilder builder2 = new ProcessBuilder(
                        "/bin/bash", "-c", "taskkill /pid " + AppiumServerPid + " /f");
                builder2.redirectErrorStream(true);
                Process p2 = builder2.start();
                BufferedReader r2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                String line2;
                while (true) {
                    line2 = r2.readLine();
                    if (line2 == null) {
                        break;
                    }
                    System.out.println(line2);
                }
            }
        } catch (Exception ignore) {
            Log.info(ignore.getMessage());
        }
    }

    public void logCatPC(String ip) {
        String dateTime = driver.getDeviceTime().replace(":", "-");
        try {
            Process process = Runtime.getRuntime().exec("adb -s " + ip + " logcat >" + dateTime.substring(0, dateTime.length() - 6).replace("T", " ") + "." + ip);
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Executed successfully");
            } else {
                System.out.println("Failed ...");
            }
//            String dateTime = driver.getDeviceTime().replace(":", "-");
//            ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "adb", "-s", ip, "logcat", ">", dateTime.substring(0, dateTime.length() - 6).replace("T", " ") + "." + ip);
//            builder.start();
            Log.info("adb logcat is active, name of the Log:" + dateTime.substring(0, dateTime.length() - 6).replace("T", " ") + " For ip - " + ip);

//            long pid = p.pid();


        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void getRefreashRate(String ip, String deviceName) throws IOException {
//        List<String> adb = Arrays.asList("");
//        Map<String, Object> ADB2 = ImmutableMap.of("command", "dumpsys display |grep DisplayModeRecord", "args", adb);
//        String AA = (String) driver.executeScript("mobile: shell", ADB2);
//        if (AA.length() >= 69) {
//            Log.info("The Refresh Rate is: " + AA.substring(66, AA.length() - 3));

        CommandLine cmd = new CommandLine("adb");
        cmd.addArgument("-s").addArgument(ip, false).addArgument("shell", false).addArgument("dumpsys", false).addArgument("display", false).addArgument("|", false).addArgument("grep", false).addArgument("DisplayModeRecord", false);
        DefaultExecutor exec = new DefaultExecutor();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
        exec.setStreamHandler(streamHandler);
        exec.execute(cmd);
        if (outputStream.toString().length() >= 69) {
            Log.info("The Refresh Rate for " + deviceName + " is: " + outputStream.toString().substring(66, outputStream.toString().length() - 4));
        }
    }

    public void findImage() throws IOException {
//
//            File black = new File("C:\\Users\\OSN20933\\Pictures\\black_screen.png");
        File start = new File("C:\\Users\\OSN20933\\Pictures\\s.png");
        byte[] fileContent = FileUtils.readFileToByteArray(new File("C:\\Users\\OSN20933\\Pictures\\start.png"));
        String encodedString = Base64.encodeBase64String(fileContent);
//
//        byte[] screenshot = Base64.encodeBase64(driver.getScreenshotAs(OutputType.BYTES));
//        byte[] partialImage = null;
//        OccurrenceMatchingResult result = driver
//                .findImageOccurrence(screenshot, partialImage, new OccurrenceMatchingOptions()
//                        .withEnabledVisualization());
//        Assert.assertTrue(result.getVisualization().length >(0));
//        assertNotNull(result.getRect());

        boolean el = driver.findElementsByImage(encodedString).size() > 0;
        //   takeScreenShot();
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.ByImage.image(encodedString)));
//        Log.info("works!!!");
//takeScreenShot();
        //*    if (el){
        //  Log.info("Exist");
        //  }
        //    else
        //  {
        //    Log.info("Not exist");
    }

    public void che() throws IOException, InterruptedException {
//       takeScreenShot();
        byte[] pngBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        if (IsPngEquals(new File("C:\\Users\\OSN20933\\Pictures\\sleep_black_take.png"), pngBytes)) {
            Log.info("Black screen catched on the screen");
            keyCode keyCode = new keyCode(this.driver);
            keyCode.OK();
            takeScreenShot();
        } else {

        }
    }

    public static boolean IsPngEquals(File pngFile, byte[] pngBytes) throws IOException {
        BufferedImage imageA = ImageIO.read(pngFile);

        ByteArrayInputStream inStreamB = new ByteArrayInputStream(pngBytes);
        BufferedImage imageB = ImageIO.read(inStreamB);
        inStreamB.close();

        DataBufferByte dataBufferA = (DataBufferByte) imageA.getRaster().getDataBuffer();
        DataBufferByte dataBufferB = (DataBufferByte) imageB.getRaster().getDataBuffer();

        if (dataBufferA.getNumBanks() != dataBufferB.getNumBanks()) {
            return false;
        }

        for (int bank = 0; bank < dataBufferA.getNumBanks(); bank++) {
            if (!Arrays.equals(dataBufferA.getData(bank), dataBufferB.getData(bank))) {
                return false;
            }
        }

        return true;
    }


    public void KillAppium(String port) throws IOException {

//        String terminalCommand2 = "netstat -nlp | grep :4728" + port;
        String[] args = new String[]{"/bin/bash", "-c", "netstat -nlp | grep :4728", port};


        ProcessBuilder pb = new ProcessBuilder(args);
        String output = IOUtils.toString(pb.start().getInputStream()).substring(80).replace("/node", "");
//        String b = output.substring(80).replace("/node","netstat -nlp | grep :" + port);
        Log.info(output);
        String[] args2 = new String[]{"/bin/bash", "-c", "kill ", output};
        Process proc = new ProcessBuilder(args2).start();
    }

    public void logCatLinux(String ip) throws IOException, InterruptedException {
        List<LogEntry> logEntries = driver.manage().logs().get("logcat").getAll();
        for (LogEntry logEntry : logEntries) {
            if (logEntry.toString().contains("DRM")){
            System.out.println(logEntry);
                List<String> adb10 = Arrays.asList("");
                Map<String, Object> clearLogcat2 = ImmutableMap.of("command", "logcat -c", "args", adb10);
                this.driver.executeScript("mobile: shell", clearLogcat2);
                Thread.sleep(60000);

        }
            driver.pressKey(new KeyEvent(AndroidKey.CHANNEL_UP));
            Log.info("--- Zapping up ---");
            Thread.sleep(4000);
        }
    }

    public void pause(String ip) throws IOException {


       // String[] args = new String[]{"/bin/bash", "-c", "adb -s " + ip + " logcat | grep 'Player is buffering'"};


    }

    public void pa(String ip) throws IOException {
        String s = null;

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
//            Process c = Runtime.getRuntime().exec("adb -s " + ip + " logcat -c");

            Process p = Runtime.getRuntime().exec("adb -s " + ip + "logcat");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));
            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                    if (s.contains("DRM")){
                        takeScreenShot();
                        Log.info("DRM ERROR" +s);
                        SendEmail.sendmail("DRM ERROR " + s,"eyal.avramchik@partner.co.il","DRM ERROR");
                        Thread.sleep(60000);
                        List<String> adb10 = Arrays.asList("");
                        Map<String, Object> clearLogcat2 = ImmutableMap.of("command", "logcat -c", "args", adb10);
                        this.driver.executeScript("mobile: shell", clearLogcat2);
                }
//                    else if (s.contains("error_code:#PBA")){
//                        takeScreenShot();
//                        Log.info("PBA ERROR");
//                        SendEmail.sendmail("PBA ERROR","eyal.avramchik@partner.co.il","PBA ERROR");
//                        Thread.sleep(60000);
//                    }
//                if (s.contains("Player is buffering")) {
//                    Log.info(" **********  YOU ARE IN A LIVE CHANNEL  **********");
//                } else if (s.contains("Player is paused")) {
//                    Log.info(" **********  YOU ARE IN A PAUSE MODE  **********");
//                } else if (s.contains("Player is resumed")) {
//                    Log.info(" **********  YOU ARE IN RESUME MODE/PLAY MODE  **********");
//                } else if (s.contains("keycode=89")) {
//                    Log.info(" **********  REWIND  **********");
//                } else if (s.contains("keycode=90")) {
//                    Log.info(" **********  FAST FORWARD  **********");
//                }
                driver.pressKey(new KeyEvent(AndroidKey.CHANNEL_UP));
                Log.info("--- Zapping up ---");
                Thread.sleep(3000);
            }

            // read any errors from the attempted command
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((s = stdError.readLine()) != null) {
//                System.out.println(s);
//            }

//            System.exit(0);
        } catch (IOException | InterruptedException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void memoryTest(String ip,String deviceName) throws IOException {
        String n = null;

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process c = Runtime.getRuntime().exec("adb -s " + ip + " logcat -c");

            Process p = Runtime.getRuntime().exec("adb -s " + ip + " shell top -n 1 | grep 'System'");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));
            // read the output from the command
            while ((n = stdInput.readLine()) != null) {


                String[] splited = n.split("\\s+");
                String sum = splited[1];
//                Integer.parseInt(sum.substring(0,2));
//               if (!splited[5].contains("0%")) {
                Log.info(sum);

//                    Log.info("Total Cpu Usage is:  " + splited[5] + "   and the STB IP is: "+ ip + " and the STB name is: " + deviceName);
                }
//            }
//                } else if (n.contains("Player is paused")) {
//                    Log.info(" **********  YOU ARE IN A PAUSE MODE  **********");
//
//                }


            // read any errors from the attempted command
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((s = stdError.readLine()) != null) {
//                System.out.println(s);
//            }

//            System.exit(0);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public void DRM(String ip) {
        ProcessBuilder processBuilder = new ProcessBuilder();//DRM


        processBuilder.command("bash", "-c", "adb -s " + ip + " logcat -d | grep DRM");
        try {
            driver.pressKey(new KeyEvent(AndroidKey.CHANNEL_UP));
            Log.info("--- Zapping up ---");
            Thread.sleep(4000);
            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
             System.out.println(output.append(line));
                takeScreenShot();
                Log.info("First screenshot of the DRM error");
                SendEmail.sendmail(output.toString(),"eyal.avramchik@partner.co.il","DRM Error cacthed");
                List<String> adb10 = Arrays.asList("");
                Map<String, Object> clearLogcat2 = ImmutableMap.of("command", "logcat -c", "args", adb10);
                this.driver.executeScript("mobile: shell", clearLogcat2);
            }


            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
//                System.out.println(output);
//                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void pbaError(String ip) {
        ProcessBuilder processBuilder = new ProcessBuilder();//PBA

        processBuilder.command("bash", "-c", "adb -s " + ip + " logcat -d | grep error_code:#PBA");
        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(output.append(line));
                takeScreenShot();
                Log.info("First screenshot of PBA error before the 60 seconds");
                SendEmail.sendmail(output.toString(),"eyal.avramchik@partner.co.il","PBA Error cacthed");
                List<String> adb10 = Arrays.asList("");
                Map<String, Object> clearLogcat2 = ImmutableMap.of("command", "logcat -c", "args", adb10);
                this.driver.executeScript("mobile: shell", clearLogcat2);
            }


            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
//                System.out.println(output);
//                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void decodingError(String ip) {
        ProcessBuilder processBuilder = new ProcessBuilder();//PBA

        processBuilder.command("bash", "-c", "adb -s " + ip + " logcat -d | grep teardown/3002");
        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(output.append(line));
                takeScreenShot();
                Log.info("First screenshot of the Decoding error");
                SendEmail.sendmail(output.toString(),"eyal.avramchik@partner.co.il","Decoding Error cacthed");
                List<String> adb10 = Arrays.asList("");
                Map<String, Object> clearLogcat2 = ImmutableMap.of("command", "logcat -c", "args", adb10);
                this.driver.executeScript("mobile: shell", clearLogcat2);
            }


            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
//                System.out.println(output);
//                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//        if (i == 0) System.out.println("Nothing read from input stream");