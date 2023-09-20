package bootcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Lead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Step1- Launch the browser:
		ChromeDriver driver = new ChromeDriver(options );
		driver.manage().window().maximize();
		
		//Step2- Load the specified URL:
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step3- Login Salesforce:
		driver.findElement(By.id("username")).sendKeys("megavannan@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("automat4");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		
		//Step4- Click on App Launcher toggle button:
		driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(3000);
		
		//Step5- Click on the View All link:
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//Step6- Type ‘Marketing’ in the search box and click:
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Marketing");
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark")).click();
		
		//Step7- Navigate to the Leads tab:
		WebElement leadstab = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click();",leadstab);
		
		//Step8- Click on the New button:
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//Step9- Fill in all the mandatory fields:
		driver.findElement(By.xpath("//button[@name='salutation']")).click();
		driver.findElement(By.xpath("//span[@title='Mr.']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ridchard");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Norton");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Serrington");
		
		//Step10- Click on the Save button:
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//Confirmation message display:
		WebElement confmsg1 = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		String display1 = confmsg1.getText();
		System.out.println(display1);
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
		//Step11- Click on Convert Link:
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']//lightning-primitive-icon[1]")).click();
		WebElement opper = driver.findElement(By.xpath("//a[@name='Convert']"));
		driver.executeScript("arguments[0].click();",opper);
		//-------------------------------------------------------------------------------------------------------------------------------------
		//Notes:
		   //Issue
		   //For Step12- Opportunity Name input field, clear and enter a new opportunity name: as mentioned to clear the input field I tried to 
			//clear the values in input fields using below code. But it's not working fine
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementByXpath('(//button[@class='slds-button transparentButton'])[3]').clear;");
		
		
		//Codes for clearing the Opportunity name input field:
//		WebElement leadstab1 = driver.findElement(By.xpath("(//button[@class='slds-button transparentButton'])[3]"));
//		driver.executeScript("arguments[0].click();",leadstab1);
//		leadstab1.clear();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='slds-button transparentButton'])[3]"))).clear();
//	
//		driver.findElement(By.xpath("//span[text()='Opportunity Name']/following::input[4]")).clear();
//		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
//		
//		WebElement convo = driver.findElement(By.xpath("//div[@class='title']"));
//		String conmes = convo.getText();
//		System.out.println(conmes);
//		
//		driver.findElement(By.xpath("//button[text()='Go to Leads']")).click();
//		
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Ridchard",Keys.ENTER);
//		
//		WebElement items = driver.findElement(By.xpath("(//div[@role='status'])[3]"));
//		String itdis = items.getText();
//		System.out.println(itdis);
//		
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
//		
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Ridchard",Keys.ENTER);
		
		

	}

}
