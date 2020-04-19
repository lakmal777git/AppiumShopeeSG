import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;


public class ShopeeSGAppTest {

    private static DesiredCapabilities dc;
    private static AndroidDriver<WebElement> driver;

    @BeforeClass
    public static void setUp() {
        dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11 Pro Max");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.4");
        dc.setCapability("appPackage", "com.beeasy.shopee.sg;");
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
    public void MaininAppTests() throws InterruptedException {
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