import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Log;
import utils.SendEmail;

import java.io.IOException;

public class zapping extends BaseTest {
    public zapping() throws IOException {
    }

    @Parameters({"deviceName"})
    @Test(description = "zap and watch and fast forward and rewind",priority = 1,alwaysRun=true)
    public void zap(String deviceName) throws InterruptedException, IOException {
        cap.setCapability("deviceName",deviceName);
//        ExtentTestManage.getTest().setDescription("צפייה בשידור חי חצי שעה ואז זפזופ לערוץ אחר וחוזר חלילה");
        Log.info("--- Waiting for IFS to load ... --- ");
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("exo_content_frame"))));
        Thread.sleep(30000);
        String activity = driver.currentActivity();
        Boolean act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
        Log.info("Demonstation for Golan Belo the king is starting now !!!");
        Log.info("All is good !!!");
        while (act) {
            activity = driver.currentActivity();
            act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
            Thread.sleep(10000);
            driver.pressKeyCode(166);
            Log.info("--- Zapping up ---");
            Thread.sleep(4000);
            driver.pressKeyCode(166);
            Log.info("--- Zapping up ---");
            Thread.sleep(4000);
            driver.pressKeyCode(167);
            Log.info("--- Zapping down ---");
            Log.info(" 100 seconds watching ... ");
            Thread.sleep(100000);
            fastRewind();
//            String a = ReadAdbCommands.getadb(Status);
//            if (a.contains("OFF")){
//                Log.info(deviceName + "הממיר סגור, פותח את הממיר, שנייה...");
//                Runtime.getRuntime().exec("cmd /c start C:\\Selenium\\" +openScreen);
//            }
//            else
//                Log.info(" הממיר פתוח, ממשיך בדיקות ");
        }
        ifscrashed();
        Assert.assertTrue(act,"פרטנר טי וי קרסה הטסט נכשל");
    }
//    @Test(description = "כניסה לקאץ' אפ וצפייה ארוכה",priority = 2)
//    public void catchUP() throws Exception {
//        driver.launchApp();
////        String activity = driver.currentActivity();
////        Boolean act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
//        EnterTheCacthUp(); // שימוש במתודה של כניסה לקאץ'
////        while (act) {
////            activity = driver.currentActivity();
////            act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
//            Thread.sleep(900000);
//            Log.info( " 15 דקות צפייה ");
//            fastRewind();

//             ifscrashed();
//            Assert.assertTrue(act,"פרטנר טי וי קרסה הטסט נכשל");

//    }
//        public void EnterTheCacthUp() throws InterruptedException {
//            Log.info("מחכה 28 שניות שפרטנר טי וי תעלה...");
//            Thread.sleep(28000);
////                Log.info("מחכה ש IFS יואיל בטובו לעלות ולסגור את ה EPG...");
//            driver.pressKeyCode(KEYCODE_MENU);
////                Log.info("נכנס לתפריט IFS");
//            Thread.sleep(6000);
////                Log.info("מחכה שהתפריט יעלה...");
//            driver.pressKeyCode(KEYCODE_DPAD_UP);
////                Log.info("לוחץ מקש למעלה כדי לבחור ב CATCH UP");
//            Thread.sleep(1500);
//            driver.pressKeyCode(21);
//            Thread.sleep(1500);
//            driver.pressKeyCode(21);
//            Thread.sleep(1500);
//            driver.pressKeyCode(21);
//            Thread.sleep(1500);
//            driver.pressKeyCode(23);
//            Thread.sleep(1500);
//            driver.pressKeyCode(21);
//            Thread.sleep(2000);
//            driver.pressKeyCode(21);
//            Thread.sleep(2000);
//            driver.pressKeyCode(23);
//            Thread.sleep(1500);
//            driver.pressKeyCode(23);
//            Thread.sleep(5000);
//        }
        public void ifscrashed() {

//            if (i < 10) { //  תנאי שאומר שאם הלולאה רצה פחות מ10 פעמים אז האפליקציה קרסה אחרת הטסט עבר בהצלחה
                String cup = cap.getCapability("deviceName").toString();
                Log.info(" פרטנר טי וי קרסה אצל: " + cup);
                if (cup.equals("אייל")) {
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
                } else if (cup.equals("כפיר")) {
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של" + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
                } else if (cup.equals("שלומי")) {
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של!!!!!" + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של  " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
                } else if (cup.equals("Rodman")) {
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
                } else if (cup.equals("Bird")){
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
                }
                 else if (cup.equals("Jordan")){
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
                    Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
                }
                   else Log.info("אף מייל לא נשלח, בדיקת קוד");
            }
        public void fastRewind() throws InterruptedException {
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(90);
        Log.info("20 seconds forward");
        Thread.sleep(1500);
        driver.pressKeyCode(89);
        Log.info("20 seconds rewind");
        Thread.sleep(1500);
        driver.pressKeyCode(89);
        Log.info("20 seconds rewind");
        Thread.sleep(1500);
        driver.pressKeyCode(89);
        Log.info("20 seconds rewind");
    }
}