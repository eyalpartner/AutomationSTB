//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.imagecomparison.FeatureDetector;
//import io.appium.java_client.imagecomparison.FeaturesMatchingOptions;
//import io.appium.java_client.imagecomparison.FeaturesMatchingResult;
//import io.appium.java_client.imagecomparison.MatchingFunction;
//import org.apache.commons.codec.binary.Base64;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//import utils.BaseTest;
//import utils.BaseTestMobile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
//import java.awt.image.WritableRaster;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.time.Duration;
//
//import static io.appium.java_client.touch.WaitOptions.waitOptions;
//import static io.appium.java_client.touch.offset.PointOption.point;
//import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertNotNull;
//
//public class training extends BaseTestMobile {
//
//AppiumDriver driver1;
//    @Test
//    public void tapByCoordinates () throws InterruptedException {
//        Thread.sleep(30000);
//        new TouchAction(driver)
//                .tap(point(1009,941));
////                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
//
//
////        byte[] screenshot1 = Base64.encodeBase64(driver.getScreenshotAs());
//
//
////        byte[] originalImg = Path
////        byte[] screenshot = Base64.encodeBase64(driver.getScreenshotAs(OutputType.BYTES));
////        FeaturesMatchingResult result = driver
////                .matchImagesFeatures(screenshot, originalImg, new FeaturesMatchingOptions()
////                        .withDetectorName(FeatureDetector.ORB)
////                        .withGoodMatchesFactor(40)
////                        .withMatchFunc(MatchingFunction.BRUTE_FORCE_HAMMING)
////                        .withEnabledVisualization());
////
////        assertFalse(result.getPoints1().isEmpty());
////        assertNotNull(result.getRect1());
////        assertFalse(result.getPoints2().isEmpty());
////        assertNotNull(result.getRect2());
//    }
//
//    public byte[] extractBytes (String ImageName) throws IOException {
//        // open image
//        File imgPath = new File("C:\\Users\\OSN20933\\Pictures\\stb setup images\\1.png");
//        BufferedImage bufferedImage = ImageIO.read(imgPath);
//
//        // get DataBufferBytes from Raster
//        WritableRaster raster = bufferedImage .getRaster();
//        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
//
//        return ( data.getData() );
//    }
//}