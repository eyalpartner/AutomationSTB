import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FactoryClasses.keyCode;
import utils.Log;

import java.io.IOException;
import java.util.List;

public class Play_Pause_Live extends BaseTest {
    @Parameters({"deviceName","ip"})
    @Test
    public void pauseForHour(String deviceName,String ip) throws InterruptedException, IOException {
        keyCode keyCode = new keyCode(driver);

        Thread.sleep(25000);
        keyCode.playPause();


//            if (logEntry.toString().contains("died"))

//           if (log==true){
//               Log.info("Live channel is now on");
//           }
            while (true) {
                pa(ip);
            }
//            Assert.assertTrue(!log, "The Player is Live, Test is passed");
        }
    }
