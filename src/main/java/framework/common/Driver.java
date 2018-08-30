package framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    public static WebDriver CurrentDriver;

    public static void InitDriver(){
        String browserType = framework.common.Configurations.GetValueByKey("browser").toLowerCase();
        if (browserType.equals("chrome")) {
//            DesiredCapabilities dc = new DesiredCapabilities();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--kiosk", "test-type");
//            dc.setCapability(ChromeOptions.CAPABILITY, options);
            CurrentDriver = new ChromeDriver();
            CurrentDriver.manage().window().maximize();

        } else if (browserType.equals("ff") || browserType.equals("firefox")) {
//            FirefoxProfile profile= new FirefoxProfile();
//            profile.setPreference("plugin.state.flash", 1);
//            profile.setEnableNativeEvents(true);
//            profile.setAcceptUntrustedCertificates(true);
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile ffprofile = profile.getProfile("SELENIUM");
            CurrentDriver = new FirefoxDriver(ffprofile);
            CurrentDriver.manage().window().maximize();

        } else {
            CurrentDriver = new InternetExplorerDriver();
        }
//        Driver.CurrentDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static void CloseDriver(){
        System.out.println("\r\nDEBUG: close the browser");
        if(CurrentDriver.getClass().equals(FirefoxDriver.class)) ((FirefoxDriver)CurrentDriver).kill();
        else CurrentDriver.close();
    }

    public static void refreshPage(){
        CurrentDriver.navigate().refresh();
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
    }
}
