import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.io.IOException;

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
        while (act) {
            activity = driver.currentActivity();
            act = activity.equals("com.ifeelsmart.common.IFSNativeActivityImpl");
            openSTB();
        }
        Assert.assertTrue(act);
    }
}


