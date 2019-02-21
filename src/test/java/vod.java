//import io.appium.java_client.android.Activity;
//import io.appium.java_client.android.AndroidKeyCode;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import utils.BaseTest;
//import utils.Log;
//import utils.SendEmail;
//
//import java.io.IOException;
//
//import static io.appium.java_client.android.AndroidKeyCode.*;
//
//public class vod extends BaseTest {
//    public vod() throws IOException {
//    }
//
//    @Test(description = "צפייה ב VOD",priority = 1)
//    public void zap() throws InterruptedException {
////        ExtentTestManager.getTest().setDescription("צפייה בVOD");
//        Log.info("--- ממתין 28 שניות עד שפרטנר טי וי תעלה --- ");
//        Thread.sleep(28000);
//        EnterTheVod();
//        String ackageName = driver.getCurrentPackage();
//        Boolean p = ackageName.equals("com.ifeelsmart.smartui");
//        while (p) {
//            ackageName = driver.getCurrentPackage();
//            p = ackageName.equals("com.ifeelsmart.smartui");
//            Thread.sleep(10000);
//            Log.info(" חצי שעה צפייה וחוזר חלילה ");
//            Thread.sleep(1321000);
//
//            driver.pressKeyCode(KEYCODE_HOME);
//
//            WebDriverWait wait = new WebDriverWait(driver, 20);
//            wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("android.widget.TextView"))));
//
//            if (driver.findElement(By.className("android.widget.TextView")).isDisplayed()) {
//                Log.info("STB is now in the Android Home Screen, He's not stuck, Back to VOD ...");
//                driver.launchApp();
//                Thread.sleep(3000);
//                driver.pressKeyCode(23);
//                Thread.sleep(1500);
//                driver.pressKeyCode(23);
//                Thread.sleep(1500);
//            } else {
//                Log.info("Stb is stuck");
//                SendEmail.sendmail("STB is stuck after watch vod", "eyal.avramchik@partner.co.il", "STB is stuck");
//                SendEmail.sendmail("STB is stuck after watch vod", "shlomi@partner.co.il", "STB is stuck");
//            }
//        }
//Log.info("Test is over, Partner tv not in the background");
//        SendEmail.sendmail("Partner is dead", "eyal.avramchik@partner.co.il", "Partner flight");
//
//
//
//    }
//    public void EnterTheVod() throws InterruptedException {
//        driver.pressKeyCode(KEYCODE_MENU);
////                Log.info("נכנס לתפריט IFS");
//        Thread.sleep(6000);
////                Log.info("מחכה שהתפריט יעלה...");
//        driver.pressKeyCode(KEYCODE_DPAD_UP);
////                Log.info("לוחץ מקש למעלה כדי לבחור ב CATCH UP");
//        Thread.sleep(1500);
//        driver.pressKeyCode(KEYCODE_DPAD_UP);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(20);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(2000);
//        driver.pressKeyCode(21);
//        Thread.sleep(2000);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(23);
//        Thread.sleep(1500);
//        driver.pressKeyCode(20);
//        Thread.sleep(2000);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(20);
//        Thread.sleep(2000);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(21);
//        Thread.sleep(1500);
//        driver.pressKeyCode(23);
//        Thread.sleep(1500);
//        driver.pressKeyCode(23);
//        Thread.sleep(1500);
//
//
//
//
//    }
//    public void ifscrashed() {
//
////            if (i < 10) { //  תנאי שאומר שאם הלולאה רצה פחות מ10 פעמים אז האפליקציה קרסה אחרת הטסט עבר בהצלחה
//
//        String cup = capabilities.getCapability("deviceName").toString();
//        Log.info(" פרטנר טי וי קרסה אצל: " + cup);
//        if (cup.equals("אייל")) {
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup);
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup);
//            Log.info("המייל נשלח בהצלחה ל" + cup);
//        } else if (cup.equals("כפיר")) {
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של" + cup);
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup);
//            Log.info("המייל נשלח בהצלחה ל" + cup);
//        } else if (cup.equals("שלומי")) {
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של!!!!!" + cup);
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של  " + cup);
//            Log.info("המייל נשלח בהצלחה ל" + cup);
//        } else if (cup.equals("גוטה")) {
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: gute_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup);
//            SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: gute_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup);
//            Log.info("המייל נשלח בהצלחה ל" + cup);
//        } else
//
//            Log.info("אף מייל לא נשלח, בדיקת קוד");
//    }
////             else{
////                Log.info("הטסט עבר בהצלחה, האפליקציה לא קרסה");
////
////            }
//
//
//}
