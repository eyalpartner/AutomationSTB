import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTestNetflix;
import utils.SendEmail;

import java.io.IOException;

public class netflixPlay extends BaseTestNetflix {




    @Test(description = "Netflix", priority = 1, alwaysRun = true)
    public void NetflixPlay() throws InterruptedException, IOException {


        String activity = driver.currentActivity();
        Boolean act = activity.equals(".MainActivity");
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        while (act) {
            activity = driver.currentActivity();
            act = activity.equals(".MainActivity");
        }
        SendEmail.sendmail("Netflix has crashed in " +cap.getCapability("ip"),Eyal,driver.currentActivity()+ " Is now in the background");
        Assert.assertTrue(act,"The Netflix app has crashed !!!");
    }
}


