package src.main.java;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
    public static void main(String[] args) {
        AppiumDriver driver = null;
        AppiumDriverLocalService service = null;

        try {
            // Start the Appium service
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();

            // Set up desired capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "KVRKKJL7OVVOXWR8"); 
            //capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0"); 
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "BinithaAVD"); // Replace with your device name
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0"); // Replace with your Android version
            capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/binit/APKs/base.apk"); // Path to your app

            // Initialize AndroidDriver with the correct URL from Appium service
            driver = new AndroidDriver(service.getUrl(), capabilities);

            var ele = driver.findElement(AppiumBy.xpath("//*[contains(@text, 'Hello Android')]"));
            System.out.println("Element found with text: " + ele.getText());

      

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
            if (service != null) {
                service.stop();
            }
        }
    }
}
