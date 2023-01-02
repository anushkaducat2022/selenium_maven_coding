package seleniumelements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AmazonBaseConfigfile.Setup_configfilecode_basefile;

public class credentials_setup {
	public static WebDriver browserdriver;
	public static Properties profile = new Properties();
	public static String configfilepath = "C:\\Selenium_Coding_Ducat\\cucumberjavaselenium\\configfile\\url.properties";
	public static String signin_xpath = "//span[text()='Hello, sign in']";
	public static String signin_userdetails = "//span[text()='Hello, Anushka']";

	public static void credentials_username_set() throws IOException, InterruptedException {

		WebElement signinclick = Setup_configfilecode_basefile.browserdriver.findElement(By.xpath(signin_xpath));
		signinclick.click();
		Thread.sleep(10000);
		FileInputStream fileread = new FileInputStream(configfilepath);
		profile.load(fileread);
		String read_username = profile.getProperty("username");

		WebElement enterusername = Setup_configfilecode_basefile.browserdriver.findElement(By.name("email"));
		enterusername.sendKeys(read_username);
	}
     public static void credentials_password_set() throws IOException {

		WebElement continue_click =Setup_configfilecode_basefile. browserdriver.findElement(By.id("continue"));
		continue_click.click();
		FileInputStream fileread = new FileInputStream(configfilepath);
		profile.load(fileread);  
		String read_password = profile.getProperty("password");

		WebElement enter_password = Setup_configfilecode_basefile.browserdriver.findElement(By.name("password"));
		enter_password.sendKeys(read_password);
	}

	public static void click_login() throws InterruptedException {

		WebElement click_login = Setup_configfilecode_basefile.browserdriver.findElement(By.id("signInsubmit"));
		click_login.click();

	}
   public static void validate_username() throws InterruptedException 
	{
		Setup_configfilecode_basefile.browserdriver.navigate().refresh();
		Thread.sleep(20000);
		WebElement featuresdetails = Setup_configfilecode_basefile.browserdriver.findElement(By.xpath(signin_userdetails));
		String displayusername = featuresdetails.getText();
		System.out.println(displayusername);
	}

}

