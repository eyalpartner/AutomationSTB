import io.appium.java_client.MobileElement;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FactoryClasses.keyCode;
import utils.Log;
import utils.TemplateMatching;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LiveAllNight extends BaseTest {
    public LiveAllNight() throws IOException {
    }

    @Parameters({"deviceName"})
    @Test(description = "Live All Night", priority = 1, alwaysRun = true)
    public void liveTV(String deviceName) throws InterruptedException, IOException {
        cap.setCapability("deviceName", deviceName);



//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("exo_content_frame"))));
        String activity = driver.currentActivity();
        Boolean act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");


//        byte[] fileContent = FileUtils.readFileToByteArray(new File("C:\\Users\\OSN20933\\Pictures\\sleep_black.png"));
//        String encodedString = Base64.encodeBase64String(fileContent);
//        boolean el = driver.findElementsByImage(encodedString).size() > 0 ;

        while (act) {
            activity = driver.currentActivity();
            act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
        }
        logCatLinux(deviceName);
        Log.info(" ifs just crashed man!!! shit man !!! :-( ");
        Assert.assertTrue(act);
    }
}


