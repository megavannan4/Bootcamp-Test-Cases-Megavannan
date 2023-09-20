package bootcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Account {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Step1- Launch the browser:
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Step2- Load the specified URL:
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step3- Login Salesforce:
		driver.findElement(By.id("username")).sendKeys("megavannan@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("automat4");
		driver.findElement(By.id("Login")).click();

		// Step4- Click on App Launcher toggle button:
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		// Step5- Click on the View All link:
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Step6- Type ‘Accounts’ in the search box and click:
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Accounts");
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark")).click();
		
		//Step8- Click on New button:
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@title='New']/div")).click();
		
		//Step9- Fill the mandatory fields:
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Cholamandal");
		driver.findElement(By.xpath("//label[text()='Type']/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[@title='Customer - Direct']")).click();
		
		//Step10- Click on Save button & Confirmation:
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement msgdisplay1 = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		String msgverify1 = msgdisplay1.getText();
		System.out.println(msgverify1);
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
		//Step11- Click on New contact:
		driver.findElement(By.xpath("//button[@name='NewContact']")).click();
		
		//Step12- Filling on the Mandatory fields:
		driver.findElement(By.xpath("//button[@name='salutation']")).click();
		driver.findElement(By.xpath("//span[@title='Mr.']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Michael");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Sertingon");
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("mserting@testmail.com");
		
		//Step13- Click on Save button & Confirmation:
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement msgdisplay2 = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		String msgverify2 = msgdisplay2.getText();
		System.out.println(msgverify2);
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
		//Step14- Account in detailed view:
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@data-label='Details']")).click();
		
		//Step15- Click on Delete button:
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']//lightning-primitive-icon[1]")).click();
		driver.findElement(By.xpath("//a[@name='Delete']")).click();
		
		//Step16- Confirming the deletion:
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		WebElement msgdisplay3 = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		String msgverify3 = msgdisplay3.getText();
		System.out.println(msgverify3);
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		
		//Step17- Navigate to Contacts tab:
		Thread.sleep(5000);
		WebElement contact = driver.findElement(By.xpath("//a[@title='Contacts']/span[@class='slds-truncate']"));
		driver.executeScript("arguments[0].click();",contact);
		
		//Step18- Search for deleted contacts:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='slds-input']")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Michael");
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(6000);
		WebElement msgdisplay4 = driver.findElement(By.xpath("//div[@role='status']/p"));
		String msgverify4 = msgdisplay4.getText();
		System.out.println(msgverify4);
		
	}

}
