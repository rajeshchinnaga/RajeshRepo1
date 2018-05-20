package com.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utilities.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vijay\\eclipse-workspace\\TestingMavenJenkins\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time_out, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
