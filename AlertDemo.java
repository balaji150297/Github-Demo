package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {
	public static String browser = "firefox";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		String AlertText = driver.switchTo().alert().getText();
		System.out.println(AlertText);
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Balaji");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
	}

}
