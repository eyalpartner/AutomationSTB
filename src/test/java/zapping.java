import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FactoryClasses.keyCode;
import utils.Log;
import utils.SendEmail;

import java.io.IOException;

public class zapping extends BaseTest {
    public zapping() throws IOException {
    }

    @Parameters({"deviceName"})
    @Test(description = "zap and watch and fast forward and rewind",priority = 1,alwaysRun=true)
    public void zap(String deviceName) throws InterruptedException, IOException {
        try{
            findImage();
        } catch (Exception ignore) {
            Log.info(ignore.getMessage());
        }
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
        Log.info("Shabat Shalom");
        while (act) {
            activity = driver.currentActivity();
            act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
            Thread.sleep(10000);
            driver.pressKey(new KeyEvent(AndroidKey.CHANNEL_UP));
            Log.info("--- Zapping up ---");
            Thread.sleep(4000);
            driver.pressKey(new KeyEvent(AndroidKey.CHANNEL_UP));
            Log.info("--- Zapping up ---");
            Thread.sleep(4000);
            driver.pressKey(new KeyEvent(AndroidKey.CHANNEL_DOWN));
            Log.info("--- Zapping down ---");
            Log.info(" 100 seconds watching ... ");
            Thread.sleep(100000);
            fastRewind();
        }
        ifscrashed();
        Assert.assertTrue(act,"פרטנר טי וי קרסה הטסט נכשל");
    }

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
        keyCode keyCode = new keyCode(this.driver);
        keyCode.Forward();
        keyCode.Forward();
        keyCode.Forward();
        keyCode.Forward();
        keyCode.Forward();
        keyCode.Forward();
        keyCode.Rewind();
        keyCode.Rewind();
        keyCode.Rewind();
    }
}