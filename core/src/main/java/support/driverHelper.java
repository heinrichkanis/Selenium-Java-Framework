package support;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import variables.utils.desiredCaps;

public class driverHelper {
	public static RemoteWebDriver driver = null;

	public static RemoteWebDriver getDriver(String driverType, String browserName, String appiumServerURL, String seleniumGridURL) 
	throws MalformedURLException {

		if 		  (driverType.equals("WebDriver")) {

			if (driver == null) {
				if (browserName.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();

					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");

					driver = new ChromeDriver(options);

					Map<String, Object> prefs = new HashMap<>();
					prefs.put("download_restrictions", 3);
					options.setExperimentalOption("prefs", prefs);
				}
				else if (browserName.equalsIgnoreCase("chrome incognito")) {
					WebDriverManager.chromedriver().setup();

					ChromeOptions options = new ChromeOptions();
					options.addArguments("--incognito");
					options.addArguments("--remote-allow-origins=*");

					driver = new ChromeDriver(options);

					Map<String, Object> prefs = new HashMap<>();
					prefs.put("download_restrictions", 3);
					options.setExperimentalOption("prefs", prefs);
				}

				else if (browserName.equalsIgnoreCase("chrome headless")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					driver = new ChromeDriver(options);
				} else if (browserName.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else if (browserName.equalsIgnoreCase("IE")) {
					WebDriverManager.iedriver().setup();
					driver = new EdgeDriver();
				}

			}

			return (RemoteWebDriver) driver;

		} else if (driverType.equals("AppiumDriver")) {

			try {
				DesiredCapabilities caps = new DesiredCapabilities();

				caps.setCapability("automationName", desiredCaps.automationName);
				caps.setCapability("platformName", desiredCaps.platformName);
				caps.setCapability("platformVersion", desiredCaps.platformVersion);
				caps.setCapability("deviceName", desiredCaps.deviceName);
				caps.setCapability("udid", desiredCaps.udid);
				caps.setCapability("app", desiredCaps.app);

				caps.setCapability("appPackage", desiredCaps.appPackage);
				caps.setCapability("appActivity", desiredCaps.appActivity);
				caps.setCapability("NEW_COMMAND_TIMEOUT", desiredCaps.newCommandTimeout);
				caps.setCapability("BROWSER_NAME", desiredCaps.browserName);

				caps.setCapability("unicodeKeyboard", desiredCaps.unicodeKeyboard);
				caps.setCapability("resetKeyboard", desiredCaps.resetKeyboard);
				caps.setCapability("isHeadless", desiredCaps.isHeadless);
				caps.setCapability("orientation", desiredCaps.orientation);

				URL serverURL = new URL(appiumServerURL);

				driver = new AppiumDriver(serverURL, caps);
				// driver = new AndroidDriver(serverURL, caps);
				// driver = new IOSDriver(serverURL, caps);

			} catch (MalformedURLException e) {

				System.out.println("Cause is :" + e.getCause());
				System.out.println("Message is :" + e.getMessage());
				e.getStackTrace();
			}

			return driver;

		} else if (driverType.equals("RemoteDriver")) {
			DesiredCapabilities caps = new DesiredCapabilities();

			if (browserName.equalsIgnoreCase("chrome")) {

				caps.setBrowserName("chrome");

			} else if (browserName.equalsIgnoreCase("firefox")) {

				caps.setBrowserName("firefox");

			} else if (browserName.equalsIgnoreCase("edge")) {

				caps.setBrowserName("MicrosoftEdge");

			} else if (browserName.equalsIgnoreCase("opera")) {

				caps.setBrowserName("opera");

			} else if (browserName.equalsIgnoreCase("ie")) {

				caps.setBrowserName("internet explorer");

			} else if (browserName.equalsIgnoreCase("safari")) {

				caps.setBrowserName("safari");

			} else {

				throw new RuntimeException("BrowserType Not Supported");

			}

			driver = new RemoteWebDriver(new URL(seleniumGridURL), caps);

			return (RemoteWebDriver) driver;
		}

		return (RemoteWebDriver) driver;
	}

	public static void openWebsite(String siteToOpen) throws InterruptedException {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(siteToOpen);
	}

	public static void SetZoom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
		System.out.println("Zoom @ 80% ");
	}

	public static void closeDriver(){

		driver.close();
	}

	public static void quitDriver(){

		driver.quit();
	}

}