import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.FactoryClasses.keyCode;
import utils.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Play_Pause_Live extends BaseTest {
    @Parameters({"deviceName", "ip"})
    @Test
    public void pauseForHour(String deviceName, String ip) throws InterruptedException, IOException {
        String s = null;
        boolean isPause = true;
        try {
            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process c = Runtime.getRuntime().exec("adb -s " + ip + " logcat -c");
            Process p = Runtime.getRuntime().exec("adb -s " + ip + " logcat | grep 'Player is buffering'");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));
            keyCode keyCode = new keyCode(driver);
            Thread.sleep(45000);
            keyCode.playPause();
            c.isAlive();
            // read the output from the command
            while (isPause == true && (s = stdInput.readLine()) != null) {
//                Thread.sleep(3600000);
                try {
                   //Log.info(s);
                    //Boolean yy = s.contains("Player is buffering");
                    //if (yy==true){
                    if(s.contains("BpkMetricManager: Player is buffering") ){
                        Log.info("Pause mode is now Live mode");
                        isPause = false;
                    }


                }catch (java.lang.NullPointerException e){
                    e.getMessage();
                }
                }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}