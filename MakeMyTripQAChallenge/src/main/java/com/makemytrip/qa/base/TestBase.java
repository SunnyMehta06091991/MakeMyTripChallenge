package com.makemytrip.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.makemytrip.qa.util.TestUtils;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Map<String, Object> prefs;
	public static ChromeOptions options;
	
	public TestBase(){
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("G:\\Assignment-2\\MakeMyTripQATest\\src\\main\\java\\com\\makeMyTrip\\qa\\config\\config.properties");
		    prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
     }
	
	@SuppressWarnings("deprecation")
	public static void initialization(){
		String webBrowser = prop.getProperty("browser");
    	System.out.println("browser used for execution is "+ webBrowser);

    	if(webBrowser.equals("chrome")){
    		ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--incognito");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, ops);
        	System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
        	driver = new ChromeDriver(cap);
        	}else if (webBrowser.equals("FireFox")){
            	System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverPath"));
        		driver = new FirefoxDriver(); 
                }
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(TestUtils.pageLoadTimeout, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(TestUtils.implicitWautTimeout, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    	driver.manage().deleteAllCookies();

	}
	
}


