//import org.testng.Assert;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import utils.BaseTest;
//import utils.Log;
////import utils.ReadAdbCommands;
//import utils.SendEmail;
//
//import java.io.IOException;
//
//import static io.appium.java_client.android.AndroidKeyCode.KEYCODE_DPAD_UP;
//import static io.appium.java_client.android.AndroidKeyCode.KEYCODE_MENU;
//
//public class catchUp extends BaseTest {
//    public catchUp() throws IOException {
//    }
//
//    @Parameters({"ScreenState","Status","deviceName","openScreen"})
//        @Test(description = "")
//        public void catchUP(String ScreenState,String Status, String deviceName, String openScreen) throws Exception {
//            capabilities.setCapability("ScreenState", ScreenState);
//            capabilities.setCapability("Status", Status);
//            capabilities.setCapability("deviceName", deviceName);
//            capabilities.setCapability("openScreen", openScreen);
////            Log.info("--- ממתין 40 שניות עד שפרטנר טי וי תעלה --- ");
//            Thread.sleep(42000);
//            String activity = driver.currentActivity();
//            int i = 0;
//            Boolean act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
//            EnterTheCacthUp(); // שימוש במתודה של כניסה לקאץ' אפ, בניית המתודה התבצעה במחלקת פקטורי
//            while (act) {
//                activity = driver.currentActivity();
//                act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
//                driver.pressKeyCode(90);
//                Thread.sleep(3000);
//                driver.pressKeyCode(90);
//                Thread.sleep(3000);
//                driver.pressKeyCode(90);
//                Thread.sleep(3000);
//                driver.pressKeyCode(90);
//                Thread.sleep(3000);
//                driver.pressKeyCode(90);
//                Thread.sleep(3000);
//                driver.pressKeyCode(89);
////                Log.info(" רבע שעה צפייה וחוזר חלילה ");
//                Thread.sleep(900000);
////                Log.info("בודק אם הממיר פתוח או סגור");
//                Runtime.getRuntime().exec("cmd /c start C:\\Selenium\\" + ScreenState);
//                Thread.sleep(4000);
////                String a = ReadAdbCommands.getadb(Status);
////                if (a.contains("OFF")) {
////                    Log.info(deviceName + "הממיר סגור, פותח את הממיר, שנייה...");
////                    Runtime.getRuntime().exec("cmd /c start C:\\Selenium\\" + openScreen);
////                } else
////                    Log.info(" הממיר פתוח, ממשיך בדיקות ");
//            }
//            String cup = capabilities.getCapability("deviceName").toString();
////            Log.info(" פרטנר טי וי קרסה אצל " + cup);
//
////            if (cup.equals("אייל")) {
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: eyal_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
////            } else if (cup.equals("כפיר")) {
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: kfir_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////
////                Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
////            } else if (cup.equals("שלומי")) {
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: _shlomi_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN20933\\ ושם הקובץ: shlomi_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
////            } else if (cup.equals("Rodman")) {
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Rodman_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
////            } else if (cup.equals("Bird")) {
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Bird_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
////            } else if (cup.equals("Jordan")) {
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "eyal.avramchik@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "shlomi.mor4@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "yuvalpr@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                SendEmail.sendmail("אפליקציית IFS קרסה, לוג נמצא ב: C:\\Users\\OSN22600\\ ושם הקובץ: Jordan_crash.txt", "golan.belo@partner.co.il", "אפליקציית IFS קרסה בממיר של " + cup + version);
////                Log.info("המייל נשלח לשלומי,אייל,גולן ויובל");
////            } else {
//////                Log.info("אף מייל לא נשלח, בדיקת קוד");
////            }
//            Assert.assertTrue(act,"Partner tv has crashed");
//        }
//
//        public void EnterTheCacthUp() throws InterruptedException {
////                Log.info("מחכה 28 שניות שפרטנר טי וי תעלה...");
//                Thread.sleep(10000);
////                Log.info("מחכה ש פרטנר טי וי יואיל בטובו לעלות ולסגור את האי פי גי");
//                driver.pressKeyCode(KEYCODE_MENU);
////                Log.info("נכנס לתפריט פרטנר טי וי");
//                Thread.sleep(6000);
////                Log.info("מחכה שהתפריט יעלה");
//                driver.pressKeyCode(KEYCODE_DPAD_UP);
////                Log.info("לוחץ מקש למעלה כדי לבחור ב קאץ אפ");
//                Thread.sleep(1500);
//                driver.pressKeyCode(21);
//                Thread.sleep(1500);
//                driver.pressKeyCode(21);
//                Thread.sleep(1500);
//                driver.pressKeyCode(21);
//                Thread.sleep(1500);
//                driver.pressKeyCode(23);
//                Thread.sleep(1500);
//                driver.pressKeyCode(21);
//                Thread.sleep(2000);
//                driver.pressKeyCode(20);
//                Thread.sleep(2000);
//                driver.pressKeyCode(23);
//                Thread.sleep(1500);
//                driver.pressKeyCode(23);
//                Thread.sleep(5000);
//        }
//}