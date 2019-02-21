//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import utils.BaseTestExoPlayer;
//import utils.Log;
//import utils.SendEmail;
//
//import java.io.IOException;
//import java.time.Duration;
//
//public class exoplayer extends BaseTestExoPlayer {
//    @Parameters({"ScreenState","openScreen"})
//    @Test
//    public void exo(String ScreenState,String openScreen) throws InterruptedException, IOException {
//        capabilities.setCapability("ScreenState",ScreenState);
//        capabilities.setCapability("openScreen",openScreen);
//        Log.info("exoplayer 2.5.4 is opened");
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Widevine DASH: MP4,H264']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//android.widget.TextView[@text='lab 1181 catch up']")).click();
//        String activity = driver.currentActivity();
//        Log.info(activity);
//        int i = 0;
//        Boolean act = activity.equals(".PlayerActivity");
//
//        while (act) {
//            activity = driver.currentActivity();
//            act = activity.equals(".PlayerActivity");
//            Log.info(" רבע שעה צפייה ");
//            Thread.sleep(750000);
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            driver.longPressKey(new KeyEvent(AndroidKey.MEDIA_REWIND));
//            Thread.sleep(750000);
//            Log.info("בודק אם הממיר פתוח או סגור");
//            Runtime.getRuntime().exec("cmd /c start C:\\Selenium\\"+ScreenState);
//            Thread.sleep(4000);
////            String a = ReadAdbCommands.getadb();
////            if (a.contains("OFF")){
////                Log.info("הממיר סגור, פותח את הממיר, שנייה...");
////                Runtime.getRuntime().exec("cmd /c start C:\\Selenium\\" +openScreen);
////            }
////            else
////                Log.info("הממיר פתוח, ממשיך בדיקות...");
//
//
//
//        }
//        String cup = capabilities.getCapability("deviceName").toString();
//        Log.info( " אקסופלייר קרסה אצל " + cup );
//        if (cup.equals("אייל")) {
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            Log.info("המייל נשלח בהצלחה לשלומי ואייל");
//        }
//        else if  (cup.equals("כפיר")) {
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            Log.info("המייל נשלח בהצלחה לשלומי ואייל" );
//        }
//        else if (cup.equals("שלומי")){
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            Log.info("המייל נשלח בהצלחה לשלומי ואייל" );
//        }
//        else if (cup.equals("גוטה")){
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: gute_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            SendEmail.sendmail("אפליקציית אקסופלייר קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: gute_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית אקסופלייר קרסה בממיר של " + cup);
//            Log.info("המייל נשלח בהצלחה לשלומי ואייל" );
//        }
//        else
//            Log.info("כפיר ואייל לא מחוברים");
//    }
//    }