import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private AndroidDriver androidDriver;

    @BeforeTest
    public void setCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Nexus API 29");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\TB-NTB-118\\AndroidStudioProjects\\MyApplication\\app\\build\\intermediates\\apk\\debug\\app-debug.apk");
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        androidDriver = new AndroidDriver(remoteUrl, capabilities);
        androidDriver.manage().timeouts()
                .implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void sampleTest() throws InterruptedException {
        androidDriver.findElement(By.id("com.example.myapplication:id/username")).sendKeys("1234");
        System.out.println(androidDriver.getBatteryInfo());
    }
}