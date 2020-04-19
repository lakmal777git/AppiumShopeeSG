import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.springframework.core.annotation.Order;

import java.net.URL;
import java.util.List;


public class ShopeeSGAppTest {

    private static DesiredCapabilities dc;
    private static AndroidDriver<WebElement> driver;

    @BeforeClass
    public static void setUp() {
        dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability("appPackage", "com.shopee.sg");
        dc.setCapability("appActivity", "com.shopee.app.ui.home.HomeActivity_");
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<WebElement>(url, dc);
            Thread.sleep(4000);
        } catch (Exception ex) {
            System.exit(0);
        }
    }
    @Test
    public void swipeTutorials() {
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        int screenWidth = size.getWidth();
        int screenHeight = size.getHeight();

        int startx = screenWidth * 8 / 9;
        int endx = screenHeight / 9;
        int starty = screenHeight / 2;
        int endy = screenHeight / 2;

        driver.swipe(startx, starty, endx, endy, 1000);
        System.out.println("swipped  demo screen 1");
        driver.swipe(startx, starty, endx, endy, 1000);
        System.out.println("swipped  demo screen 2");
        driver.swipe(startx, starty, endx, endy, 1000);
        System.out.println("swipped  demo screen 3");
        driver.swipe(startx, starty, endx, endy, 1000);
        System.out.println("swipped  demo screen 4");
        driver.swipe(startx, starty, endx, endy, 1000);
        System.out.println("swipped  demo screen 5");
    }
    @Test
    public void startButtonTap() {
        MobileElement startBtn = (MobileElement) driver.findElementByClassName("android.widget.Button");
        startBtn.click();
    }
    @Test
    public void dismissAdPopup() throws InterruptedException {
        Thread.sleep(10000);
        MobileElement dismissContainer = (MobileElement) driver.findElementByClassName("android.widget.ImageView");
        dismissContainer.click();
        Thread.sleep(5000);
        MobileElement clickShoppeMallBtn = (MobileElement) driver.findElementById("com.shopee.sg:id/tab_animation_icon");
        clickShoppeMallBtn.click();
        MobileElement clickMobileGadjecThech = (MobileElement) driver.findElementByClassName("android.widget.FrameLayout");
        clickMobileGadjecThech.click();
        Thread.sleep(10000);
    }
}