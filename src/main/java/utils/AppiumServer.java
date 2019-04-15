package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import java.io.File;




public class AppiumServer{
    public  AppiumDriverLocalService service;
    public DesiredCapabilities cap;
    public String Appium_Node_Path = "/home/eyal/node-v11.13.0-linux-x64/bin/./node";
    public String Appium_JS_Path = "/home/eyal/node-v11.13.0-linux-x64/lib/node_modules/appium/build/lib/main.js";
    public void AppiumServer(String port,String bpPort,String Name) throws InterruptedException {
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingPort(Integer.parseInt(port)).usingDriverExecutable(new File(Appium_Node_Path))
                .withAppiumJS(new File(Appium_JS_Path))
                .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, bpPort)
                .withCapabilities(cap));
//        if (service.isRunning()== true) {
//            Log.info("Server is already running " + service.getUrl().toString());
//        }
//        else
        service.start();
        Log.info(" ---------------------- Appium server has started at " + service.getUrl().toString() +"("+Name+")" + "  ------------------------");
    }
}
