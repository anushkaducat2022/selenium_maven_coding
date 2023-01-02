package AmazonBaseConfigfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup_configfilecode_basefile {
	public static WebDriver browserdriver;
	public static Properties profile = new Properties();
	public static String configfilepath = "C:\\Selenium_Coding_Ducat\\cucumberjavaselenium\\configfile\\url.properties";
	public static String signin_xpath = "//span[text()='Hello, sign in']";
	public static String continuebtn_xpath = "//span[@id='continue']";
	public static String signin_password_xpath = "//*[@id='signInSubmit']";

	public static void read_browser() throws IOException {
		FileInputStream fileread = new FileInputStream(configfilepath);
		profile.load(fileread);
		String readbrowser_name = profile.getProperty("Browser");
		System.out.println(readbrowser_name);

		String url_read = profile.getProperty("application_Url");
		System.out.println(url_read);

		if (readbrowser_name.contains("googlechrome")) {
			WebDriverManager.chromedriver().setup();
			browserdriver = new ChromeDriver();

			if (url_read.contains("https://www.amazon.in/")) {
				browserdriver.get(url_read);
				WebElement signinclick = browserdriver.findElement(By.xpath(signin_xpath));
				signinclick.click();
				String read_username = profile.getProperty("username");
				System.out.println(readbrowser_name);
				WebElement enterusername = browserdriver.findElement(By.name("email"));             // when signin amazon and then enter the  email.
				enterusername.sendKeys(read_username);
				WebElement clickcontinue = browserdriver.findElement(By.xpath(continuebtn_xpath));     // then click on the continue button
				clickcontinue.click();
				String read_password = profile.getProperty("password");                            // then enter the Password.
				System.out.println(readbrowser_name);
				WebElement enter_password = browserdriver.findElement(By.name("password"));
				enter_password.sendKeys(read_password);
				WebElement signin_password = browserdriver.findElement(By.xpath(signin_password_xpath));  // then you click signin button to open the amazon
				signin_password.click();

			}
		} else if (readbrowser_name.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			browserdriver = new FirefoxDriver();

			if (url_read.contains("https://www.amazon.in/")) {
				browserdriver.get(url_read);
			} else {
				System.out.println("Invalid url");
			}
		} else if (readbrowser_name.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			browserdriver = new EdgeDriver();

			if (url_read.contains("https://www.amazon.in/")) {
				browserdriver.get(url_read);
			} else {
				System.out.println("Invalid url");
			}
		} else {
			System.out.println("no browser find");
		}
	}

	public static void main(String[] args) throws IOException {
		read_browser();

	}

}
